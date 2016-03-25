package org.kimutyam.hexagonalExample.application.service

import org.kimutyam.hexagonalExample.application.dto.user.UserWriteDTO
import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.UserRepository

class UserRegister(userRepository: UserRepository) {

  def regist(dto: UserWriteDTO): Unit = {
    val id = java.util.UUID.randomUUID.toString
    userRepository.store(dto.convertUser(id))
    ()
  }
}
