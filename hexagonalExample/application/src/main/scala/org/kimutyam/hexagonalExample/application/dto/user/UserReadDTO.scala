package org.kimutyam.hexagonalExample.application.dto.user

import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.User

case class UserReadDTO(
                        id: String,
                        name: String
                      )

object UserReadDTO {
  def apply(entity: User): UserReadDTO = {
    UserReadDTO(
      id = entity.id.toString,
      name = entity.name
    )
  }
}
