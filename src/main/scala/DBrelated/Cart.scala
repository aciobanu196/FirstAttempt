package DBrelated

case class Cart(id: Option[Long] = None,
                productName: String,
                productPrice: String,
                totalPrice: String)
//case class for the constructor which is used for the mapping part in db.DAO -> Database access object
// I know not the best name, I will change it to something more intuitive
