/*
      Functions
 */

package functions

object Main {
  def main(args: Array[String]): Unit = {
    // Fixed number of args
    def func_01(arg: Int): Unit = println(arg)
    // Variable number of args
    def func_02(args: Int*): Unit = args.foreach(arg => println(s"$arg, "))
    val func_03 = (x: Int) => x + 1
    val func_04 = (_: Int) + (_: Int)
    val func_05 = func_04(_, 3)

    func_01(12)
    func_02(1, 2, 3)
//    func_02(1 to 10) // ERROR
    func_02(1 to 10: _*)
    println(func_03(5))     // = 6
    println(func_04(1, 2))  // = 3
    println(func_05(1))     // = 4
  }
}
