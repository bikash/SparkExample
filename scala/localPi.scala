import scala.math.random

import org.apache.spark._
import org.apache.spark.SparkContext._
var count = 0
    for (i <- 1 to 100000) {
      val x = random * 2 - 1
      val y = random * 2 - 1
      if (x*x + y*y < 1) count += 1
    }
println("Pi is roughly " + 4 * count / 100000.0)