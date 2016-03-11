package org.kimutyam.hexagonalExample.port.primary.batch.adapter.cli

import org.kimutyam.hexagonalExample.application.boundedContextMapper.AdConverter
import org.kimutyam.hexagonalExample.domain.boundedContext.core.ad.AdRepository
import org.kimutyam.hexagonalExample.domain.boundedContext.thirdParty.ad.ThirdPartyAdRepository

class AdDownloadBatch(
                       adRepository: AdRepository,
                       thirdPartyAdRepository: ThirdPartyAdRepository
                     ) extends Batch {
  override def mainProcess(args: Seq[String]): Unit = {

    thirdPartyAdRepository.resolveAll.foreach { thirdPartyAd =>
      adRepository.store(AdConverter.convertToAd(thirdPartyAd))
    }
  }

}

