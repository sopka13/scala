package compareElements

import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.{JsPath, Json, Reads, Writes}

case class Name(first: String, second: String, other: Array[String]){
  override def hashCode(): Int = (first, second, other.toSeq.hashCode()).##
  def canEqual(that: Any): Boolean = that.isInstanceOf[Name]
  override def equals(obj: Any): Boolean = obj match {
    case that: Name =>
      canEqual(that) &&
        this.first == that.first &&
        this.second == that.second &&
        this.other.sameElements(that.other)
    case _ => false
  }
}

object Name {
  implicit val serializer: Writes[Name] = Json.writes

  implicit val deserilizer: Reads[Name] = (
    (JsPath \ "first").read[String] and
      (JsPath \ "second").read[String] and
      (JsPath \ "other").read[Array[String]]
  ) (Name.apply _)
}
