
/* Violates RT */

def buyCoffee(cc: CreditCard): Coffee = {
  val cup = new Coffee()
  cc.charge(cup.price)  // Mutating external state!
  cup                   
}

