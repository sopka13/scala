package compareElements

class PointMultiD (x: Int, y: Int, val other: Array[Int]) extends Point(x, y) {
  override def hashCode(): Int = (x, y, other.toSeq.##).##
  override def canEqual(that: Any): Boolean = that.isInstanceOf[PointMultiD]
  override def equals(obj: Any): Boolean = obj match {
    case that: PointMultiD =>
      canEqual(that) &&
        this.x == that.x &&
        this.y == that.y &&
        this.other != null &&
        that.other != null &&
        this.other.sameElements(that.other)
    case _ => false
  }
}
