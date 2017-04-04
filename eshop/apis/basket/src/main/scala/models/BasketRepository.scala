package models

import akka.actor.ActorSystem
import akka.util.ByteString
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import redis.RedisClient

import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._


class BasketRepository(implicit actorSystem: ActorSystem) extends Repository {
  val redis = RedisClient()

  override def getBasket(customerId: String): Future[Option[CustomerBasket]] = {
    redis.get(customerId) map { byteString => {
      val value:Either[Error, CustomerBasket] = decode[CustomerBasket](byteString.get.toString())

      if(value.isLeft){
        println("Couldn't find %s, Error: %s", customerId, value.left.get.getMessage)
        None
      }
      else{
        Some(value.right.get)
      }
    }
    }
  }

  override def updateBasket(basket: CustomerBasket): Future[Option[CustomerBasket]] = {
    val x: Future[Boolean] = redis.set(basket.buyerId, basket.asJson.noSpaces)

    x map { created => {
      if (created) {
        // TODO:
        // GetBasket(basket.BuyerId) map { _ map { o => Some(o) }}
        Some(CustomerBasket(basket.buyerId))
      } else None
    }
    }
  }

  override def deleteBasket(id: String): Future[Boolean] = redis.del(id) map { rowDeleted => rowDeleted == 1 }

}
