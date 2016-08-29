
/* Higher Order Functions 

A fancy name for functions that take functions as arguments.
*/

object MyModule {
  // Assume that abs and factorial are defined ...

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d."
    msg.format(x, abs(x))
  }

  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d."
    msg.format(n, factorial(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(7))
  }
}

// Blarg.. we can do better than that..

def formatResult(name: String, n: Int, f: Int => Int) = {
  val msg = "The %s of %d is %d."
  msg.format(name, n, f(n))
}

formatResult("absolute value", -42, abs)
// "The absolute value of -42 is 42."

formatResult("factorial", 7, factorial)
// "The factorial of 7 is 5040."

