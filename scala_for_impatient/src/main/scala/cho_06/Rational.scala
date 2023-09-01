package cho_06

import scala.annotation.tailrec

class Rational(n: Int, d: Int) {
	require(d != 0)
	private val g = gcd(n.abs, d.abs)
	val numer: Int = n / g
	val denum: Int = d / g

	def this(n: Int) = this(n, 1)

	override def toString: String = numer + "/" + denum
	def + (that: Rational): Rational =
		new Rational(numer * that.denum + that.numer * denum,
			denum * that.denum)
	def + (that: Int): Rational =
		new Rational(numer + that * denum, denum)
	def - (that: Rational): Rational =
		new Rational(numer * that.denum - that.numer * denum,
			denum * that.denum)
	def - (that: Int): Rational =
		new Rational(numer - that * denum,
			denum)
	def * (that: Rational): Rational =
		new Rational(numer * that.numer, denum * that.denum)
	def * (that: Int): Rational =
		new Rational (numer * that, denum)
	def / (that: Rational): Rational =
		new Rational(numer * that.denum, denum * that.numer)
	def / (that: Int): Rational =
		new Rational(numer, denum * that)
	def max(that: Rational): Rational = {
		if (numer * that.denum < that.numer * denum) that else this
	}
	@tailrec
	private def gcd(a: Int, b: Int): Int = {
		if (b == 0) a else gcd(b, a % b)
	}
}
