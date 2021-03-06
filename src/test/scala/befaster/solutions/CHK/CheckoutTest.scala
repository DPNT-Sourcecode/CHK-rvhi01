package befaster.solutions.CHK

import org.scalatest.{FlatSpec, Matchers}

class CheckoutTest extends FlatSpec with Matchers {
  it should "calculate total price without discount" in {
    val skus = "ABCD"

    val result = Checkout.checkout(skus)

    result shouldBe 115
  }

  it should "calculate total price with discount" in {
    val skus = "ABCADBA"

    val result = Checkout.checkout(skus)

    result shouldBe 210
  }

  it should "calculate discount for 5 As" in {
    val skus = "ABACADABA"

    val result = Checkout.checkout(skus)

    result shouldBe 300
  }

  it should "return 0 in case of no items" in {
    Checkout.checkout("") shouldBe 0
  }

  it should "return -1 in case of illegal input" in {
    Checkout.checkout("ABCX") shouldBe -1
    Checkout.checkout("abcd") shouldBe -1
    Checkout.checkout("invalid") shouldBe -1
    Checkout.checkout(" ") shouldBe -1
  }
}
