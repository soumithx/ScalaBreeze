import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.log4j.{Logger,Level}


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
  var maxValue = dataReduce.values.max()
  val d = dataReduce.filter{case (x,y) =>   y == maxValue }
    d.foreach(println)

  //val d = dataReduce.map{ case(_,y)=>   y == maxValue }

  }
}