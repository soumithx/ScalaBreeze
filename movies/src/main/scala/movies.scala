import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.functions._
import org.apache.log4j.Logger
import org.apache.log4j.Level

object movies {
  def removePipe:String => String = _.replace("|"," ")
  def removePipe_udf = udf(removePipe)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Soumith").master("local").getOrCreate()
    Logger.getLogger("org").setLevel(Level.OFF)
    val readFile = spark.read.option("header","true").csv("/Users/soumith/Documents/ml-20m/movies.csv")
   //  readFile.show()
    val noPipe = readFile.withColumn("genres",removePipe_udf(col("genres"))).withColumn("title",regexp_extract(col("title"),"[0-9][0-9][0-9][0-9]",0))
    noPipe.registerTempTable("Pipe")
    val noP = spark.sql("select movieId,title as year,genres from Pipe")
    //noP.show()
    //val x = readFile.withColumn("title",regexp_extract(col("title"),"[0-9][0-9][0-9][0-9]",0))
    val title = readFile.withColumn("title",regexp_extract(col("title"),"\\w*\\s\\w*",0))
    title.registerTempTable("title")
    val titl = spark.sql("select movieId,title  from title")
    //titl.show()
    val PJoin = noP.toDF("movieId","year","genres")
    val df = PJoin.join(titl,"movieId")
    df.registerTempTable("finall")
       spark.sql("select title from finall where year = '1998'").show()

  }
}
