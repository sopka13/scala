object Types extends App {

  val p_0 = new Regular(false)
  val p_1 = new Vip(true)
  val p_2 = new Vip(false)

  val o_0 = new Order[Regular](p_0)
  val o_1 = new Order[Vip](p_1)
  val o_2 = new Order[Customer](p_2)
//  val o_3 = new Order[Int](12) // ERROR: Int is not Regular subtype

  val o_4 = new OrderBase[Vip](new Vip(true))
//  val o_5 = new OrderBase[Friend](new Friend) // ERROR: Friend is subtype Vip. This is forbidden limit

  val o_6 = new OrderCustom[Vip](new Vip(true))
  val o_7 = new OrderCustom[PreVip](new PreVip)
//  val o_8 = new OrderCustom[PrePreVip](new PrePreVip) // ERROR: OrderCustom for Vip and PreVip only
}

abstract class Customer {
  def isVip: Boolean
}

class Regular(val vipStatus: Boolean) extends Customer {
  override def isVip: Boolean = vipStatus
}

class Vip(val vipStatus: Boolean) extends Customer {
  override def isVip: Boolean = vipStatus
}

class PreVip extends Vip(false)

class PrePreVip extends PreVip

// Upper limit
class Order[T <: Customer](val person: T) {
  def offer: String = if (person.isVip) "free gift" else "no gift"
}

//class Order_1[T](val person: T) {                   // ERROR: person.isVip is missing
//  def offer: String = if (person.isVip) "free gift" else "no gift"
//}

// Lower limit
class OrderBase[T >: Vip](val person: T)

// Upper lower limit
class OrderCustom[T >: PreVip <: Vip](val person: T) {
  def offer: String = if (person.isVip) "free gift" else "no gift"
}

trait Fetus
trait Fruit extends Fetus

class Apple   extends Fruit
class Banana  extends Fruit
class Potato  extends Fetus

object Temp extends App {

  // Invariant
  class FruitBasket_0[T]

  val invariantBasket_0: FruitBasket_0[Fruit] = new FruitBasket_0[Fruit]
  //  val invariantBasket_1: FruitBasket_0[Fruit] = new FruitBasket_0[Apple] // ERROR
  //  val invariantBasket_2: FruitBasket_0[Fruit] = new FruitBasket_0[Fetus]// ERROR

  // Covariant
  class FruitBasket_1[+T]

  val covBasket_0: FruitBasket_1[Fruit] = new FruitBasket_1[Apple]
  val covBasket_1: FruitBasket_1[Fruit] = new FruitBasket_1[Banana]
  //  val covBasket_2: FruitBasket_1[Fruit] = new FruitBasket_1[Potato] // ERROR

  // Contrvarant
  class FruitBasket_2[-T]

  val contrBasket_0: FruitBasket_2[Apple] = new FruitBasket_2[Fruit]
  val contrBasket_1: FruitBasket_2[Apple] = new FruitBasket_2[Fetus]

  // Invariant VALS
  abstract class Bucket(val value_0: Int)
  abstract class PlasticBucket(val value_1: Int) extends Bucket(value_1)

  class RedBucket(value: Int) extends PlasticBucket(value)
  class BlueBucket(value: Int) extends PlasticBucket(value)
  class BlackBucket(value: Int) extends Bucket(value)

  class SomeBucket_0[T](value: T)

  val invariantBucket_0: SomeBucket_0[PlasticBucket] = new SomeBucket_0[PlasticBucket](new RedBucket(10))
  val invariantBucket_1: SomeBucket_0[PlasticBucket] = new SomeBucket_0[PlasticBucket](new BlueBucket(10))
  //val invariantBucket_3: SomeBucket_0[PlasticBucket] = new SomeBucket_0[PlasticBucket](new BlackBucket(10))  // ERROR

  /**
   *  Covariant VALS
   */
  class SomeBucket_1[+T](val value: T)

  val covBucket_0: SomeBucket_1[PlasticBucket] = new SomeBucket_1[PlasticBucket](new RedBucket(10))
  val covBucket_1: SomeBucket_1[PlasticBucket] = new SomeBucket_1[PlasticBucket](new BlueBucket(10))
  //val covBucket_2: SomeBucket_1[PlasticBucket] = new SomeBucket_1[PlasticBucket](new BlackBucket(10)) // ERROR

  /**
   * Contrvarant VALS
   */
  class SomeBucket_2[T](val value: T)
  //class SomeBucket_2[-T](val value: T) // ERROR

  /**
   *  Invariant VARS
   */
  abstract class Bucket_0(var value_0: Int)
  abstract class PlasticBucket_0(var value_1: Int) extends Bucket_0(value_1)

  class RedBucket_0(value: Int) extends PlasticBucket_0(value)
  class BlueBucket_0(value: Int) extends PlasticBucket_0(value)
  class BlackBucket_0(value: Int) extends Bucket_0(value)

  class SomeBucket_0_0[T](value: T)

  val invariantBucket_0_0: SomeBucket_0_0[PlasticBucket_0] = new SomeBucket_0_0[PlasticBucket_0](new RedBucket_0(10))
  val invariantBucket_1_0: SomeBucket_0_0[PlasticBucket_0] = new SomeBucket_0_0[PlasticBucket_0](new BlueBucket_0(10))
  //val invariantBucket_3: SomeBucket_0_0[PlasticBucket_0] = new SomeBucket_0_0[PlasticBucket_0](new BlackBucket_0(10))  // ERROR

  // Covariant VARS
  //class SomeBucket_1_0[+T](var value: T) // ERROR

  // Contrvarant VARS
  //class SomeBucket_2_0[-T](var value: T) // ERROR

  /**
   * Type keyword
   */
  trait Base {
    type T
    def method: T
  }

  class Implementation extends Base {
    type T = Int
    def method: T = 42
  }
}
