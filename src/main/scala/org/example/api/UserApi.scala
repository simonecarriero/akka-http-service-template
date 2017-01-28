package org.example.api

import akka.http.scaladsl.server.Directives
import de.heikoseeberger.akkahttpcirce.CirceSupport
import io.circe.generic.auto._
import org.example.model.User

object UserApi {
  final val pathBase = "users"
}

class UserApi extends Directives with CirceSupport {

  val route =
    getUsers ~
      getUser ~
      postUser

  def getUsers =
    path(UserApi.pathBase) {
      get {
        complete {
          Seq(User("Foo", "Bar"))
        }
      }
    }

  def getUser =
    path(UserApi.pathBase / Segment) { userId =>
      get {
        parameters('optionalParam.as[Boolean].?, 'requiredParam.as[String]) { (optionalParam, requiredParam) =>
          complete {
            User("Foo", "Bar")
          }
        }
      }
    }

  def postUser =
    path(UserApi.pathBase / Segment) { userId =>
      post {
        entity(as[User]) { user =>
          complete(user)
        }
      }
    }
}
