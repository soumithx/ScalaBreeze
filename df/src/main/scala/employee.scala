import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.RDD

// Here,main goal of this code to get top key words which are repeated in a given text
object employee {
  def findKeyValueByValue[K, V](map: Map[K, V], value: V): Option[(K, V)] =
    map.collectFirst { case kv @ (_, v) if v == value => kv }
  def main(args: Array[String]): Unit = {
  val conf = new SparkConf()
  val rootLogger = Logger.getRootLogger
  rootLogger.setLevel(Level.OFF)
  conf.setAppName("Soumith").setMaster("local")
  val sc = new SparkContext(conf)
  val data = sc.textFile("/Users/soumith/Documents/Soumith_DOCS/test/data.txt")
  val dataFMap = data.flatMap(word => word.split(" "))
  val dataMap = dataFMap.map(x => (x, 1))
  val dataReduce = dataMap.reduceByKey(_+_)
    val dataswap  = dataReduce.map(item => item.swap)
    val datasort = dataswap.sortByKey( false)
    val dataswso = datasort.map(item => item.swap)
    dataswso.take(2).foreach(println)

  //var maxValue = dataReduce.values.max()


  //val d = dataReduce.filter{case (x,y) =>   y == maxValue }

  }
}