package org.kimutyam.hexagonalExample.domain.boundedContext.sub.thirdParty.ad

case class ThirdPartyAdImpl(
                             id: Long,
                             name: String,
                             status: ThirdPartyAdStatus
                           ) extends ThirdPartyAd
