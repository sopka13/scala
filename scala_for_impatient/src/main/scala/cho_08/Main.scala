package cho_08

import java.lang.Integer.sum

object Main {
	def main(args: Array[String]): Unit = {
		// function literal
		val f = (x: Int) => x * 2
		// use function literal
		println(s"literal f from 3 = ${f(3)}")

		// more difficult
		val f_1 = (a: Char, b: Int, c: String) => {
			println("Start literal")
			println(s"$a + $b + $c")
			println("Literal end")
		}
		f_1('A', 12, "man")

		// filter
		val lst = List(1, 2, 3, 4, 5, 6, 7)
		println(lst.filter((a: Int) => { a > 2 && a < 6 }).mkString)
		println(lst.filter(a => { a > 2 && a < 6 }).mkString)

		println(lst.filter(_ > 6).mkString)
		val f_2 = (_: Int) + (_: Int)
		println(f_2(1, 2))

		// partially applied function
		val f_3 = sum _
		println(s"sum = ${f_3(1, 2)}")
		val f_4 = sum(1, _: Int)
		println(s"sum(1, _) = ${f_4(5)}")

		// repeat parameters
		def f_5(f: Int*): Unit = println((for (k <- f) yield k).mkString)
		f_5(1, 2, 3, 4, 5)
		f_5(1, 2, 3)
		val arr = Array(1, 2, 3, 4, 5, 6, 7)
		f_5(arr: _*)
	}
}
