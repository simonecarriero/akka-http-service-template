package org.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.RouteConcatenation
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory
import org.example.api.{AccountApi, UserApi}


trait Apis extends RouteConcatenation {
  implicit def system: ActorSystem

  val route =
    new UserApi().route ~
      new AccountApi().route
}

trait Core {
  implicit def system: ActorSystem
}

trait BootedCore extends Core {
  implicit lazy val system = ActorSystem("system")
  sys.addShutdownHook(system.terminate())
}

trait Web { this: Apis with Core =>
  implicit val actorMaterializer = ActorMaterializer()

  Http().bindAndHandle(
    route,
    ConfigFactory.load().getString("http.host"),
    ConfigFactory.load().getInt("http.port"))
}

object Main extends App with Apis with BootedCore with Web
