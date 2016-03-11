package org.kimutyam.hexagonalExample.domain.boundedContext.core.ad

trait Ad {
  val id: Long
  val name: String
  val isActive: Boolean
}

object Ad {
  def apply(id: Long, name: String, isActive: Boolean): Ad = AdImpl(id, name, isActive)
}