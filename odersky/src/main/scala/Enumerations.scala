import Enumerations.Colors_0.{ red_0, yellow_0, green_0 }
import Enumerations.Colors_1.{ yellow_1, red_1, green_1 }

object Enumerations {
  object Colors_0 extends Enumeration {
    // type = Colors_0.Value
    val yellow_0, red_0, green_0 = Value
  }

  val first_0 = yellow_0
  val second_0 = red_0
  val third_0 = green_0

  object Colors_1 extends Enumeration {
    type Colors_1 = Value     // For create Colors_1 type
    val yellow_1 = Value(0, "one")
    val red_1 = Value(1)
    val green_1 = Value("three")
  }

  val first_1 = yellow_1
  val second_1 = red_1
  val third_1 = green_1

  def main(args: Array[String]): Unit = {
    println(
      s"f_0 str = ${first_0.toString}" + '\n' +     // = yellow_0
      s"f_0 id = ${first_0.id}" + '\n' +            // = 0
      s"f_0 hc = ${first_0.hashCode()}" + '\n' +    // = 0
      s"f_1 str = ${first_1.toString}" + '\n' +     // = one
      s"f_1 id = ${first_1.id}" + '\n' +            // = 0
      s"f_1 hc = ${first_1.hashCode()}" + '\n' +    // = 0
      s"s_1 str = ${second_1.toString}" + '\n' +    // = red_1
      s"s_1 id = ${second_1.id}" + '\n' +           // = 1
      s"s_1 hc = ${second_1.hashCode()}" + '\n' +   // = 1
      s"t_1 str = ${third_1.toString}" + '\n' +     // = three
      s"t_1 id = ${third_1.id}" + '\n' +            // = 2
      s"t_1 hc = ${third_1.hashCode()}"             // = 2
    )

    for (elem <- Colors_0.values) println(elem)

    val some_0 = Colors_1.withName("three")   // return elem
    val sobe_1 = Colors_1(0)                  // return elem
  }
}
