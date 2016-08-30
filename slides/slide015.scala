
/* Abides RT */

def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
  val cup = new Coffee()
  (cup, Charge(cc, cup.price)) // We defer executing the charge
}

/*
This code is..
 • Easier to reason about
 • Easier to test
 • Easier to reuse! 
*/

