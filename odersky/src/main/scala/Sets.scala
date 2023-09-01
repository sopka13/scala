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
    // set_1 += "123"   // return new set(first, second, 123)
  }
}
