import  org.apache.spark
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object  test{
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setAppName("Soumith").setMaster("local")
    val sc = new SparkContext(conf)
    val x = sc.textFile("/Users/soumith/Downloads/soccer.txt")
    val y = x.map(l => (l.split(" ")(0),l.split(" ")(1).toInt))
    y.groupByKey().mapValues(a => a.reduce((a,b) => (a+b))).foreach(println)
    }
  }
