package org.kimutyam.hexagonalExample.domain.boundedContext.sub.thirdParty.ad

sealed abstract class ThirdPartyAdStatus(val value: String)

object ThirdPartyAdStatus {

  case object Serving extends ThirdPartyAdStatus("Serving")

  case object Ended extends ThirdPartyAdStatus("Ended")

  def apply(value: String): ThirdPartyAdStatus = {
    value match {
      case Serving.value => Serving
      case Ended.value => Ended
      case _ => throw new IllegalArgumentException(s"value '$value' is not AdStatus value")
    }
  }
}
