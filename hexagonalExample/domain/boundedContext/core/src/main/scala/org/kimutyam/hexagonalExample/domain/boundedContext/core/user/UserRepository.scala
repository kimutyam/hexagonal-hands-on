package org.kimutyam.hexagonalExample.domain.boundedContext.core.user

trait UserRepository {
  def resolveBy(id: Long): Option[User]

  def store(entity: User): Unit

  def deleteBy(id: Long): Unit
}

