package traits

class Woman(name: String, age: Int)
  extends Human(name, age) {//with SayYourGender {
  def gender: String = "female"
}
