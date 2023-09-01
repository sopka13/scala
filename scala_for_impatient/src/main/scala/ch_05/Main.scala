package ch_05

object Main {
	def main(args: Array[String]): Unit = {
		val p_01 = new NewClass(12)
		p_01.increment()
		p_01.decrement()
		p_01.showValue()
	}
}
