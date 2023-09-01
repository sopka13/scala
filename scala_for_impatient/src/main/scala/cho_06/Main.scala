package cho_06

object Main {
	def main(args: Array[String]): Unit = {
		val r_01 = new Rational(1, 2)
		val r_02 = new Rational(2, 3)
		val r_03 = r_01 + r_02
		println(s"result add = ${r_03.toString}")
		println(s"result max = ${r_03.max(r_02)}")
		val r_04 = new Rational(12)
		println(s"additional constructor = ${r_04.toString}")
	}
}
