package org.kimutyam.hexagonalExample.application.boundedContextMapper

import org.kimutyam.hexagonalExample.domain.boundedContext.core.ad.Ad
import org.kimutyam.hexagonalExample.domain.boundedContext.sub.thirdParty.ad.{ThirdPartyAdStatus, ThirdPartyAd}

object AdConverter {
  def convertToAd(thirdPartyAd: ThirdPartyAd): Ad = {
    Ad(
      id = thirdPartyAd.id,
      name = thirdPartyAd.name,
      isActive = thirdPartyAd.status == ThirdPartyAdStatus.Serving
    )
  }

  def convertToThirdPartyAd(ad: Ad): ThirdPartyAd = {
    ThirdPartyAd(
      id = ad.id,
      name = ad.name,
      status =
        if (ad.isActive)
          ThirdPartyAdStatus.Serving
        else
          ThirdPartyAdStatus.Ended
    )
  }
}
