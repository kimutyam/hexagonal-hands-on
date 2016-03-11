package org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.kvs.ad

import org.kimutyam.hexagonalExample.domain.boundedContext.core.ad.{AdRepository, Ad}

class AdRepositoryOnKVS extends AdRepository {
  override def resolveAll: Seq[Ad] = ???

  override def store(entity: Ad): Unit = ???
}
