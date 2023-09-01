package exercises

object OderskyPractice {
  def main(args: Array[String]): Unit = {
    val a_0 = 12
    val a_1 = "Hello"
    val a_2 = new Rational(12)

    println("##:\n" +
      s"\t\ta_0(Int)\t = ${a_0.##}\n" +
      s"\t\ta_1(String)\t = ${a_1.##}\n" +
      s"\t\ta_2(Ratio.)\t = ${a_2.##}\n"
    )
    println("hashCode:\n" +
      s"\t\ta_0(Int)\t = ${a_0.hashCode()}\n" +
      s"\t\ta_1(String)\t = ${a_1.hashCode()}\n" +
      s"\t\ta_2(Ratio.)\t = ${a_2.hashCode()}\n"
    )
    println("toString:\n" +
      s"\t\ta_0(Int)\t = ${a_0.toString}\n" +
      s"\t\ta_1(String)\t = ${a_1.toString}\n" +
      s"\t\ta_2(Ratio.)\t = ${a_2.toString}\n"
    )
  }
}
