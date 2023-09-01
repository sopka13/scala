/*
    String type
 */

package types

object StringType {
  def main(args: Array[String]): Unit = {
    // Init
    val a: String = "First"
    val b = """Hello. This is spec char: \n"""

    // Operations
    val c =
      """|Hello
         |
         |""".stripMargin                       // Create string without tabs in start line
    val d = s"a: $a; b: $b"                     // String interpolations
    val e = raw"Without spec char \t \n ..."    // Without spec chars
    val f = f"${math.Pi}%.5f"                   // Printf style "3.14159"
    val a_1 = a.indexOf("i")                    // Return first index of received char
    val a_2 = a.toLowerCase                     // Return all chars in lower case
    val a_3 = a.toUpperCase                     // Return all chars in upper case

    //    println(s"a_1: $a_1; a_2: $a_2; a_3: $a_3")

    println(
      s"""a = "a"; b = "a"; a == b: ${val a = "a"; val b = "a"; a == b}\n""" +
      s"""a = "a"; b = "a"; a eq b: ${val a = "a"; val b = "a"; a eq b}\n""" +
      s"""a = "a"; b = "a"; a ne b: ${val a = "a"; val b = "a"; a ne b}\n""" +
      s"""a = new String("a"); b = new String("a"); a eq b: ${val a = new String("a"); val b = new String("a"); a eq b}\n""" +
      s"""a = new String("a"); b = new String("a"); a ne b: ${val a = new String("a"); val b = new String("a"); a ne b}\n""" +
      s"\n"
    )
  }
}
