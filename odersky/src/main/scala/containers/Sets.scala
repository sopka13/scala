package containers

/*
    Sets
    val set_1 = Set("first", "second")

 */

import scala.collection.mutable // for mutable set

object Sets {
  def main(args: Array[String]): Unit = {
    // Create
    val set_1 = Set("first", "second")          // don't mutable set
    val set_2 = mutable.Set("first", "second")  // mutable set

    // Operations
    val set_3 = set_1 + "123"   // return new set(first, second, 123)
    val set_4 = set_1 - "first" // return new set(second)
    val length = set_3.size         // get size
    val bul = set_4.contains("123") // search value
  }
}
