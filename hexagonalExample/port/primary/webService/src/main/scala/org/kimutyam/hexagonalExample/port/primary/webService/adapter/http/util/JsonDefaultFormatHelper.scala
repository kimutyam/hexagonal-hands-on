package org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.util

import org.json4s.{DefaultFormats, Formats}

trait JsonDefaultFormatHelper {
  implicit lazy val defaultFormat: Formats = DefaultFormats
}

object JsonDefaultFormatHelper extends JsonDefaultFormatHelper
