package ch_03

import scala.collection.mutable.ArrayBuffer

object Main {
	def main(args: Array[String]): Unit = {
		// define arrays fix length
		val arr_1 = new Array[Int](3)
		println("arr_1 = " + arr_1.mkString("; "))
//		val arr_2 = new Array(3, 2, 12) // error
//		println("arr_2 = " + arr_2.mkString("; "))
		val arr_3 = Array(3, 2, 12) // error
		println("arr_3 = " + arr_3.mkString("; "))

		// change values
		arr_3(0) = 12
		println("arr_3 = " + arr_3.mkString("; "))

		// define arrays variable length
		val arr_4 = new ArrayBuffer[Int](3)
		println("arr_4 = " + arr_4.mkString("; "))
		val arr_5 = new ArrayBuffer[Int]()
		println("arr_5 = " + arr_5.mkString("; "))
		val arr_6 = ArrayBuffer(3, 4, 5)
		println("arr_6 = " + arr_6.mkString("; "))

		// change values
		arr_4 += (3)
		println("arr_4 = " + arr_4.mkString("; "))
		arr_4 += (4, 5, 6)
		println("arr_4 = " + arr_4.mkString("; "))
		arr_4 -= (3)
		println("arr_4 = " + arr_4.mkString("; "))
		arr_4 -= (5)
		println("arr_4 = " + arr_4.mkString("; "))
		arr_4(0) = 12
		println("arr_4 = " + arr_4.mkString("; "))

		// add other array
		arr_4 ++= Array(9, 10, 11)
		println("arr_4 = " + arr_4.mkString("; "))

		// insert and remove
		arr_4.insert(0, 100) // insert(position, value)
		println("arr_4 = " + arr_4.mkString("; "))
		arr_4.remove(4)
		println("arr_4 = " + arr_4.mkString("; "))
		arr_4.remove(0, 2) // remove(position, number)
		println("arr_4 = " + arr_4.mkString("; "))

		// array traversal
		val arr_7 = ArrayBuffer(0, 1, 2, 3, 4, 5, 6)
		for(i <- 0 until(arr_7.length)) print(s" $i: ${arr_7(i)};")
		println()
//		// in reverse order // don't work
//		for(i <- 0 until arr_7.length by -1) print(s" $i: ${arr_7(i)};")
//		println()
		// for every second
		for(i <- 0 until(arr_7.length, 2)) print(s" $i: ${arr_7(i)};")
		println()
		// for every third
		for(i <- 0 until(arr_7.length, 3)) print(s" $i: ${arr_7(i)};")
		println()
		// other method
		for(i <- arr_7.indices) print(s" $i: ${arr_7(i)};")
		println()
		for(i <- arr_7.indices.reverse) print(s" $i: ${arr_7(i)};")
		println()
		// without indices
		for(i <- arr_7) print(s" $i;")
		println()

		// array generator based on array
		val arr_8 = Array(1, 2, 3, 4, 5)
		val arr_9 = arr_8.reverse
		println(arr_9.mkString("; "))
		val arr_10 = for(i <- arr_8) yield i + 1
		println(arr_10.mkString("; "))
		// only for even (not for odd)
		val arr_11 = for(i <- arr_8 if i % 2 == 0) yield i
		println(arr_11.mkString("; "))

		// multidimensional array
		val arr_12 = new Array[Array[Int]](2)
		arr_12(0) = Array(1, 2, 3)
		arr_12(1) = Array(4, 5, 6, 7)
		println(s"arr_12 length = ${arr_12.length}, arr_12(0) = ${arr_12(0).mkString("; ")}; arr_12(1) = ${arr_12(1).mkString("; ")}")
		println(s"arr_12(1)(2) = ${arr_12(1)(2)}")
	}

}
