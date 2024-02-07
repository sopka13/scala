package multiThreading

object Entities extends App {
  var counter = 0

  /**
   * synchronized - беспечивает использование кода ттолько одним потоком
   */
  synchronized {
    counter += 1
  }
}
