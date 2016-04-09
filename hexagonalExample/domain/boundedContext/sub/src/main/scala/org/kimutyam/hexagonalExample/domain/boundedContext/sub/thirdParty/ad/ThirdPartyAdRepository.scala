package org.kimutyam.hexagonalExample.domain.boundedContext.sub.thirdParty.ad

trait ThirdPartyAdRepository {
  def resolveAll: Seq[ThirdPartyAd]
}
