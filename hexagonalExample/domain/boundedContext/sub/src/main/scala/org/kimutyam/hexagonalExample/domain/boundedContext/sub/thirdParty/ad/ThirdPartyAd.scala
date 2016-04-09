package org.kimutyam.hexagonalExample.domain.boundedContext.sub.thirdParty.ad

trait ThirdPartyAd {
  val id: Long
  val name: String
  val status: ThirdPartyAdStatus
}

object ThirdPartyAd {
  def apply(id: Long, name: String, status: ThirdPartyAdStatus): ThirdPartyAd = ThirdPartyAdImpl(id, name, status)

}