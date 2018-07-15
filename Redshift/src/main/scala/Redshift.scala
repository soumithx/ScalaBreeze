import org.apache.spark.sql.SparkSession
import org.apache.hadoop.fs.s3a.S3AFileSystem
import com.databricks.spark.redshift


  object Redshift {
    def main(args: Array[String]): Unit = {
      val spark = SparkSession.builder().appName("binnu").master("local").getOrCreate()
      spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", "XXXXXX")
      spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", "XXXXXXXXXXXXXXXXXX")
      spark.sparkContext.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")

      val jdbcURL = "jdbc:redshift://soumith.cau6uibyjdl8.us-west-2.redshift.amazonaws.com:5439/soumith?user=soumith&password=Soumithsai48"
      val tempS3dir = "s3a://samplesparkk/temp/"
      val df = spark.read.format("com.databricks.spark.redshift").option("forward_spark_s3_credentials", "true").option("url", jdbcURL).option("tempdir", tempS3dir).option("query", "select * from registe").load()
      df.show()
    }



}
