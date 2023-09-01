package traits

trait SayYourGender extends Human {
  abstract override def gender: String = "My gender is " + super.gender
}
