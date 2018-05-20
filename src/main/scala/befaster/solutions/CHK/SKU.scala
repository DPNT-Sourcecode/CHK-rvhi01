package befaster.solutions.CHK

sealed trait SKU {
  def calculatePrice(skus: List[String]): Int
}

case class A() extends SKU {
  def calculatePrice(skus: List[String]): Int = {
    val items = skus.filter(sku => sku == "A")

    val fivers = items.sliding(5).filter(_.size == 5).toList
    val threes = items.drop(fivers.size * fivers.head.size).sliding(3).filter(_.size == 3).toList
    val remaining = items.drop(fivers.size * fivers.head.size + threes.size * threes.head.size)

    fivers.size * 200 + threes.size * 130 + remaining.size * 50
  }
}

case class B() extends SKU {
  override def calculatePrice(skus: List[String]): Int = {
    val items = skus.filter(sku => sku == "B")

    val doubles = items.sliding(2).filter(_.size == 2).toList
    val remaining =items.drop(doubles.size * doubles.head.size)

    doubles.size * 45 + remaining.size * 30
  }
}

case class C() extends SKU {
  override def calculatePrice(skus: List[String]): Int = {
    val items = skus.filter(sku => sku == "C")

    items.size * 20
  }
}

case class D() extends SKU {
  override def calculatePrice(skus: List[String]): Int = {
    val items = skus.filter(sku => sku == "D")

    items.size * 15
  }
}

case class E() extends SKU {
  override def calculatePrice(skus: List[String]): Int = {
    val eItems = skus.filter(sku => sku == "E")
    val bItems = skus.filter(skus => skus == "B")

    
  }
}
