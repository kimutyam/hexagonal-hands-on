package org.kimutyam.hexagonalExample.domain.boundedContext.thirdParty.ad

trait ThirdPartyAdRepository {
  def resolveAll: Seq[ThirdPartyAd]
}
