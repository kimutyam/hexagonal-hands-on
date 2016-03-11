package org.kimutyam.hexagonalExample.domain.boundedContext.core.ad

trait AdRepository {
  def resolveAll: Seq[Ad]

  def store(entity: Ad): Unit
}
