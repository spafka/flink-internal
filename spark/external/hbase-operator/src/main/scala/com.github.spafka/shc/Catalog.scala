package com.github.spafka.shc

import scala.util.Random

object Catalog {

  val schema =
    s"""{
       |   "table":{"namespace":"default", "name":"_GPS", "tableCoder":"PrimitiveType"},
       |   "rowkey":"key",
       |   "columns":{
       |       "rowkey":{"cf":"rowkey", "col":"key", "type":"int"},
       |       "lat":{"cf":"info", "col":"lat", "type":"int"},
       |       "lng":{"cf":"info", "col":"lng", "type":"int"}
       |   }
       |}""".stripMargin


  val errcrSchema =
    s"""{
       |   "table":{"namespace":"default", "name":"_error", "tableCoder":"PrimitiveType"},
       |   "rowkey":"key",
       |   "columns":{
       |   "key":{"cf":"rowkey", "col":"key", "type":"string"},
       |"col1":{"cf":"info", "col":"col1", "type":"int"},
       |"col2":{"cf":"info", "col":"col2", "type":"int"},
       |"col3":{"cf":"info", "col":"col3", "type":"int"},
       |"col4":{"cf":"info", "col":"col4", "type":"int"},
       |"col5":{"cf":"info", "col":"col5", "type":"int"},
       |"col6":{"cf":"info", "col":"col6", "type":"int"},
       |"col7":{"cf":"info", "col":"col7", "type":"int"},
       |"col8":{"cf":"info", "col":"col8", "type":"int"},
       |"col9":{"cf":"info", "col":"col9", "type":"int"},
       |"col10":{"cf":"info", "col":"col10", "type":"int"},
       |"col11":{"cf":"info", "col":"col11", "type":"int"},
       |"col12":{"cf":"info", "col":"col12", "type":"int"},
       |"col13":{"cf":"info", "col":"col13", "type":"int"},
       |"col14":{"cf":"info", "col":"col14", "type":"int"},
       |"col15":{"cf":"info", "col":"col15", "type":"int"},
       |"col16":{"cf":"info", "col":"col16", "type":"int"},
       |"col17":{"cf":"info", "col":"col17", "type":"int"},
       |"col18":{"cf":"info", "col":"col18", "type":"int"},
       |"col19":{"cf":"info", "col":"col19", "type":"int"},
       |"col20":{"cf":"info", "col":"col20", "type":"int"},
       |"col21":{"cf":"info", "col":"col21", "type":"int"},
       |"col22":{"cf":"info", "col":"col22", "type":"int"},
       |"col23":{"cf":"info", "col":"col23", "type":"int"},
       |"col24":{"cf":"info", "col":"col24", "type":"int"},
       |"col25":{"cf":"info", "col":"col25", "type":"int"},
       |"col26":{"cf":"info", "col":"col26", "type":"int"},
       |"col27":{"cf":"info", "col":"col27", "type":"int"},
       |"col28":{"cf":"info", "col":"col28", "type":"int"},
       |"col29":{"cf":"info", "col":"col29", "type":"int"},
       |"col30":{"cf":"info", "col":"col30", "type":"int"},
       |"col31":{"cf":"info", "col":"col31", "type":"int"},
       |"col32":{"cf":"info", "col":"col32", "type":"int"},
       |"col33":{"cf":"info", "col":"col33", "type":"int"},
       |"col34":{"cf":"info", "col":"col34", "type":"int"},
       |"col35":{"cf":"info", "col":"col35", "type":"int"},
       |"col36":{"cf":"info", "col":"col36", "type":"int"},
       |"col37":{"cf":"info", "col":"col37", "type":"int"},
       |"col38":{"cf":"info", "col":"col38", "type":"int"},
       |"col39":{"cf":"info", "col":"col39", "type":"int"},
       |"col40":{"cf":"info", "col":"col40", "type":"int"},
       |"col41":{"cf":"info", "col":"col41", "type":"int"},
       |"col42":{"cf":"info", "col":"col42", "type":"int"},
       |"col43":{"cf":"info", "col":"col43", "type":"int"},
       |"col44":{"cf":"info", "col":"col44", "type":"int"},
       |"col45":{"cf":"info", "col":"col45", "type":"int"},
       |"col46":{"cf":"info", "col":"col46", "type":"int"},
       |"col47":{"cf":"info", "col":"col47", "type":"int"},
       |"col48":{"cf":"info", "col":"col48", "type":"int"},
       |"col49":{"cf":"info", "col":"col49", "type":"int"},
       |"col50":{"cf":"info", "col":"col50", "type":"int"},
       |"col51":{"cf":"info", "col":"col51", "type":"int"},
       |"col52":{"cf":"info", "col":"col52", "type":"int"},
       |"col53":{"cf":"info", "col":"col53", "type":"int"},
       |"col54":{"cf":"info", "col":"col54", "type":"int"},
       |"col55":{"cf":"info", "col":"col55", "type":"int"},
       |"col56":{"cf":"info", "col":"col56", "type":"int"},
       |"col57":{"cf":"info", "col":"col57", "type":"int"},
       |"col58":{"cf":"info", "col":"col58", "type":"int"},
       |"col59":{"cf":"info", "col":"col59", "type":"int"},
       |"col60":{"cf":"info", "col":"col60", "type":"int"},
       |"col61":{"cf":"info", "col":"col61", "type":"int"},
       |"col62":{"cf":"info", "col":"col62", "type":"int"},
       |"col63":{"cf":"info", "col":"col63", "type":"int"},
       |"col64":{"cf":"info", "col":"col64", "type":"int"},
       |"col65":{"cf":"info", "col":"col65", "type":"int"},
       |"col66":{"cf":"info", "col":"col66", "type":"int"},
       |"col67":{"cf":"info", "col":"col67", "type":"int"},
       |"col68":{"cf":"info", "col":"col68", "type":"int"},
       |"col69":{"cf":"info", "col":"col69", "type":"int"},
       |"col70":{"cf":"info", "col":"col70", "type":"int"},
       |"col71":{"cf":"info", "col":"col71", "type":"int"},
       |"col72":{"cf":"info", "col":"col72", "type":"int"},
       |"col73":{"cf":"info", "col":"col73", "type":"int"},
       |"col74":{"cf":"info", "col":"col74", "type":"int"},
       |"col75":{"cf":"info", "col":"col75", "type":"int"},
       |"col76":{"cf":"info", "col":"col76", "type":"int"},
       |"col77":{"cf":"info", "col":"col77", "type":"int"},
       |"col78":{"cf":"info", "col":"col78", "type":"int"},
       |"col79":{"cf":"info", "col":"col79", "type":"int"},
       |"col80":{"cf":"info", "col":"col80", "type":"int"},
       |"col81":{"cf":"info", "col":"col81", "type":"int"},
       |"col82":{"cf":"info", "col":"col82", "type":"int"},
       |"col83":{"cf":"info", "col":"col83", "type":"int"},
       |"col84":{"cf":"info", "col":"col84", "type":"int"},
       |"col85":{"cf":"info", "col":"col85", "type":"int"},
       |"col86":{"cf":"info", "col":"col86", "type":"int"},
       |"col87":{"cf":"info", "col":"col87", "type":"int"},
       |"col88":{"cf":"info", "col":"col88", "type":"int"},
       |"col89":{"cf":"info", "col":"col89", "type":"int"},
       |"col90":{"cf":"info", "col":"col90", "type":"int"},
       |"col91":{"cf":"info", "col":"col91", "type":"int"},
       |"col92":{"cf":"info", "col":"col92", "type":"int"},
       |"col93":{"cf":"info", "col":"col93", "type":"int"},
       |"col94":{"cf":"info", "col":"col94", "type":"int"},
       |"col95":{"cf":"info", "col":"col95", "type":"int"},
       |"col96":{"cf":"info", "col":"col96", "type":"int"},
       |"col97":{"cf":"info", "col":"col97", "type":"int"},
       |"col98":{"cf":"info", "col":"col98", "type":"int"},
       |"col99":{"cf":"info", "col":"col99", "type":"int"},
       |"col100":{"cf":"info", "col":"col100", "type":"int"}
       |   }
       |}""".stripMargin


