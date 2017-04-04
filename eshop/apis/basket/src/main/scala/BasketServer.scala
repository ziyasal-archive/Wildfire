import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import models.BasketRepository

import scala.io.StdIn

object BasketAppServer extends App {

  implicit val system = ActorSystem("basket-api-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  //TODO: DI
  val basketRepository = new BasketRepository()
  val basketRest = new BasketRest(basketRepository)

  val bindingFuture = Http().bindAndHandle(basketRest.route, "localhost", 8080)

  println(s"The Basket server is ready to handle HTTP requests")

  StdIn.readLine
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}