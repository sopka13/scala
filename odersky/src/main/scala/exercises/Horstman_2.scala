package exercises

object Horstman_2 {
  def main(args: Array[String]): Unit = {
    def signum(value: Int): Int = if (value > 0) 1 else if (value == 0) 0 else -1
    def returnType(value: Any): String = value.getClass.toString
    def printSequences(): Unit = for (i <- 0.to(10).reverse) println(i)
    def countDown(n: Int): Unit = for (i <- (if (n > 0) 0 else n) to (if (n > 0) n else 0)) println(i)
    def multiplicationOfChars_01(str: String): Unit = println(str.map(ch => ch.toInt).reduceLeft(_ * _))
    def multiplicationOfChars_02(str: String): Unit = println(str.map(ch => ch.toInt).product)
    def multiplicationOfCharsRecursive(str: String, value: Int = 1): Unit = if (str.isEmpty) println(value) else multiplicationOfCharsRecursive(str.drop(1), str(0).toInt * value)

    multiplicationOfChars_01("ab")
    multiplicationOfChars_02("ab")
    multiplicationOfCharsRecursive("ab")
  }
}
