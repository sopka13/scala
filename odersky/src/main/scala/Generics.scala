object Generics extends App {
  def countSum_0(nums: List[Int]): Int = nums.sum
  def countSum_1[A: Numeric](nums: List[A]): A = nums.sum

  def   retValue[A](value: A): A = value
  class Ft[A](val value: A)
  trait Fl[A]{}
  // object Fk[A]{} // ERROR

  // <: верхнее ограничение
  class Fq[T <: AnyVal](val dd: T)
  new Fq[Int](4)
  new Fe[AnyVal](4.3)
//  new Fq[String]("Hello")   // ERROR
//  new Fq[Any](12)           // ERROR

  // >: нижнее ограничение
  class Fw[T >: AnyVal](val dd: T)
//  new Fw[Int](4)          // ERROR
  new Fe[AnyVal](4.3)
//  new Fw[String]("Hello") // ERROR
  new Fw[Any](12)

  // >: :< двойное ограничение
  class Fe[T >: Int <: AnyVal](val dd: T)
  new Fe[Int](4)
  new Fe[AnyVal](4.3)
//  new Fe[String]("Hello") // ERROR
//  new Fe[Any](12)         // ERROR

  // : Type ограничение типом
  class Fr(val dd: Int)
  new Fr(4)
//  new Fr(4.3)             // ERROR
//  new Fr[String]("Hello") // ERROR
//  new Fr[Any](12)         // ERROR

  // Инвариантность
  class Fruit
  class Aple extends Fruit
  class Banana extends Fruit
  class Fo[A]
//  val f_0: Fo[Aple] = new Fo[Fruit]    // ERROR
  val f_1: Fo[Aple] = new Fo[Aple]
//  val f_2: Fo[Aple] = new Fo[Banana]    // ERROR

  // Контравариантность
  class Fp[-A]
  val f_3: Fp[Aple] = new Fp[Fruit]
  val f_4: Fp[Aple] = new Fp[Aple]
//  val f_5: Fp[Aple] = new Fp[Banana]    // ERROR

  // Ковариантность
  class Fa[+A]
  val f_6: Fa[Fruit] = new Fa[Fruit]
  val f_7: Fa[Fruit] = new Fa[Aple]
  val f_8: Fa[Fruit] = new Fa[Banana]
}
