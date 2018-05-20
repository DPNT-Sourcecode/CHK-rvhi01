package befaster.solutions.CHK

import org.scalatest.{FlatSpec, Matchers}

class CheckoutTest extends FlatSpec with Matchers {
  it should "calculate total price without discount" in {
    val skus = "A,B,C,D"
    val expectedTotalPrice = 115

    val result = Checkout.checkout(skus)

    result shouldBe expectedTotalPrice
  }

  it should "calculate total price with discount" in {
    val skus = "A,B,C,A,D,B,A"
    val expectedTotalPrice = 210

    val result = Checkout.checkout(skus)

    result shouldBe expectedTotalPrice
  }
}
