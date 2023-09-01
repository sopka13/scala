import java.io.File
import sys.process._

object CLIinterface {
  def main(args: Array[String]): Unit = {
    // Exec command and return value
    val ret_0 = "ls -al ..".!
    println(s"ret value = $ret_0")  // ret value = 0

    // Exec and return result
    val result = "ls".!!
    println(result)

    // pipe
    val ret_1 = "ls".#|("""grep "src" """).!

    //
    val ret_2 = "ls" #> new File("newFile")
    val ret_3 = "ls" #>> new File("newFile")
  }
}
