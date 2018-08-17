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
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  // Ex 3.3
  def setHead[A](l: List[A], h: A): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => Cons(h, xs)
  }

  // Ex 3.4
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Cons(_, xs) if n > 0 => drop(xs, n - 1)
    case _ => l
  }

  // Ex 3.5
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(x, xs) if f(x) => dropWhile(xs, f)
    case _ => l
  }

  // Ex 3.6
  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }

  // Ex 3.7
  def product2(ns: List[Double]) = foldRight(ns, 1.0)(_ * _)

  // Ex 3.9
  def length[A](l: List[A]): Int = foldRight(l, 0)((_, b) => b + 1)

  // Ex 3.10
  def foldLeft[A,B](l: List[A], acc: B)(f: (B, A) => B): B = l match {
    case Nil => acc
    case Cons(head, tail) => foldLeft(tail, f(acc, head))(f)
  }

  // Ex 3.11√
  def sum3(ns: List[Int]) = ???

  def product3(ns: List[Double]) = ???

  def length2[A](l: List[A]): Int = ???

  // Ex. 3.12
  def reverse[A](l: List[A]): List[A] = foldLeft(l, List[A]())((b, a) => Cons(a,b))

  // Ex. 3.13
  // def foldLeft2[A,B](l: List[A], z: B)(f: (B, A) => B): B = ???
  def foldRight2[A,B](l: List[A], z: B)(f: (B, A) => B): B = foldLeft(reverse(l),z)(f)

  // 3.14
  def appendFoldLeft[A](l1: List[A], l2: List[A]): List[A] = foldLeft(reverse(l1),l2)((b, a) => Cons(a, b))
  def appendFoldRight[A](l1: List[A], l2: List[A]): List[A] = foldRight(l1,l2)((a,b) => Cons(a, b))

  // 3.15
  def flatten[A](l1: List[List[A]]): List[A] = foldLeft(l1, Nil: List[A])((a, b) => append(a,b))

  // 3.16
  def addOne(l: List[Int]): List[Int] = foldRight2(l, Nil: List[Int])((a, e) => Cons(e + 1, a))

  // 3.17
  def toString(l: List[Double]): List[String] = foldRight2(l, Nil: List[String])((a, e) => Cons(e.toString, a))

  // 3.18
  def map[A,B](l: List[A])(f: A => B): List[B] = foldRight2(l, Nil: List[B])((a, e) => Cons(f(e), a))

  // 3.19
  def filter[A](l: List[A])(f: A => Boolean): List[A] = foldRight2(l, Nil: List[A])((a, e) => if(f(e)) Cons(e, a) else a)

  // 3.20
  def flatMap[A,B](l: List[A])(f: A => List[B]): List[B] = flatten(map(l)(f))

  // 3.23
  def zipWith[A,B,C](a: List[A], b: List[B])(f: (A,B) => C): List[C] = (a,b) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1,  t2)(f))
  }

  // 3.24
  def startsWith[A](l: List[A], prefix: List[A]): Boolean = (l, prefix) match {
    case (_, Nil) => true
    case (Nil, _) => false
    case (Cons(h1, t1), Cons(h2, t2)) => if (h1 == h2) startsWith(t1, t2) else false
  }

  def hasSubsequence[A](list: List[A], sublist: List[A]): Boolean = (list, sublist) match {
    case (Nil, _) => false
    case (_, Nil) => true
    case (Cons(_, t1), Cons(_, _)) => if (startsWith(list, sublist)) true else hasSubsequence(t1, sublist)
  }



}

println(List.hasSubsequence(List("a","b","c","d"),List("b","c","d")))




















