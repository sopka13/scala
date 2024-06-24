package compareElements

class Point3D (x: Int, y: Int, val z: Int) extends Point(x, y){
  override def hashCode(): Int = (x, y, z).##
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Point3D]
  override def equals(obj: Any): Boolean = obj match {
    case that: Point3D =>
      canEqual(that) &&
        this.x == that.x &&
        this.y == that.y &&
        this.z == that.z
    case _ => false
  }
}
