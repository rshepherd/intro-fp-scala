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

val six = Leaf(6)
val five = Leaf(5)
val four = Leaf(4)
val three = Leaf(3)
val two = Branch(five, six)
val one = Branch(three, four)
val root = Branch(one, two)

println(Tree.size(root))
