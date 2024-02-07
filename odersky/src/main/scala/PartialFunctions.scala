/**
 * Partial functions
 */

object PartialFunctions extends App {
  // Create
  val onePartialFunction = (d: String) => d match {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }

  /** val twoPartialFunction: (Any) => String
   *  val                 - is value
   *  twoPartialFunction  - name
   *  (Any) => String     - type (get Any, return String)
   */
  val twoPartialFunction: (Any) => String = {
    case i: Int => "Int"
    case d: Double => "Double"
    case _ => "Other"
  }

  val threePartialFunction: PartialFunction[String, String] = {
    case "mon" => "Work!"
    case "fri" => "Party Time"
    case "sun" => "Relax a little"
  }

  println(threePartialFunction.isDefinedAt("some")) // false

  // Join 2 functions => orElse
  val fourPartFunc: (String) => String =
    threePartialFunction.orElse[String, String] {
    case "fff" => "This is fff"
  }

  // Add functionality
  val ss = twoPartialFunction.andThen {
    case k: String => k + " This is string"
  }

  println(ss("asd"))  // This is string
  println(ss(12))     // This is string

  val liftPartFunc = threePartialFunction.lift
  println(liftPartFunc("12"))   // None
  println(liftPartFunc("mon"))  // Some(Work!)


}
