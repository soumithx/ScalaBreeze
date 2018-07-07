package com.soumith.spark
import org.apache.spark.sql.SparkSession
import org.apache.hadoop.fs.s3a.S3AFileSystem
 object amazons {
    def main(args: Array[String]): Unit = {

      val x = SparkSession.builder().appName("soumith").master("local").getOrCreate()
      x.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", "AKIAJUWRCOTDLUHPMVGA")
      x.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", "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")
      val y = new S3AFileSystem()

      //val a = new BasicAWSCredentials("AKIAJGTEJN5RIQ5FA5PA","GPyS8DlfvZfooR3f0T2le6bobra+iZYT1e1N1ewb")

      x.sparkContext.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
      // x.sparkContext.hadoopConfiguration.set("fs.s3.awsAccessKeyId",a.getAWSAccessKeyId)
      // x.sparkContext.hadoopConfiguration.set("fs.s3.awsSecretAccessKey",a.getAWSSecretKey)
      val d = x.read.option("header", "true").csv("s3a://sparkscalap/movies.csv")
      d.registerTempTable("soumith")
      val a = x.sql("select genres from soumith")
      a.show()
      //d.show()
    }
  }

