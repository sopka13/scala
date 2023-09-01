package cho_03

import scala.io.Source

object Main {
	def main(args: Array[String]): Unit ={
		// lists
		// create
		val list_01 = List("123", "123")
		println(s"list_01 = ${list_01.toString()}")
		val list_02 = List("444", "555")
		val list_03 = list_01 ::: list_02
		println(s"list_03 = ${list_03.toString()}")
		val list_04 = 1 :: 2 :: 3 :: 4 :: Nil
		println(s"list_04 = ${list_04.toString()}")
		val list_05 = list_01.::("HeHe")
		println(s"list_05 = ${list_05.toString()}")
		val list_06 = "Hello" :: list_01
		println(s"list_06 = ${list_06.toString()}")

		// change values
		//		list_01(1) = "222" // error
		//		list_01 += "222" // error

		// read file
		val path = getClass.getClassLoader.getResource("cho_03.txt").toURI
		val source = Source.fromFile(path)
		for(str <- source.getLines()) println(str)
		source.close()
		val source_2 = Source.fromFile(path)
		val listFromFile = source_2.getLines().toList
		println(listFromFile.toString)
	}
}
