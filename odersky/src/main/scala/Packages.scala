package my.some.packages {
  // packages me and my.some not available
  object Packages {
    val var_0 = "some"
  }
}

package other {
  package object several {
    val var_1 = 12
  }

  package several {

    import other.several.pkgs.PkgObj.hello
    import other.several.pkgs.PkgObj.{someMethod => some} // Rename package member
    import other.several.pkgs.PkgObj.{someMethod_2 => _}  // Hide package member

    package object pkgs {
      val vr = var_1    // success
    }

    object Some {
      def helloWorld(): String = hello + " World!"
      def someHello(): String = some + " Hello!"
//      def someHello_2(): String = someMethod_2 + " Hello!" // Error
    }

    package pkgs {
      // packages other and several and pkgs is available

      object PkgObj {
        def main(args: Array[String]): Unit = {
          println(s"Start packages: vr = $vr")
        }

        private[several] def hello(): String = "Hello"
        private[several] def someMethod(): String = "Some"
        private[several] def someMethod_2(): String = "Some_2"
      }
    }
  }
}
