package org.kimutyam.hexagonalExample.port.primary.webService.adapter.http.util

trait Response

case class ErrorResponse(
  errorType: String,
  message: String,
  errorDetails: Seq[ErrorDetail] = Seq()) extends Response

case class ErrorDetail(
  errorType: String,
  message: String)

case class PagingResponse[A](
    data: Seq[A],
    paging: Option[Paging] = None) extends Response {
  def this(data: Seq[A], paging: Paging) = this(data, Some(paging))
}

case class Paging(
  offset: Long,
  limit: Long,
  total: Option[Long])
