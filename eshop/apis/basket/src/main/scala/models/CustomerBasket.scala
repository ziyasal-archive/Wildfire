package models
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

case class CustomerBasket(var buyerId: String) {
  var list: List[BasketItem] = List[BasketItem]()
}

case class CustomerBasketId(var id: String)

trait CustomerBasketJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val customerBasketFormat = jsonFormat1(CustomerBasket)
  implicit val customerBasketIdFormat= jsonFormat1(CustomerBasketId)
  implicit val basketItemFormat = jsonFormat6(BasketItem)
}