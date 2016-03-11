package org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.rdbms.user

import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.{UserRepository, User}

class UserRepositoryOnRDBMS extends UserRepository {
  def resolveBy(id: Long): Option[User] = ???

  def store(entity: User): Unit = ???

  def deleteBy(id: Long): Unit = ???
}
