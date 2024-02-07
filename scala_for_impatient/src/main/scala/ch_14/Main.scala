package ch_14

object Main {
	def main(args: Array[String]): Unit = {
		// ex_1
		val p = "first"

		p match {
			case "first" => println(s"p = first")
			case "second" | "third" => println(s"p = second or third")
			case _ => println(s"p = other value")
		}

		// ex_2
		p match {
			case _ if (p.length > 12) => println(s"length > 12")
			case _ => println(s"length !> 12")
		}

		// ex_3
		p match {
			case "low" => println(s"p = low")
			case mm => println(s"p = $mm")
		}

		// ex_4
		p match {
//			case f: Char => println(s"p is Integer") // not work
			case _: String => println(s"p is String")
			case _ => println(s"p is other type")
		}

		// ex_5
		println(s"ex_5 start")
		val arr = Array(1, 2, 3)
		arr match {
			case Array(_, _, 2) => println(s"1 option OK")
			case Array(_, _) => println(s"2 option OK")
			case Array(1, 2, 4) => println(s"3 option OK")
			case Array(1, 2, 5) => println(s"4 option OK")
			case Array(2, _*) => println(s"5 option OK")
			case Array(1, x, _*) => println(s"6 option OK and 2nd elem = $x")
			case _ => println(s"other option OK")
		}

		// ex_6
		println(s"ex_6 start")
		val pattern = "([0-9]+) ([a-z]+)".r
		"99 bottles" match {
			case pattern(num, item) => println(s"num = $num, item = $item")
			case _ => println(s"other")
		}

		// ex_7
		println(s"ex_7 start")
		val (x, y, z) = (1, 2, 3)
		println(s"x = $x, y = $y, z = $z")

		// ex_8
		println(s"ex_8 start")
//		for ((k, v) <- System.getProperties)
//			println(s"$k + > + $v")

		// ex_9
		println(s"ex_9 start")
		case class Clop(num: Int, str: String)

		// ex_10
		println(s"ex_10 start")
		val one = Clop(12, "sososo")
		val two = one.copy(num = 13)

		// ex_16
		println(s"ex_16 start")
		val kk = Map("one" -> 1, "two" -> 2, "three" -> 3)
		val ret = kk.get("one")
		ret match {
			case Some(elem) => println(s"ret = $elem")
			case None => println(s"ret = none")
		}
		val ret2 = kk.get("one2")
		ret2 match {
			case Some(elem) => println(s"ret = $elem")
			case None => println(s"ret = none")
		}

		// ex_17
		println(s"ex_17 start")
	}
}
