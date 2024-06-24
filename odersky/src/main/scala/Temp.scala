object Temp extends App {

  val enRuDict: Map[String, String] = Map.empty[String, String]

  case class ContactTicket(id: String,
                           language: String,
                           message: String)

  final class ContactService {
    // для получения поступившего от пользователя сообщения
    def retrieve(): ContactTicket
  }

}
