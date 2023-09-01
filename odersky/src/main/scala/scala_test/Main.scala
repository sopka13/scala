package scala_test

import org.scalatest.funsuite.AnyFunSuite

object Main {
  def main(args: Array[String]): Unit = {
    class FirstFlatSpec extends AnyFunSuite {
      test("Some test"){
        assert(List.empty.size == 0)
      }
    }
  }
}
