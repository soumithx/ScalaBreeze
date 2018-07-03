package com.soumith.scala
import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf,SparkContext}

object example {
def main(args:Array[String])={
  val conf = new SparkConf()
  conf.setAppName("soumith").setMaster("local")
  val sc = new SparkContext(conf)
  val d = sc.textFile("/Users/soumith/Downloads/test.txt")
  val e = d.flatMap(x => x.split(" "))
  val f = e.map(x => (x,1))
  val g = f.reduceByKey(_+_)
  g.saveAsTextFile("/Users/soumith/output.txt")

}
}
