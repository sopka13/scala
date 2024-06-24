import scala.collection.immutable.Stream.cons

object Streams extends App {
  // Create
  val stream_0 = 1 #:: 2 #:: 3 #:: Stream.empty
  val stream_1 = cons(1, cons(2, cons(3,  Stream.empty)))
  val stream_2 = Stream.empty[Int]      // Create empty stream

  val res_0 = stream_0.take(2)    // get several elems
  val res_1 = stream_1.map(_ + 3) // use modifier for all elems
}
