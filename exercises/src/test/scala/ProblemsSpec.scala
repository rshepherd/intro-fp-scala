import org.specs2.mutable._

class ProblemsSpec extends Specification {

  import Problems._

  "Take one down, pass it around... " should {

    "reverse a list. (P05)" in {
      rev(List(1, 1, 2, 3, 5, 8)) must_== List(8, 5, 3, 2, 1, 1)
    }

    "find out if a list is a palindrome. (P06)" in {
      palindrome(List(1, 2, 3, 2, 1)) must beTrue
      palindrome(List(1, 2, 2, 1)) must beTrue
      palindrome(List(1, 2, 2, 1, 2)) must beFalse
    }

    "flatten a nested structure. (P07)" in {
      flatten(List(List(1, 1), 2, List(3, List(5, 8)))) must_== List(1, 1, 2, 3, 5, 8)
    }

    "eliminate consecutive duplicates of list elements. (P08)" in {
      compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) must_== List('a, 'b, 'c, 'a, 'd, 'e)
    }

    "isSorted should sort by comparison function" in {
      val a = Array(1, 1, 2, 3, 5, 8)
      isSorted(a, (x: Int, y: Int) => x > y ) must beTrue
      isSorted(a.reverse, (x: Int, y: Int) => x < y ) must beTrue
    }

  }
}