  def main(args: Array[String]): Unit = {
    1 to 200 foreach (
      x => {
        //        println(
        //          s""""col${x}":{"cf":"info", "col":"col${x}", "type":"int"},""".stripMargin)

        println(s""" new Random().nextInt(100),""".stripMargin)

      }
      )
  }
}


case class errorr(key: String,
                  col1: Int,
                  col2: Int,
                  col3: Int,
                  col4: Int,
                  col5: Int,
                  col6: Int,
                  col7: Int,
                  col8: Int,
                  col9: Int,
                  col10: Int,
                  col11: Int,
                  col12: Int,
                  col13: Int,
                  col14: Int,
                  col15: Int,
                  col16: Int,
                  col17: Int,
                  col18: Int,
                  col19: Int,
                  col20: Int,
                  col21: Int,
                  col22: Int,
                  col23: Int,
                  col24: Int,
                  col25: Int,
                  col26: Int,
                  col27: Int,
                  col28: Int,
                  col29: Int,
                  col30: Int,
                  col31: Int,
                  col32: Int,
                  col33: Int,
                  col34: Int,
                  col35: Int,
                  col36: Int,
                  col37: Int,
                  col38: Int,
                  col39: Int,
                  col40: Int,
                  col41: Int,
                  col42: Int,
                  col43: Int,
                  col44: Int,
                  col45: Int,
                  col46: Int,
                  col47: Int,
                  col48: Int,
                  col49: Int,
                  col50: Int,
                  col51: Int,
                  col52: Int,
                  col53: Int,
                  col54: Int,
                  col55: Int,
                  col56: Int,
                  col57: Int,
                  col58: Int,
                  col59: Int,
                  col60: Int,
                  col61: Int,
                  col62: Int,
                  col63: Int,
                  col64: Int,
                  col65: Int,
                  col66: Int,
                  col67: Int,
                  col68: Int,
                  col69: Int,
                  col70: Int,
                  col71: Int,
                  col72: Int,
                  col73: Int,
                  col74: Int,
                  col75: Int,
                  col76: Int,
                  col77: Int,
                  col78: Int,
                  col79: Int,
                  col80: Int,
                  col81: Int,
                  col82: Int,
                  col83: Int,
                  col84: Int,
                  col85: Int,
                  col86: Int,
                  col87: Int,
                  col88: Int,
                  col89: Int,
                  col90: Int,
                  col91: Int,
                  col92: Int,
                  col93: Int,
                  col94: Int,
                  col95: Int,
                  col96: Int,
                  col97: Int,
                  col98: Int,
                  col99: Int,
                  col100: Int
              )

object errorr {
  def apply(key: String): errorr = new errorr(
    key,
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100),
    new Random().nextInt(100)
  )
}