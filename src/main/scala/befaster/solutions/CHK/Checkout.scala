package befaster.solutions.CHK

object Checkout {
  private val prices = List(A(),B(),C(),D(),E())

  def checkout(skus: String): Integer = {
    val items = skus.toCharArray.map(_.toString).toList
???
//    items.distinct.diff(prices.map(_)) match {
//      case Nil => calculateTotalPrice(items)
//      case _ => -1
//    }
  }

//  private def calculateTotalPrice(items: List[String]): Int = {
//    val groupedSkus = items.flatMap(i => prices.filter(p => p.item == i)).groupBy(_.item)
//
//    val receipt = groupedSkus.map { sku =>
//      discounts.find(d => d.item == sku._1) match {
//        case Some(d) =>
//          val discountCount = sku._2.length / d.quantity
//          val remainderCount = sku._2.length % d.quantity
//
//          discountCount * d.price + remainderCount * sku._2.head.price
//        case None => sku._2.map(_.price).sum
//      }
//    }
//
//    receipt.sum
//  }
}
