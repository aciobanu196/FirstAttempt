package DBrelated

case class Customer(id: Option[Long] = None,
                    customerName: String,
                    customerEmail: String,
                    customerAdress: String)
