package org.kimutyam.hexagonalExample.port.secondary.persistence.ad

import org.kimutyam.hexagonalExample.domain.boundedContext.core.ad.{AdRepository, Ad}
import org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.kvs.ad.AdRepositoryOnKVS
import org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.rdbms.ad.AdRepositoryOnRDBMS

class AdOptimisationRepository(
                                repositoryOnKVS: AdRepositoryOnKVS,
                                repositoryOnRDBMS: AdRepositoryOnRDBMS
                              ) extends AdRepository {
  def resolveAll: Seq[Ad] = {
    val maybeSample = repositoryOnKVS.resolveAll
    if (maybeSample.isEmpty)
      repositoryOnRDBMS.resolveAll
    else
      maybeSample
  }

  def store(entity: Ad): Unit = {
    repositoryOnKVS.store(entity)
    repositoryOnRDBMS.store(entity)
    ()
  }
}
