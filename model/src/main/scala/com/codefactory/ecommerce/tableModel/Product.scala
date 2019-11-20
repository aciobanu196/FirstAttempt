package com.codefactory.ecommerce.tableModel

final case class Product(id: Int,
                         name: String,
                         price: Int, //Int pentru pret e idee rea sau eu nu am vazut note in privinta preciziei.
                         typeID: Int,
                         quantity: Int,
                         isDeleted: Boolean)
