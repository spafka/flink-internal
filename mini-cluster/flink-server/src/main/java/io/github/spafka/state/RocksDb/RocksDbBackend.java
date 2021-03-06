package io.github.spafka.state.RocksDb;

import io.github.spafka.checkpoint.checkpoint;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.contrib.streaming.state.RocksDBStateBackend;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

import java.io.File;

import static io.github.spafka.Utils.getStreamEnv;

public class RocksDbBackend {


    public static void main(String[] args) throws Exception {


        //获取需要的端口号
        int port;
        try {
            ParameterTool parameterTool = ParameterTool.fromArgs(args);
            port = parameterTool.getInt("port");
        } catch (Exception e) {
            System.err.println("No port set. use default port 9000");
            port = 9999;
        }


        String CHECKPOINTS_DIRECTORY = "file:///tmp/state/checkpoint";
        String SAVEPOINT_DIRECTORY = "file:///tmp/state/savepoint";


        new File(CHECKPOINTS_DIRECTORY).deleteOnExit();
        new File(SAVEPOINT_DIRECTORY).deleteOnExit();




        //获取flink的运行环境
        StreamExecutionEnvironment env = getStreamEnv();

        // 每隔10000 ms进行启动一个检查点【设置checkpoint的周期】
        env.enableCheckpointing(10000);

        // 高级选项：
        // 设置模式为exactly-once （这是默认值）
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);

        // 确保检查点之间有至少500 ms的间隔【checkpoint最小间隔】
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(500);

        // 检查点必须在一分钟内完成，或者被丢弃【checkpoint的超时时间】
        env.getCheckpointConfig().setCheckpointTimeout(60000);

        // 同一时间只允许进行一个检查点
        env.getCheckpointConfig().setMaxConcurrentCheckpoints(1);

        // 表示一旦Flink处理程序被cancel后，会保留Checkpoint数据，以便根据实际需要恢复到指定的Checkpoint【详细解释见备注】
        //ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION:表示一旦Flink处理程序被cancel后，会保留Checkpoint数据，以便根据实际需要恢复到指定的Checkpoint
        //ExternalizedCheckpointCleanup.DELETE_ON_CANCELLATION: 表示一旦Flink处理程序被cancel后，会删除Checkpoint数据，只有job执行失败的时候才会保存checkpoint

        env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);


        //设置statebackend

        env.setStateBackend(new RocksDBStateBackend(CHECKPOINTS_DIRECTORY, true));

        String hostname = "localhost";
        String delimiter = "\n";
        //连接socket获取输入的数据
        DataStreamSource<String> text = env.socketTextStream(hostname, port, delimiter);

        // a a c

        // a 1
        // a 1
        // c 1
        DataStream<checkpoint.WordWithCount> windowCounts = text.flatMap(new FlatMapFunction<String, checkpoint.WordWithCount>() {
            @Override
            public void flatMap(String value, Collector<checkpoint.WordWithCount> out) throws Exception {
                String[] splits = value.split("\\s");
                for (String word : splits) {
                    out.collect(new checkpoint.WordWithCount(word, 1L));
                }
            }
        }).keyBy("word")
                .timeWindow(Time.seconds(20), Time.seconds(10))//指定时间窗口大小为2秒，指定时间间隔为1秒
                .sum("count");//在这里使用sum或者reduce都可以
                /*.reduce(new ReduceFunction<WordWithCount>() {
                                    public WordWithCount reduce(WordWithCount a, WordWithCount b) throws Exception {

                                        return new WordWithCount(a.word,a.count+b.count);
                                    }
                                })*/
        //把数据打印到控制台并且设置并行度
        windowCounts.print().setParallelism(1);

        //这一行代码一定要实现，否则程序不执行
        env.execute("Socket window count");

    }

    public static class WordWithCount {
        public String word;
        public long count;

        public WordWithCount() {
        }

        public WordWithCount(String word, long count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return "作者 : 秦凯新 , 窗大小2秒，滑动1秒       {" +
                    " word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}

