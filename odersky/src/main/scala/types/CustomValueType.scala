package types

class CustomValueType(val value: Int) extends AnyVal {
//  val ff = 12                                                 // Do not uncomment, where will be an error
  override def toString: String = "CustomValue " + value.toString

//  override def equals(obj: Any): Boolean = super.equals(obj)  // Do not uncomment, where will be an error
//  override def hashCode(): Int = super.hashCode()             // Do not uncomment, where will be an error
}
