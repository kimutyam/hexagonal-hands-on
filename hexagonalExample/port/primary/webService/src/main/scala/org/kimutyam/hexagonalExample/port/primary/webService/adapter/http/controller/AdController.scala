package org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.controller

import com.google.inject.Inject
import org.kimutyam.hexagonalExample.domain.boundedContext.core.ad.AdRepository
import play.api.mvc.{Action, EssentialAction, Controller}
import org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.util.DefaultJsonHelper._

class AdController @Inject()(
                              adRepository: AdRepository
                            ) extends Controller {
  def getList: EssentialAction = Action {
    val ads = adRepository.resolveAll

    if (ads.isEmpty)
      NotFound
    else
      Ok(toPagingJson(ads))
  }
}
