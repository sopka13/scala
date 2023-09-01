import java.io.IOException
import java.net.{MalformedURLException, URL}
import javax.naming.MalformedLinkException

object Syntax {
  def main(args: Array[String]): Unit = {
    // the three entries are equivalent:
    val var_1 = new Array[String](2)
    var_1(0) = "First"
    var_1(1) = "Second"
    val var_2 = Array("First", "Second")
    val var_3 = Array.apply("First", "Second")

    // the two entries are equivalent:
    println(s"${var_1(0)}")
    println(s"${var_1.apply(0)}")

    // the two entries are equivalent:
    var_1(0) = "Some"
    var_1.update(0, "Some")

    // block value
    val var_4 = {val a = 12; val b = 6; a / b}
    println(var_4)

    // lazy vals
    lazy val fileData = scala.io.Source.fromFile("some/file/name.txt").mkString
    // This value init before fist use, not earlier

    // Exceptions
    throw new IllegalArgumentException("some message")
    try {
      val url = new URL("https://some.http.addres")
      url.getContent()
    } catch {
      case _: MalformedURLException => println("URL error")
      case ex: IOException => ex.printStackTrace()
    }
    try {
      // some operations
    } catch {
      // exceptions handlers
      case _ => println("some message")
    } finally {
      // close files or others
    }
  }

  // Functions
  def func_1                                  = 1
  def func_2(arg_0: Int, arg_1: Int)          = arg_0 + arg_1
  def func_3(arg_0: Int, arg_1: Int): Int     = arg_0 + arg_1
  def func_4(arg_0: Int = 1, arg_1: Int = 2)  = if (arg_0 > 0) arg_0 + arg_1 else -arg_0 + arg_1
  def func_5(args: Int*): Unit                = for (arg <- args) println(arg)

  // Call functions
  func_1
  func_2(1, 2)
  func_3(arg_1 = 1, arg_0 = 2)
  func_4()
  func_4(3, 4)
  func_5(1)
  func_5(1, 2, 3)
  func_5(1 to 5: _*)

  // Procedures
  def proc_1                      { println("Hello") }
  def proc_2(str: String)         { println(str) }
  def proc_3(str: String): Unit = {
    println(str)
  }
  def proc_4(str: String = "Hi")  { println(str) }
}
