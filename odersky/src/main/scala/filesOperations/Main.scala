package filesOperations

import java.io.{File, FileInputStream, PrintWriter}
import scala.io.{BufferedSource, Source}

object Main {
  def printFileWithGetLines_0(filename: String): Unit = {
    val source = Source.fromFile(filename)
    for (str <- source.getLines()) println(str)
  }
  def printFileWithGetLines_1(filename: String): Unit = {
    val source = Source.fromFile(filename)
    val iterator = source.getLines()
    for (str <- iterator) println(str)
  }
  def getAllStrFromFileWithArray(filename: String): Array[String] = {
    val source = Source.fromFile(filename)
    source.getLines().toArray
  }
  def getAllStrFromFileWithString(filename: String): String = {
    try {
      val source = Source.fromFile(filename)
      val str = source.mkString
      source.close()
      str
    } catch {
      case _ => s"File $filename open error"
    }
  }
  def handleAllCharsInFile(filename: String): Unit = {
    try {
      val source = Source.fromFile(filename)
      val iter = source.buffered
      while (iter.hasNext) {
        if (iter.head == '\n') {
          println(s"\t|EndLine")
          iter.next()
        } else {
          print(iter.next())
        }
      }
      source.close()
    } catch {
      case _ => s"File $filename open error"
    }
  }
  def handleAllInts(filename: String): Unit = {
    try {
      val source = Source.fromFile(filename)
      for (elem <- source.mkString.split(" ")) {
          try {
            val p = elem.toInt
            println(s"Get number: $p")
          } catch {
            case _: NumberFormatException => println(elem)
          }
        }
      source.close()
    } catch {
      case _  => println(s"Bad filename")
    }
  }
  def readBinaryFile(filename: String): Unit = {
    try {
      val file = new File(filename)
      val in = new FileInputStream(file)
      val bytes = new Array[Byte](file.length.toInt)
      in.read(bytes)
      println(bytes.length)
      in.close()
    } catch {
      case _ => println(s"Bad filename")
    }
  }
  def writeInFile(filename: String, text: String): Unit = {
    try {
      val out = new PrintWriter(filename)
      out.println(text)
      out.close()
    } catch {
      case _ => println("Bad filename")
    }
  }

  def main(args: Array[String]): Unit = {
    // Get all file names from "." catalog
    val filesHere = (new File(".")).listFiles()
    for (name <- filesHere) println(name.getName)

//    printFileWithGetLines_1("build.sbt")
//    println(getAllStrFromFileWithArray("build.sbt").mkString(",\n"))
//    println(getAllStrFromFileWithString("build.sbt"))
//    handleAllCharsInFile("build.sbt")
//    handleAllInts("build.sbt")
//    readBinaryFile("build.sbt")
    writeInFile("newFile", "new text")
  }
}
