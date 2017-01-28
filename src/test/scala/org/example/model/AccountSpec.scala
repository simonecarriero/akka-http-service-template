package org.example.model

import org.scalatest._

class AccountSpec extends FunSpec with Matchers {

  describe("Account") {

    it("should work") {
      Account("code").code shouldBe "code"
    }
  }
}
