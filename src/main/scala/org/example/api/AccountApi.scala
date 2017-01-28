package org.example.api

import akka.http.scaladsl.server.Directives
import de.heikoseeberger.akkahttpcirce.CirceSupport
import io.circe.generic.auto._
import org.example.model.Account

object AccountApi {
  final val pathBase = "accounts"
}

class AccountApi extends Directives with CirceSupport {

  val route = getAccount

  def getAccount =
    path(AccountApi.pathBase / Segment) { accountId =>
      get {
        complete {
          Account("XYZ")
        }
      }
    }
}
