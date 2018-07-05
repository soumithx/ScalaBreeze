package com.s3.aws

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import org.apache.spark.sql.SparkSession

class s3Connect {
   val awsAccessKey = "AKIAJGTEJN5RIQ5FA5PA"
   val awsSecretKey = "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"
def initS3Client():AmazonS3Client={
      val credential = new BasicAWSCredentials(awsAccessKey,awsSecretKey)
      return  new AmazonS3Client(credential)
}

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("soumith").master("local").getOrCreate()
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key",awsAccessKey)
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key",awsSecretKey)
    spark.sparkContext.hadoopConfiguration.set("fs.s3.impl","org.apache.hadoop.fs.s3a.S3AFileSystem")
    val x = spark.read.csv("s3a://sparkscalap/movies.csv")
    x.show(2)
  }
}
