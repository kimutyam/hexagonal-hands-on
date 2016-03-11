package org.kimutyam.hexagonalExample.batch

import org.kimutyam.hexagonalExample.port.primary.batch.adapter.cli.AdDownloadBatch
import org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.rdbms.ad.AdRepositoryOnRDBMS
import org.kimutyam.hexagonalExample.port.secondary.thirdPartyAPI.adapter.http.ad.ThirdPartyAdRepositoryOnAPI

object AdDownloadBatchLauncher extends BatchLauncher(
  new AdDownloadBatch(
    new AdRepositoryOnRDBMS,
    new ThirdPartyAdRepositoryOnAPI
  )
)
