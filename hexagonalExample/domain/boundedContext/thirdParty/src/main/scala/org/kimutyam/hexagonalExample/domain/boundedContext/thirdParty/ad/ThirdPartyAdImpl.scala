package org.kimutyam.hexagonalExample.domain.boundedContext.thirdParty.ad

case class ThirdPartyAdImpl(
                             id: Long,
                             name: String,
                             status: ThirdPartyAdStatus
                           ) extends ThirdPartyAd
