import org.scalatest.time.SpanSugar.convertIntToGrainOfTime

import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success, Try}

object Futures extends App {
  def slowComputation: String = {
    Thread.sleep(1000)
    "123"
  }

  // Create
  val f_0: Future[String] = Future(slowComputation)
  val f_1: Future[Int] = Future.successful { 1 + 2 }
  val f_2: Future[Nothing] = Future.failed { new Exception("bum!") }
  val f_3: Future[Int] = Future.fromTry { Success { 1 + 2 } }
  val f_4: Future[Nothing] = Future.fromTry { Failure ( new Exception("bum") ) }
  val p_0: Promise[Int] = Promise[Int]
  val f_5: Future[Int] = p_0.future

  // Use
  val result_0: Option[Try[String]] = f_0.value
  val result_1: Boolean           = f_0.isCompleted   // Check complete future
  val result_2: String            = Await.result(f_0, 1000.millis)  // Wait and get result
  val result_3: Unit              = f_0.failed.foreach(e => println(e)) // Add handler for fail result. If future return complete fail logic not exec
  val result_4: Unit              = f_0.foreach(println)          // Add actions for complete result
  val result_5: Unit              = f_0.onComplete { // Add actions after complete future
    case Failure(exception) =>
    case Success(value) =>
  }
  val result_6: Unit              = f_0.map { res =>  // Add action after complete future. Return same exception if f_0 return failure
    if (res.isEmpty) ()
    else throw new Exception("Some exception")
  }
  val result_7: Future[Int]         = Future{12}.map(value => value + 11)   // Create new Thread (maybe) for received func and return result
  val result_8: Future[Int]         = Future{12}.flatMap(value => Future{value})
  val result_9: Future[String]      = f_0.filter(future => future.isEmpty)
  val result_10: Future[String]      = f_0.withFilter(future => future.isEmpty)
  val result_11: Future[Object]      = f_0.map { str => Future { str + "some logic" } }.recover { case _ => "123" }
  val result_12: Future[Object]     = f_0.map { str => Future { str + "some logic" } }.recoverWith { case _ => Future { "123" } }
  val result_13: Future[String]     = f_0.map(value => value + "some logic").fallbackTo(Future { "Some future case" }) // Return some future result if first return faill
  val result_14: Future[String]     = f_0.andThen { case Success(str) => str + "Fine" }.andThen { case _ => "some some logic" } // Add logic after finish first future

  println(result_7)

}
