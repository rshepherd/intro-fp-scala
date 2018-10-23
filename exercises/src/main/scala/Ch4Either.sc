import scala.{Option => _, Either => _, Some => _, None => _}

case class Left[+E](get: E) extends Either[E,Nothing]

case class Right[+A](get: A) extends Either[Nothing,A]

sealed trait Either[+E,+A] {
  def map[B](f: A => B): Either[E, B] = ???

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = ???

  def orElse[EE >: E, AA >: A](b: => Either[EE, AA]): Either[EE, AA] = ???

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = ???
}


object Either {
  def traverse[E, A, B](es: List[A])(f: A => Either[E, B]): Either[E, List[B]] = ???

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = ???
}