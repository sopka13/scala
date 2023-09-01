/*
    Integer type
 */

//import org.apache.spark.util.SizeEstimator._

package types

import sun.util.resources.cldr.ar.CalendarData_ar_BH

object IntType {
  def main(args: Array[String]): Unit = {
    // Init
    val a: Int = 1
    val b = 2
    val c = 0xAB

    // Operations
    println(s"Int type:\n" +
      s"\tsize:       $a\n" +
      s"\tmax value:  ${Int.MaxValue}\n" +
      s"\tmin value:  ${Int.MinValue}\n" +
      s"\tbox:        ${Int.box(a)}\n" +
      s"\tint2long:   ${Int.int2long(a)}\n" +
      s"\tint2float:  ${Int.int2float(a)}\n" +
      s"\tint2double: ${Int.int2double(a)}\n" +
      s"\tunbox:      ${Int.unbox(null)}\n" +
      s"\ttoString:   ${a.toString}\n" +
      s"\t1 max 2:    ${1 max 2}\n" +
      s"\t1 min 2:    ${1 min 2}\n" +
      s"\t1 until 3:  ${1 until 3}\n" +
      s"\t1 to 3:     ${1 to 3}\n" +
      s"\t1.abs:      ${1.abs}\n" +
      s"\t(-1).abs:   ${(-a).abs}\n" +
      s"\ta = 1; b = 2; a == b:     ${val a = 1; val b = 2; a == b}\n" +
      s"\ta = 1; b = 2; a eq b:     ${val a = "a"; val b = "b"; a eq b}\n"
    )
    val a_1 = -a          // Negative a
    val a_2 = a.unary_-   // Negative a
  }
}
