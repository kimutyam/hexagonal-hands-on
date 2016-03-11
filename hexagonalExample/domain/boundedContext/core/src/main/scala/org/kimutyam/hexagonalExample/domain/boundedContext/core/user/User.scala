package org.kimutyam.hexagonalExample.domain.boundedContext.core.user

trait User {
  val id: String
  val name: String
  val email: String
}

object User {
  def apply(id: String, name: String, email: String): User = UserImpl(id, name, email)
}
