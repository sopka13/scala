/**
    Lists
    val list = List(1, 2, 3)

    1. Don't change elements
    2. Don't change size
 */

object Lists {
  def main(args: Array[String]): Unit = {
    // Create
    val list_1 = List(1, 2, 3)
    val list_2 = 4 :: 5 :: 6 :: Nil
    val list_23 = List.fill(4)("a") // List(a, a, a, a)

    // Concatenate
    val list_3 = list_1 ::: list_2  // => List(1, 2, 3, 4, 5, 6)

    // Add elements
    val list_4 = 0 :: list_1        // => List(0, 1, 2, 3)

    // Operations
    val elem_0 =    list_1.head                       // return first elem
    val elem_3 =    list_1.last                       // return last elem
    val list_13 =   list_1.tail                       // return new list without first elem
    val list_8 =    list_1.init                       // return new list without `last elem
    val list_27 =   List(1, 1, 2, 3, 4).distinct      // remove duplicate elements
    val list_5 =    list_1.drop(1)                    // create new list without first elems
    val list_6 =    list_1.dropRight(1)               // create new list without last elems
    val list_14 =   list_1.take(1)                    // create new list with 1 first elems
    val list_15 =   list_1.takeRight(1)               // create new list with 1 last elems
    val list_16_17= list_1.splitAt(2)                 // create 2 list: first list with 2 first elems and second list with other elems
    val elem_1 =    list_1(1)                         // return second elem
    val count_1 =   list_1.count(s => s > 0)          // return count of elements with condition
    val bool_1 =    list_1.exists(s => s > 1)         // return bool if complete condition
    val list_7 =    list_1.filter(s => s > 1)         // return new list with elems satisfying the condition
    val list_10 =   list_1.filterNot(s => s < 1)      // return new list with elems not satisfying the condition
    val list_25 =   List(List(1, 2), List(3, 4)).flatten  // return List(1, 2, 3, 4)
    val list_26 =   List(List(1, 2), List(3, 4)).flatMap(ls => ls.map(_ * 2)) // return List(2, 4, 6, 8)
    val list_24 =   list_1.withFilter(el => el > 20)  // return WithFilter entity
    val bool_2 =    list_1.forall(s => s < 10)        // return true if all elems satisfying the condition
    val int_0 =     List(1, 2, 3).fold(0)((a, b) => a * b) // return (((0 * 3) * 2) * 1) or (((0 * 3) * 1) * 2) or (((0 * 1) * 3) * 2) ...
    val int_1 =     List(1, 2, 3).foldLeft(0)((a, b) => a * b) // return (((0 * 1) * 2) * 3)
    val int_2 =     List(1, 2, 3).foldRight(0)((a, b) => a * b) // return (((0 * 3) * 2) * 1)
    val bool_3 =    list_1.isEmpty                    // return true if list is empty
    val length_1 =  list_1.length                     // return length of list
    val list_9 =    list_1.map(s => s + 1)            // return new list where every elem exec func
    val str_1 =     list_1.mkString(", ")             // return new string with every elem separated received str
    val lists_0 =   List(1, 2, 3, 4).partition(elem => elem % 2 == 0) // return (List(1, 3), List(2, 4))
    val list_11 =   list_1.reverse                    // return new reverse list
    val list_12 =   list_1.sortWith((s, t) => s > t)  // return sorted list
    val list_18 =   list_1.indices                    // return indices of list
    val list_19 =   List(list_1, list_2)              // return new list from received lists

    val list_20 =   list_1.zip(list_1.indices)        // return list of pair
    val list_21 =   list_1.zipWithIndex               // return list of pair (elem_0 -> index_0), ....
    val pair_0 =    list_20.unzip                     // return 2 list

    val list_22 =   List("one", "two", "three").flatMap(_.toList) // return List(o, n, e, t, w, o, ..... )

    val List(a, b, c) = list_2                        // a = 4, b = 5, c = 6
    val d :: rest =     list_2                        // a = 4, rest = List(5, 6)
  }
}
