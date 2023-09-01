package exercises

object Temp {
  def main(args: Array[String]): Unit = {
    val a = new Rational(1, 2)
    val b = new Rational(2, 3)

    val c = a + b
    println(c.toString)
  }
}
