package org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.util

import com.github.tototoshi.play2.json4s.jackson.Json4s

trait JsonHelper
  extends JsonResponseHelper
  with JsonDefaultFormatHelper
  with Json4s

object JsonHelper extends JsonHelper
