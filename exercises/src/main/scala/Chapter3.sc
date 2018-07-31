sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  // Example code and utility functions
  def apply[A](as: A*): List[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0 // The sum of the empty list is 0.
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def append[A](a1: List[A], a2: List[A]): List[A] =
    a1 match {
      case Nil => a2
      case Cons(h,t) => Cons(h, append(t, a2))
    }

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = 
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  // Ex 3.1
  lazy val p = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }

  // Ex 3.2
  def tail[A](l: List[A]): List[A] = ???

  // Ex 3.3
  def setHead[A](l: List[A], h: A): List[A] = ???

  // Ex 3.4
  def drop[A](l: List[A], n: Int): List[A] = ???

  // Ex 3.5
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = ???

  // Ex 3.6
  def init[A](l: List[A]): List[A] = ???

  // Ex 3.7
  def sum2(ns: List[Int]) = ???

  // Ex 3.8
  def product2(ns: List[Double]) = ???

  // Ex 3.9
  def length[A](l: List[A]): Int = ???

  // Ex 3.10
  def foldLeft[A,B](l: List[A], z: B)(f: (B, A) => B): B = ???

  // Ex 3.11
  def sum3(ns: List[Int]) = ???

  def product3(ns: List[Double]) = ???

  def length2[A](l: List[A]): Int = ???
  
  // Ex. 3.12
  def reverse[A](l: List[A]): List[A] = ???

  // Ex. 3.13
  def foldLeft2[A,B](l: List[A], z: B)(f: (B, A) => B): B = ???

  def foldRight2[A,B](l: List[A], z: B)(f: (B, A) => B): B = ???

  // 3.14
  def append2[A](a1: List[A], a2: List[A]): List[A] = ???

  // 3.15
  def concat[A](l1: List[List[A]]): List[A] = ???

  // 3.16
  def addOne(l: List[Int]): List[Int] = ???

  // 3.17
  def toString(l: List[Double]): List[String] = ???

  // 3.18
  def map[A,B](l: List[A])(f: A => B): List[B] = ???

  // 3.19
  def filter[A](l: List[A])(f: A => Boolean): List[A] = ???

  // 3.20
  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = ???

}

println(List.p)




