package ch_05

class Person {
	private var privateAge: Int = 0
//	def setAge(age: Int): Unit = { privateAge = age }
	def age: Int = privateAge // value imitation; Person.age() - will give an error
	def age_=(age: Int): Unit = { privateAge = age }
}
