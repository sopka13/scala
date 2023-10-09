/**
 *  Matches
 */

object Patterns extends App {

  case class FF(a: Int, b: String)

  val ll: Any = List("1", "2", "3")
  val dd = FF(12, "fofofo")

  ll match {
    case str @ List("1", _*) => println(s"OK: $str")
    case _ => println(s"no OK")
  }

  ll match {
    case _: List[String] => println("This is a lis of string")
    case _: Int => println("this is a int")
    case _ => println("i don't now this typee")
  }

  dd match {
    case FF(a, _) if a == 10 => println(s"i found a = 12")
    case FF(_, b) if b.nonEmpty => println(s"i found b non empty")
    case _ => println("i not found anything")
  }


}
