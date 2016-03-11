package org.kimutyam.hexagonalExample.batch

import org.kimutyam.hexagonalExample.port.primary.batch.adapter.cli.Batch

class BatchLauncher(batch: Batch) extends App {
  batch.mainProcess(args)
}
