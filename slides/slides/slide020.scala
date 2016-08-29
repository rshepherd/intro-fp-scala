
val l = List(1, 3, 5, 11)

def sum(l: List[Int]) = {
   var sum = 0
   for(i <- l) {
    sum = sum + i
   }
   sum
}

// What if I told you could simply do this?
l.fold(0)((acc, i) => acc + i) // <- lamba!
// -or-
l.fold(0)(_ + _) // <- lamba!

