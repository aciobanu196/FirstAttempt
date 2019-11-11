package DBrelated

case class Products(id: Option[Long] = None,
                    product_name: String,
                    product_price: String,
                    product_type: String)
