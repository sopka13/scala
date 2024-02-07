package containers

/**
 *  Maps
 *  val map_1 = Map[<key_type>, <value_type>]()
 */

import scala.annotation.tailrec
import scala.collection.mutable   // For mutable map

object Maps {
  def main(args: Array[String]): Unit = {
    // Create
    val map_1 = Map[Int, String]()          // immutable map
    val map_2 = mutable.Map[Int, String]()  // mutable map
    val map_3 = Map[Int, String](1 -> "first", 3 -> "second")
    val map_4 = Map("first" -> 1, "second" -> 2, "third" -> 3)
    val map_5 = Map(("first", 1), ("second", 2), ("third", 3))
    val map_6 = mutable.Map("first" -> 1, "second" -> 2, "third" -> 3)
    val map_7 = mutable.HashMap[Int, String]()
    val map_11 = Map("one" -> 1, "two" -> 2).withDefaultValue(0)  // create with add default value

    // Operations
    val var_0 = map_4("first")      // Get value
    // equivalent 2 methods
    val var_1 = if (map_4.contains("first")) map_4("first") else 0
    val var_2 = map_4.getOrElse("first", 0)

    val var_3 = map_4.get("first")                      // Get or return none (return Option)
    map_2 += (1 -> "First")                             // Add pair to mutable map
    map_6("zero") = 0                                   // Add pair to mutable map
    map_6 += ("some_1" -> 12, "some_2" -> 13)           // Add several pairs
    map_6 -= "some_1"                                   // Remove one pair
    val map_8 = map_3 + (0 -> "zero", 1 -> "firsted")   // Create new map from immutable map
    val map_9 = map_3 - 1                               // Create new map from immutable map

    // Traversing map elements
    for ((a, b) <- map_6) println(s"key: $a; value: $b")    // Keys and values
    for (a <- map_6.values) println(s"value: $a")           // Only values
    for (a <- map_6.keys) println(s"key: $a")               // Only keys

    val reverseMap = for((a, b) <- map_6) yield (b, a)      // Create reverse map key => value, value => key

    // Create map with sorted tree structure
    val treeMap_1 = scala.collection.immutable.SortedMap("zero" -> 0, "first" -> 1, "second" -> 2)
    val treeMap_2 = scala.collection.mutable.SortedMap("zero" -> 0, "first" -> 1, "second" -> 2)

    // Create map with save adding order
    val map_10 = scala.collection.mutable.LinkedHashMap("zero" -> 0)

    // Create map from 2 arrays
    val a_1 = Array("1", "2", "3")
    val a_2 = Array("first", "second", "third")
    val zipArr = a_1.zip(a_2)     // Array(("1", "first"), ("2", "second"), ("3", "third"))
    val mapFromTwoArr = a_1.zip(a_2).toMap
    for (elem <- mapFromTwoArr) println(s"key: ${elem._1}; value: ${elem._2}")

  }
}
