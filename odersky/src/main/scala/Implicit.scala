object Implicit extends App {
  // Create
  implicit val imp_0 = 12
  implicit var imp_1 = 13
  implicit def imp_2 = 14
  implicit class Imp_0(val a: Int) {}
//  implicit case class Imp_1(val f: Int) {} // ERROR
  implicit object Imp_0 {}
//  implicit trait Imp_1 {} // ERROR
}
