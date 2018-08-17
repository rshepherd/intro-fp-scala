sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def size[A](t: Tree[A]): Int = ???

  def maximum(t: Tree[Int]): Int = ???

  def depth[A](t: Tree[A]): Int = ???

  def map[A,B](t: Tree[A])(f: A => B): Tree[B] = ???

  def fold[A,B](t: Tree[A])(f: A => B)(g: (B,B) => B): B = ???
}
