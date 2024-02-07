package ch_17

import java.lang.Thread.sleep
import java.time._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.math.random
import scala.util.{Failure, Success}

object Main {
	def main(args: Array[String]): Unit = {
		// Future create method
		Future {
			sleep(1000)
			println(s"This is the future at ${LocalTime.now}")
		}
		println(s"This is the present at ${LocalTime.now}")
		sleep(2000)

		// If need handle result
		val f = Future { Thread.sleep(1000)
			if (random() < 0.5) throw new Exception
			42
		}
		f.onComplete {
			case Success(v) => println(s"The answer is $v")
			case Failure(ex) => println(s"Get exception: ${ex.getMessage}")
		}
		sleep(2000)
	}
}
