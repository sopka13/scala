package compareElements

class Point(val x: Int, val y: Int){
  override def hashCode(): Int = (x, y).##
  def canEqual(that: Any): Boolean = that.isInstanceOf[Point]
  override def equals(obj: Any): Boolean = obj match {
    case that: Point =>
      canEqual(that) &&
        this.x == that.x &&
        this.y == that.y
    case _ => false
  }
}
