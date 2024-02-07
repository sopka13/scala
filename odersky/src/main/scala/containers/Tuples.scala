package containers

/**
 *  Tuples
 *  val tuple_1 = (1, 'a', "str")
 */

object Tuples {
  def main(args: Array[String]): Unit = {
    // Create
    val tuple_1: (Int, Char, String) = (1, 'a', "str")

    // Access to elems
    val first = tuple_1._1
    val second = tuple_1._2
  }
}
