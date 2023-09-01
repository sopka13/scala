package traits

class Man(name: String, age: Int)
  extends Human(name, age) {//with SayYourGender {
  def gender: String = "male"
}
