package ch_02

object Main {
	def main(args: Array[String]): Unit = {
		val arg_1 = 10
		val arg_2 = -10
		val arg_3 = 0

		println("Positive = " + sign(arg_1))
		println("Negative = " + sign(arg_2))
		println("Null = " + sign(arg_3))

		println("Positive = " + sign_new(arg_1))
		println("Negative = " + sign_new(arg_2))
		println("Null = " + sign_new(arg_3))

		println("None return = " + none())

		println(cycle())
		println(coutDown(arg_1))

		strMultiply("Hello")
		strMultiply_2("Hello")
	}

	def sign(arg: Int): Int = {
		if (arg > 0) 1 else if (arg == 0) 0 else -1
	}

	def sign_new(arg: Int): Int = arg.sign

	def none(): Unit = {}

	// for (int i = 10; i >= 0; i--) System.out.println(i);
	def cycle(): Unit = {
		for (i <- (0 to 10).reverse) println(s"i = $i")
	}

	def coutDown(n: Int): Unit = {
		for (i <- (0 to n).reverse) println(s"i = $i")
	}

	def strMultiply(arg: String): Unit = {
		println((for (i <- arg) yield i.toInt).sum)
	}

	def strMultiply_2(arg: String): Unit = {
		println(arg.foldLeft(1: BigInt)(_ * _))
//		var tmp: BigInt = 1
//		for (i <- arg) tmp *= i.toInt
//		println(s"tmp = $tmp")
	}
}
