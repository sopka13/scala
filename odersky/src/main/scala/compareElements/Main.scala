package compareElements

import play.api.libs.json.Json

object Main extends App {
  val v_0 = 12
  val v_1 = 13

  // Compare AnyVal (Double, Float, Long, Int, Short, Byte, Unit, Boolean, Char)

  // Compare AnyRef (java.lang.Object)

//  val g = new Point3D(1, 2, 3)
//  val k = new PointMultiD(1, 2, null)
//  val d = new PointMultiD(1, 2, Array(1,2,3))
//  println(d.equals(k))

  val tmp_0 = """{"first":"Bob","second":"Li","other":[]}"""
  val tmp_1 = """{"first":"Bob","second":"Li","other":["a","b","c"]}"""

  println(Json.parse(tmp_0).validate[Name].get.other.sorted.sameElements(Json.parse(tmp_1).validate[Name].get.other.sorted))
  println(Json.parse(tmp_1).validate[Name].get.other.sorted)


  val a = new Name("Bob", "Li", Array("ABC"))
  val b = new Name("Bob", "Li", Array("ABC"))

}
