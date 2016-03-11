package org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.kvs.user

import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.{UserRepository, User}

class UserRepositoryOnKVS extends UserRepository {
  override def resolveBy(id: Long): Option[User] = ???

  override def store(entity: User): Unit = ???

  override def deleteBy(id: Long): Unit = ???
}
