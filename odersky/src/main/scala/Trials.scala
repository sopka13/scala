/**
 * Try and more
 */

import scala.util.{Failure, Success, Try}

object Trials extends App {
  // Create
  val try_0: Try[Nothing] = Try { throw new RuntimeException("This is exception") }
  val try_1: Try[RuntimeException] = Failure( new RuntimeException("This is exception") )
  val try_2: Try[String] = Success( "This is exception" )
  val try_3 = try_1.orElse(try_2)
  val try_4: Try[String] = Try( "This is exception" )

}
