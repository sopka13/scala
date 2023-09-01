/*
      Classes
    class Some {
      <implementation>
    }

 */

import scala.beans.BeanProperty

object Classes {
  def main(args: Array[String]): Unit = {
    // Define
    class MyClass(var_1: Int, var_2: Int){
      // Restrictions
      require(var_2 != 0)

      override def toString: String = "This in MyClass"
      // Constructors
      def this(a: Int) = this(a, 1)

      // Public variables:
      val some_1 = var_1
      var some_2 = var_2

      // Private vars:
      private val some_3 = 123
      private var some_4 = 123

      // Private vars, used only by this object:
      private[this] val some_5 = 123
      private[this] var some_6 = 123

      // Private vars, used only by specific class:
//      private[OtherClass_1] val some_7 = 123    // Error
//      private[OtherClass_1] var some_8 = 123    // Error

      // Public variables for use with java beans:
      @BeanProperty val some_9 = 123
      @BeanProperty var some_10 = 123

      // Public functions
      def func_1(): String = "Hello"
      def func_2(arg: Int): Int = arg * 2

      // Private functions
      private def func_3(): String = "World"
      private def func_4(arg: Int): Int = arg + 2

      // Private functions, used only by this object:
      private[this] def func_5(): String = "Hidden"
      private[this] def func_6(arg: Int): Int = arg - 2
    }

    // Class inheritance
    class MyClass_2 extends MyClass(1, 2)

    // Final class
    final class MyClass_3(val var_0: String) {}

    // Final others
    class MyClass_4() {
      final def name = "name"
      final val var_0 = 12
    }

    // Overrides
    class MyClass_5 extends MyClass(1, 2) {
      override def func_2(arg: Int): Int = 12
      override val some_9: Int = 14
      override def toString: String = super.toString + "one more str"
    }

    // Protected members
    class MyClass_6 {
      protected val val_3 = 12
      protected def myName = "MyName"
    }

    // Use outside vars and defs
    class OtherClass_1(val arg: Int) { outer =>
      def getStr = "STR"

      class Inside {
        val arg = outer.arg
        val var_1 = arg
        val var_2 = getStr
      }
    }

    // Abstract class
    abstract class MyClass_7 {
      def myName: String
      val number: Int
      val nm = 12
    }

    // Forward definition
    class MyClass_8 extends {
      override val nm = 13
    } with MyClass_7 {
      override def myName: String = "123"
      override val number: Int = 333
    }

    // Create instance
    val var_01 = new MyClass(10, 2)
  }
}
