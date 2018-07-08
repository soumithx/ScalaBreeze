import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.functions._
object movies {
  def removePipe:String => String = _.replace("|"," ")
  def removePipe_udf = udf(removePipe)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Soumith").master("local").getOrCreate()
    val readFile = spark.read.option("header","true").csv("/Users/soumith/Documents/ml-20m/movies.csv")
    //readFile.select("genres",regexp_replace)
    readFile.withColumn("genres",removePipe_udf(col("genres"))).show()
  }
}
