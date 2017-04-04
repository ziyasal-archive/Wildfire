
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import models.{BasketRepository, CustomerBasket, CustomerBasketId, CustomerBasketJsonProtocol}

class BasketRest(basketRepository: BasketRepository) extends CustomerBasketJsonProtocol {

  val route: Route =
    logRequestResult("basket-service") {
      pathPrefix("api") {
        get {
          path("" / LongNumber) { id =>

            onSuccess(basketRepository.getBasket(id.toString)) {
              case Some(customer) => complete(customer)
              case None => complete(StatusCodes.NotFound)
            }
          }
        } ~ post {
          (path("") & entity(as[CustomerBasket])) { customerBasket =>
            onSuccess(basketRepository.updateBasket(customerBasket)) {
              case customerAdded => complete(CustomerBasketId(customerAdded.get.buyerId))
            }
          }
        } ~ delete {
          path("" / LongNumber) { id =>
            onSuccess(basketRepository.deleteBasket(id.toString)) {
              case true => complete(StatusCodes.OK)
              case false => complete(StatusCodes.NotFound)
            }
          }
        }
      }
    }

}