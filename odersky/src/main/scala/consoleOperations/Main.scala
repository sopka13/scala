/*
     Console operations
 */

package consoleOperations

import scala.io.StdIn._

object Main {
  def main(args: Array[String]): Unit = {
    val var_0 = readLine("Your name: ")     // Return string  from stdin
    val var_1 = readInt()                   // Return int     from stdin
    val var_2 = readBoolean()               // Return boolean from stdin
    val var_3 = readChar()                  // Return char    from stdin
    val var_4 = readDouble()                // Return double  from stdin
    val var_5 = readByte()                  // Return byte    from stdin
    val var_6 = readFloat()                 // Return float   from stdin
    val var_7 = readLong()                  // Return long    from stdin

    val stdOut = Console.out      // Std out
    val stdIn = Console.in        // Std in
    val stdErr = Console.err      // Std err

    stdErr.println("This is message")
  }
}
