import org.apache.spark._
val sparkConf = new SparkConf().setAppName("HdfsTest")
val sc = new SparkContext(sparkConf)
val file = sc.textFile("hdfs://localhost:9000/CHANGES.txt")
val mapped = file.map(s => s.length).cache()
for (iter <- 1 to 10) {
   val start = System.currentTimeMillis()
   for (x <- mapped) { x + 2 }
   val end = System.currentTimeMillis()
    println("Iteration " + iter + " took " + (end-start) + " ms")
}
sc.stop()
