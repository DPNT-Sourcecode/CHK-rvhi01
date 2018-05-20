package befaster.solutions.CHK

case class SKU(item: String, price: Int)

case class Discount(item: String, quantity: Int, price: Int)

object Checkout {
  private val prices = List(
    SKU("A", 50),
    SKU("B", 30),
    SKU("C", 20),
    SKU("D", 15)
  )

  private val discounts = List(
    Discount("A", 3, 130),
    Discount("B", 2, 45)
  )

  def checkout(skus: String): Integer = {
    val items = skus.split(",").toList

    items.distinct.diff(prices.map(_.item)) match {
      case Nil => calculateTotalPrice(items)
      case _ => -1
    }
  }

  private def calculateTotalPrice(items: List[String]): Int = {
    val groupedSkus = items.flatMap(i => prices.filter(p => p.item == i)).groupBy(_.item)

    val receipt = groupedSkus.map { sku =>
      discounts.find(d => d.item == sku._1) match {
        case Some(d) =>
          val discountCount = sku._2.length / d.quantity
          val remainderCount = sku._2.length % d.quantity

          discountCount * d.price + remainderCount * sku._2.head.price
        case None => sku._2.map(_.price).sum
      }
    }

    receipt.sum
  }
}
