package org.kimutyam.hexagonalExample.domain.boundedContext.core.ad

case class AdImpl(
                   id: Long,
                   name: String,
                   isActive: Boolean
                 ) extends Ad
