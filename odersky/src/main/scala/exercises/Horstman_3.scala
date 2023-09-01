package exercises

object Horstman_3 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, -2, 4, 5, -1, 0, 5, 3, -55, 3, 0, -1)

    val newArr = for (elem <- arr if elem > -1) yield elem
    val arrWithoutDouble = arr.distinct
    println(s"${arrWithoutDouble.mkString(", ")}")
  }
}
