package org.kimutyam.hexagonalExample.port.secondary.thirdPartyAPI.adapter.http.ad

import org.kimutyam.hexagonalExample.domain.boundedContext.sub.thirdParty.ad.{ThirdPartyAd, ThirdPartyAdRepository}

class ThirdPartyAdRepositoryOnAPI extends ThirdPartyAdRepository {
  def resolveAll: Seq[ThirdPartyAd] = ???
}
