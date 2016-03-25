package org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.controller

import com.google.inject.Inject
import org.kimutyam.hexagonalExample.application.dto.user.{UserWriteDTO, UserReadDTO}
import org.kimutyam.hexagonalExample.application.service.UserRegister
import org.kimutyam.hexagonalExample.domain.boundedContext.core.user.{UserRepository, User}
import play.api.mvc.{Action, Controller, EssentialAction, Result}
import org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.util.DefaultJsonHelper._

class UserController @Inject()(
                                userRepository: UserRepository,
                                userRegister: UserRegister
                              ) extends Controller {
  def get(id: Long): EssentialAction = Action {
    val user: Option[User] = userRepository.resolveBy(id)
    user.fold[Result](
      NotFound(toErrorJson(s"Not Found", s"User Not Found: id = $id"))
    ) { user =>
      Ok(toJson(UserReadDTO(user)))
    }
  }

  def create: EssentialAction = Action(json) { implicit request =>
    val dtos = request.body.extract[Seq[UserWriteDTO]]
    dtos.foreach { dto =>
      userRegister.regist(dto)
    }
    Ok(toPagingJson(dtos))
  }
}
