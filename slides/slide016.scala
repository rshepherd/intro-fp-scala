
/* Reuse */

case class Charge(cc: CreditCard, amount: Double) {
  // combines two charges together to reduce processing fees
  def combine(other: Charge): Charge = Charge(cc, amount + other.amount) 
}

// Same as last slide
def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
  val cup = new Coffee()
  (cup, Charge(cc, cup.price))
}

// Lets say a customer wants to have a tab running!
def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
  val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
  val (coffees, charges) = purchases.unzip 
  (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
}

