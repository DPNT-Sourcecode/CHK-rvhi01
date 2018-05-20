package befaster.solutions.CHK

import org.scalatest.{FlatSpec, Matchers}

class CheckoutTest extends FlatSpec with Matchers {
  it should "calculate total price without discount" in {
    val skus = "A,B,C,D"

    val result = Checkout.checkout(skus)

    result shouldBe 115
  }

  it should "calculate total price with discount" in {
    val skus = "A,B,C,A,D,B,A"

    val result = Checkout.checkout(skus)

    result shouldBe 210
  }

  it should "return -1 in case of illegal input" in {
    Checkout.checkout("A,B,C,X") shouldBe -1
    Checkout.checkout("A B C D") shouldBe -1
    Checkout.checkout("invalid") shouldBe -1
    Checkout.checkout(" ") shouldBe -1
    Checkout.checkout("") shouldBe -1
  }
}
