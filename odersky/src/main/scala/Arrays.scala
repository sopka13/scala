import scala.collection.mutable.ArrayBuffer

/*
    Arrays
    val arr = new Array[<type>](<capacity>)
    1. Don't change capacity
    2. May change elements
    3. Don't change type

    val arr = new ArrayBuffer[<type](<capacity>)
    1. May change capacity
    2. May change elements
    3. Don't change type
 */
object Arrays {
  def main(args: Array[String]): Unit = {
    // Create:
//    val arr_0 = new Array[Int]()    // ERROR
    val arr_1 = new Array[String](2)
    val arr_2 = Array("First", "Second")
    val arr_3 = Array.empty

    val arr_4 = new ArrayBuffer[Int]()
    val arr_5 = new ArrayBuffer[String](2)
    val arr_6 = ArrayBuffer("Some", "String")
    val arr_7 = ArrayBuffer.empty
    val arr_8 = Array("Hello")

    // Use examples Array
    val str_1 = arr_2(0)  // get first elem

    // Use examples ArrayBuffer
    arr_4 += 1                // Add one element
    arr_4 += (2, 3, 4)        // Add several elements
    arr_4 ++= Array(5, 6, 7)  // Add some collections
    arr_4.trimToSize()        // Trim arr size to the numbers of elements contained
    arr_4.trimEnd(1)          // Remove 1 last elem
    arr_4.trimStart(1)        // Remove 1 first elem
    arr_4.insert(2, 0)        // Insert one elem
    arr_4.insertAll(3, Array(0, 0, 0))  // Insert several elements
    arr_4.remove(2)           // Remove one element and return it
    arr_4.remove(2, 3)        // Remove several elements and return Unit
    val arr = arr_4.toArray   // Create Array from ArrayBuffer
    val arrBuf = arr.toBuffer // Create ArrayBuffer from Array

    // Traversing array elements
    for (i <- 0 until arr_4.length)
      print(arr_4(i) + ", ")
    println()
    // Only even elements
    for (i <- 0 until (arr_4.length, 2))
      print(arr_4(i) + ", ")
    println()
    // Reverse
    for (i <- (0 until arr_4.length).reverse)
      print(arr_4(i) + ", ")
    println()
    // Without indices
    for (elem <- arr_4)
      print(elem + ", ")
    println()

    // Functions
    val newArr = Array(1, 2, 3, 4, 5)
    val newArr_1 = newArr.filter(elem => elem % 2 == 0)     // Add new Array with elements after exec condition
    val newArr_2 = newArr.map(elem => elem * 2)             // Add new Array after exec func for all elems
    val sumElem = newArr.sum                                // Sum all elems
    val minElem = newArr.min                                // Return min elem
    val maxElem = newArr.max                                // Return Max elem
    val sortArr_1 = newArr.sorted                           // Return new sorted Array
    val sortArr_2 = newArr.sortWith((l1, l2) => l1 > l2)    // Return new Arr with condition
    val str_2 = newArr.mkString                             // Return str with all elems from Array
    val str_3 = newArr.mkString("<", ", ", ">")             // Return str with all elems from Array with delimiters
    val newArr_3 = arr_4.append(3)                          // Add elem to the end of the ArrayBuffer
    val newArr_4 = arr_4.appendAll(Array(1, 1, 1, 1, 1))    // Add new elems to the end
    val var_0 = newArr_4.count(elem => elem == 1)           // Count of elems with condition
    newArr_4 += 3                                           // Add elem to the end
    newArr_4.copyToArray(newArr)                            // Copi elems to receiver arr from affBuff
    val newArr_5 = newArr_4.padTo(30, 1)                    // Create new arr with received size
    val newArr_6 = newArr_5.distinct                        // Remove duplicate values

    println("end: " + newArr_5.mkString(", "))
  }
}
