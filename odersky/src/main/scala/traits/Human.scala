package traits

abstract class Human(val name: String, val age: Int)
  extends Philosophical with Ordered[Human]{
  require(age >= 0)

  def gender: String

  override def toString: String = "My name is " + name
  override def compare(that: Human): Int = this.age - that.age
}
