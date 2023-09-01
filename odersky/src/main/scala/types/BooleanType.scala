/*
    Boolean type
 */

package types

object BooleanType {
  def main(args: Array[String]): Unit = {
    val a: Boolean = true

    println(s"Boolean type:\n" +
      s"\tsize:     $a\n" +
      s"\ttoString: ${a.toString()}\n")
  }
}
