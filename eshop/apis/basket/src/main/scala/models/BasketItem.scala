package models

case class BasketItem(id: String = null,
                      productId: String = null,
                      productName: String = null,
                      unitPrice: Double = 0,
                      quantity: Int = 0,
                      pictureUrl: String = null)