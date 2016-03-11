package org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.rdbms.ad

import org.kimutyam.hexagonalExample.domain.boundedContext.core.ad.{AdRepository, Ad}

class AdRepositoryOnRDBMS extends AdRepository {
  override def resolveAll: Seq[Ad] = ???

  override def store(entity: Ad): Unit = ???
}
