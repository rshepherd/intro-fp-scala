import Stream._

case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

trait Stream[+A] {

  def toListRecursive: List[A] = ???

  def take(n: Int): Stream[A] = ???

  def drop(n: Int): Stream[A] = ???

  def takeWhile(f: A => Boolean): Stream[A] = ???

  def forAll(f: A => Boolean): Boolean = ???

  def foldRight[B](z: => B)(f: (A, => B) => B): B = ???

  def takeWhile2(f: A => Boolean): Stream[A] = ???

  def exists(p: A => Boolean): Boolean = ???

  def headOption: Option[A] = ???

  def map[B](f: A => B): Stream[B] = ???

  def filter(f: A => Boolean): Stream[A] = ???

  def append[B>:A](s: => Stream[B]): Stream[B] = ???

  def flatMap[B](f: A => Stream[B]): Stream[B] = ???
}


object Stream {

  def constant[A](a: A): Stream[A] = ???

  def from(n: Int): Stream[Int] = ???

  def fibs(): Stream[Int] = ???

  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = ???

  def unfoldViaFold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = ???

  def unfoldViaMap[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = ???

  def fibsViaUnfold(): Stream[Int] = ???

  def fromViaUnfold(n: Int) = ???

  def constantViaUnfold[A](a: A) = ???
}
