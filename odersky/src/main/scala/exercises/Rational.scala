package exercises

import scala.language.implicitConversions

class Rational(n: Int, d: Int) {
  require(d != 0)

  // Private
  private val g = gcd(n.abs, d.abs)
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  // Public
  val num = n / g
  val denom = d / g

  // Constructors
  def this(num: Int) = this(num, 1)

  // Overrides
  override def toString: String = num + "/" + denom

  def +(that: Rational): Rational =
    new Rational(num * that.denom + denom * that.num,
      denom * that.denom)
  def +(that: Int): Rational =
    new Rational(num + denom * that, denom)
  def -(that: Rational): Rational =
    new Rational(num * that.denom - denom * that.num,
      denom * that.denom)
  def -(that: Int): Rational =
    new Rational(num - denom * that,
      denom)
  def *(that: Rational): Rational =
    new Rational(num * that.num,
      denom * that.denom)
  def *(that: Int): Rational =
    new Rational(num * that, denom)
  def /(that: Rational): Rational =
    new Rational(num * that.denom,
      denom * that.num)
  def /(that: Int): Rational =
    new Rational(num,
      denom * that)

  def lessThan(that: Rational): Boolean =
    this.num * that.denom < that.num * this.denom
  def max(that: Rational): Rational =
    if(lessThan(that)) that else this
  implicit def intToRational(x: Int): Rational = new Rational(x) // Not work
}
