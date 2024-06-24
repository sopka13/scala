package compareElements

class Point4D (x: Int, y: Int, z: Int, val f: Int) extends Point3D(x, y, z){
  override def hashCode(): Int = (x, y, z, f).##
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Point4D]
  override def equals(obj: Any): Boolean = obj match {
    case that: Point4D =>
      canEqual(that) &&
        this.x == that.x &&
        this.y == that.y &&
        this.z == that.z &&
        this.f == that.f
    case _ => false
  }
}
