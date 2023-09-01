package ch_04

import java.util

object Main {
	def main(args: Array[String]): Unit = {
		// Associative arrays
		// create immutable
		val arr_01 = Map("Alice" -> 12, "Bob" -> 13, "Ken" -> 14)
		println(s"arr_01 = ${arr_01.toString}")
		val arr_011 = Map(("Alice", 12), ("Bob", 13), ("Ken", 14))
		println(s"arr_011 = ${arr_011.toString}")

		// create mutable
		val arr_02 = scala.collection.mutable.Map("First" -> 1, "Second" -> 2)
		println(s"arr_02 = ${arr_02.toString}")

		// create empty map
		val arr_03 = new scala.collection.mutable.HashMap[String, Int]
		println(s"arr_03 = ${arr_03.toString}")

		// get value
		val val_01 = arr_01("Alice")
		println(s"val_01 = $val_01")

		// value check
		val val_02 = arr_01.contains("Alice")
		println(s"val_02 = $val_02")
		val val_03 = arr_01.getOrElse("Alice", 0) // get value or return 0 if don't have
		println(s"val_03 = $val_03")

		// add values and change values
		arr_02("First") = 100 // change value
		arr_02("Third") = 3 // add pair
		arr_02 += ("Fourth" -> 4, "Fifth" -> 5) // add multiple values
		println(s"arr_02 = ${arr_02.toString}")
		arr_02 -= ("First") // remove value
		val arr_04 = arr_02 - ("Second") // remove value and create new arr
		println(s"arr_04 = ${arr_04.toString}")

		// map traversal
		for((a, b) <- arr_02) print(s"$b; ")
		println()
		// get keys
		val arr_05 = arr_02.keySet
		println(s"arr_05 = ${arr_05.toString}")
		// get values
		val arr_06 = arr_02.values
		println(s"arr_06 = ${arr_06.toString}")

		// Map - use hash table
		// SortedMap - use binary tree
		// LinkedHashMap - use binary tree sorted by adding order

		// create Scala map from Java map
//		import scala.collection.JavaConverters.mapAsScalaMap
//		val arr_07: scala.collection.mutable.Map[String, Int] =
//			new util.TreeMap[String, Int]

		// tuples
		val tuple_01 = (1, 1.12, "Hello")
		println(s"tuple_01 = ${tuple_01.toString()}")
		println(s"tuple_01(1) = ${tuple_01._1}")

		// zip function
		val tuple_02 = Array(1, 2, 3, 4, 5, 6)
		val tuple_03 = Array('A', 'B', 'C', 'D', 'E', 'F')
		val pairs = tuple_02.zip(tuple_03) // return Array of pairs
		val map = pairs.toMap // create map from array of pairs
		println(s"map = ${map.toString()}")
	}
}
