package org.kimutyam.hexagonalExample

import com.google.inject.AbstractModule
import org.kimutyam.hexagonalExample.application.service.UserRegister
import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.UserRepository
import org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.kvs.user.UserRepositoryOnKVS
import org.kimutyam.hexagonalExample.port.secondary.persistence.adapter.rdbms.user.UserRepositoryOnRDBMS
import org.kimutyam.hexagonalExample.port.secondary.persistence.user.UserOptimisationRepository

class DependencyInjector extends AbstractModule {

  lazy val userRepository: UserRepository =
    new UserOptimisationRepository(
      repositoryOnKVS = new UserRepositoryOnKVS,
      repositoryOnRDBMS = new UserRepositoryOnRDBMS
    )

  lazy val userRegister: UserRegister =
    new UserRegister(userRepository)

  override def configure(): Unit = {
    bind(classOf[UserRepository])
      .toInstance(userRepository)

    bind(classOf[UserRegister])
      .toInstance(userRegister)
  }
}
