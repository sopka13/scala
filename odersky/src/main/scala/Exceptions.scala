import java.io.FileNotFoundException

/*
    Exceptions
 */

object Exceptions {
  def handleArgs(args: Array[String]): Int = {
    args.length match {
      case 0 => throw new FileNotFoundException
      case 1 => throw new RuntimeException
      case _ => args.length
    }
  }

  def main(args: Array[String]): Unit = {
    // Create exception
    if (args.length == 12)
      throw new IllegalArgumentException(" I need args ! ")

    // Catching exceptions
    try {
      handleArgs(args)
    } catch {
      case ex: FileNotFoundException => println(s"${ex.toString}")
      case ex: RuntimeException => println(s"${ex.toString}")
      case _ => println(s"Unhandled exceptions")
    }
  }
}
