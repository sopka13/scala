/*
    Symbol type
 */

package types

object SymbolType {
  def main(args: Array[String]): Unit = {
    // Init
    val a = 'newSymbol
    val b = Symbol("otherSymbol")

    // Operations
    val c: String = a.name
    val d: String = b.name
  }
}
