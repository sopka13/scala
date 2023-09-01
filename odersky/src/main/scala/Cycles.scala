import scala.util.control.Breaks.{break, breakable}

/*
    Cycles
 */

object Cycles {
  def main(args: Array[String]): Unit = {
  }

  def first(args: Array[String]): Unit = {
    // C style
    var i = 0
    while(i < args.length) {
      println(args(i))
      i += 1
    }

    // One more variant
    args.foreach(println)

    // For
    for (k <- args)
      println(k)
    for (i <- 0 to 10)
      println(i)
    // Print all chars
    for (ch <- "Hello")
    print(ch)
    // indices
    val str = "Hello"
    for (i <- str.indices)
      print(str(i))
    for (i <- 0 until str.length)
      print(str(i))

    // Create new array/sequences
    val newArr = for (elem <- args) yield elem + ";"
    println(newArr)
    val newVector = for (i <- 0 to 12) yield i
    println(newVector)

    // Breakable cycle
    breakable {
      for (i <- 0 to 10) {
        if (i == 5) break
        println(i)
      }
    }

    // Difficult conditions
    for (i <- 1 to 3; k <- 1 to 3 if i != k)
      print((i * 10 + k) + ", ") // $> 12, 13, 21, 23, 31, 32,
    for (i <- 1 to 3; f = 0; l = 2; k <- f to l)
      print((i * 10 + k) + ", ") // $> 10, 12, 20, 21, 30, 31, 32,
    for { i <- 1 to 3
          f = 0
          l = 2
          k <- f to l}
      print((i * 10 + k) + ", ") // $> 10, 12, 20, 21, 30, 31, 32,

  }
}
