package ch_05

class NewClass(value: Int = 0) {
	private var vals = value
	def increment(): Unit = vals += 1
	def decrement(): Unit = vals -= 1
	def current: Int = vals
	def showValue(): Unit = println(vals)
	def setValue(value: Int): Unit = {
		this.vals = value
	}
}
