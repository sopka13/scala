package assertionsAndTests

object Main {

  def doubleInt(number: Int, lim: Int): Int = {
    println(s"doubleInt start: number = $number, limit = $lim")
    number * 2
  } ensuring(_ < lim, "doubleInt: limit exceeding")

  def main(args: Array[String]): Unit = {
    println(s"Assertions and test start")

    val arg_0 = "Hello"
    val arg_1 = "World"

    println(
      s"arg_0:  $arg_0\n" +
      s"arg_1:  $arg_1\n"
    )

    // Assert
    assert(arg_0.length == arg_1.length, "Compare length fail")
    println(s"assert success")

    // Assume
    assume(arg_0 == "Hello", "First arg not complete")
    println(s"assume success")

    // Require
    require(arg_0.length == 5, "First arg != 5")
    println(s"require success")

    // Ensuring
    doubleInt(2, 5)
    println(s"ensuring success")
  }
}
