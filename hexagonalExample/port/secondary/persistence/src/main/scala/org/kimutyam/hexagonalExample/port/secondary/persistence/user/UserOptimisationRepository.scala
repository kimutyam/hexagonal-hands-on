package org.kimutyam.hexagonalExample.port.secondary.persistence.user

import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.{UserRepository, User}
import org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.kvs.user.UserRepositoryOnKVS
import org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.rdbms.user.UserRepositoryOnRDBMS

class UserOptimisationRepository(
                                  repositoryOnKVS: UserRepositoryOnKVS,
                                  repositoryOnRDBMS: UserRepositoryOnRDBMS
                                ) extends UserRepository {
  def resolveBy(id: Long): Option[User] = {
    val maybeSample = repositoryOnKVS.resolveBy(id)
    if (maybeSample.isEmpty)
      repositoryOnRDBMS.resolveBy(id)
    else
      maybeSample
  }

  def store(entity: User): Unit = {
    repositoryOnKVS.store(entity)
    repositoryOnRDBMS.store(entity)
    ()
  }

  def deleteBy(id: Long): Unit = {
    repositoryOnKVS.deleteBy(id)
    repositoryOnRDBMS.deleteBy(id)
    ()
  }
}
