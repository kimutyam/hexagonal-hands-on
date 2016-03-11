package org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.util

import org.json4s._

trait JsonResponseHelper {

  def toJson(data: Any)(implicit format: Formats): JValue = {
    Extraction.decompose(data)(format)
  }

  def toPagingJson[A](data: Seq[A], offset: Long, limit: Long, total: Option[Long] = None)(implicit format: Formats): JValue = {
    toJson(new PagingResponse(data, Paging(offset, limit, total)))(format)
  }

  def toPagingJson[A](data: Seq[A])(implicit format: Formats): JValue = {
    toJson(new PagingResponse(data))(format)
  }

  def toErrorJson(errorType: String, message: String)(implicit format: Formats): JValue = {
    toJson(ErrorResponse(errorType, message))(format)
  }

  def toErrorJson(throwable: Throwable, errorType: String)(implicit format: Formats): JValue = {
    toJson(ErrorResponse(errorType, throwable.getMessage))(format)
  }

  def toErrorJson(throwable: Throwable)(implicit format: Formats): JValue = {
    toErrorJson(throwable, "SystemError")(format)
  }
}

object JsonResponseHelper extends JsonResponseHelper
