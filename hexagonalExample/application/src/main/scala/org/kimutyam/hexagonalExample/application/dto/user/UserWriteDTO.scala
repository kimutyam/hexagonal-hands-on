package org.kimutyam.hexagonalExample.application.dto.user

import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.User


case class UserWriteDTO(name: String, email: String) {
  def convertUser(id: String): User = {
    User(
      id = id,
      name = name,
      email = email
    )
  }
}
