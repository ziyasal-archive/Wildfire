package models

import scala.concurrent.Future


trait Repository {
  def getBasket(customerId: String): Future[Option[CustomerBasket]]

  def updateBasket(basket: CustomerBasket): Future[Option[CustomerBasket]]

  def deleteBasket(id: String): Future[Boolean]
}