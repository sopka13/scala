package cho_07

import java.io.{File, FileNotFoundException, FileReader, IOException}
import scala.io.Source

object Main {
	def main(args: Array[String]): Unit = {
		val fileName = if (args.isEmpty) "default.txt" else args(0)
		println(s"filename = $fileName")

		val filesHere = (new File(".")).listFiles
		for (name <- filesHere) println(name)
		println("---------")
		for (name <- filesHere if name.getName.startsWith(".")) println(name)
		println("---------")
		for (name <- filesHere if name.isDirectory;
				 dirs <- (new File(name.getPath)).listFiles if dirs.isDirectory) println(dirs)
		println("---------")
		for (name <- filesHere if name.isDirectory;
				 dirs <- (new File(name.getPath)).listFiles if dirs.isDirectory;
				 trimmed = dirs.getPath.trim if trimmed.matches("./.git/info")) println(trimmed)
		println("---------")
		for {name <- filesHere if name.isDirectory
				 dirs <- (new File(name.getPath)).listFiles if dirs.isDirectory
				 trimmed = dirs.getPath.trim if trimmed.matches("./.git/info")} println(trimmed)

		// exceptions
		// create exception
		val half = if (true) 12 else throw new RuntimeException("Hello")
		// try - catch
		try {
			val f = new FileReader("input.txt")
		} catch {
			case e: FileNotFoundException => println("first")
			case e: IOException => println("second")
		}
		// finally
		val path = getClass.getClassLoader.getResource("cho_07.txt").toURI
		val srce = Source.fromFile(path)
		try {
			println(srce.getLines().mkString)
		} catch {
			case e: FileNotFoundException => println("first")
			case e: IOException => println("second")
		} finally
			srce.close()

		// mach case
		fileName match {
			case "file.txt" => println(s"filename = file")
			case "default.txt" => println(s"filename = default")
			case _ => println(s"filensme = ???")
		}
		// return value
		val str: String = fileName match {
			case "file.txt" => "filename = file"
			case "default.txt" => "filename = default"
			case _ => "filename = ???"
		}
		println(str)
	}
}
