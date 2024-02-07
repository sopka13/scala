/**
 * Options
 */

object Options extends App {
  // Create
  val opt_0: Option[String] = Option("Hello")
  val opt_1 = Option("Hello")
  val opt_2 = Some("Hello")
  val opt_3 = None
  val opt_4: Option[String] = opt_2.orElse(opt_3)
}
