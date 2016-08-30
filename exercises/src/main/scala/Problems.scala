object Problems {

  // For the first 4 problems try to use combinators!
  // You can find them by searching the Scala documentation for List and Seq
  // There are many ways to solve these problems, you can see some
  // idiomatic solutions here http://aperiodic.net/phil/scala/s-99/ for solutions


  // Reverse a list.
  def rev[A](list: List[A]): List[A] = ???


  // Find out whether a list is a palindrome.
  def palindrome[A](list: List[A]): Boolean = ???


  // Flatten a nested list structure.
  def flatten(lists: List[Any]): List[Any] = ???


  // Eliminate consecutive duplicates of list elements.
  def compress[A](list: List[A]): List[A] = ???


  // Polymorphic functions
  // Implement isSorted which checks whether an Array[A] is sorted
  // according to the given comparison function
  def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = ???


  // Note that the following functions do not have tests! There is no need
  // since there is only one way to implement it and it can be checked
  // by the compiler. Static type systems and parametr polymorphism ftw!

  // Hint: use the following implementation of "partial application" for
  // inspiration for the following problems on currying
  def partial[A,B,C](a: A, f: (A,B) => C): B => C = {
    (b: B) => f(a, b)
  }

  // Currying!
  // Lets look at another example of dealing with higher order functions, 'currying',
  // which converts a function f of two arguments into a function of one argument that
  // partially applied f. There is only one implementation that compiles, so no need for a test!
  def curry[A,B,C](a: A, f: (A,B) => C): B => C = ???


  // Uncurrying!
  // Implement uncurry, which reverses the transformation of curry. Note that since =>
  // associaltes to the right, A => (B => C) can be written as A => B => C
  def uncurry[A,B,C](f: A => B => C): (A, B) => C = ???


  // (Bonus!) Function composition
  // Lets look at at an example of function composition, which feeds the output of one
  // function to the input of another. Again, there is only one correct implementation
  // fully determined by the type signature!
  def compose[A,B,C](f: A => B, g: B => C): A => C = ???
}