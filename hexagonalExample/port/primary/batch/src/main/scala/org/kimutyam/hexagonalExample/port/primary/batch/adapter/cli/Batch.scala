package org.kimutyam.hexagonalExample.port.primary.batch.adapter.cli

trait Batch {
  def mainProcess(args: Seq[String]): Unit
}

