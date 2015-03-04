package org.project.thunder.streaming.util.io

import java.io.{BufferedWriter, FileWriter, File}

/*** Class for writing an RDD to a text file */

class TextWriter(directory: String, filename: String)
  extends Writer[Array[Double]](directory, filename) with Serializable {

  def extension = ".txt"

  def write(rdd: Iterator[(Int, Array[Double])], file: File, withIndices: Boolean = true) = {
    printToFile(file)(bw => {
      // Write out the index if it exists
      rdd.foreach(item => {
        if (withIndices) {
          bw.write("%d".format(item._1))
        }
        item._2.foreach(x => bw.write(" %.6f".format(x)))
        bw.write('\n')
      })
    })
  }

  def printToFile(f: File)(op: BufferedWriter => Unit) {
    val bw = new BufferedWriter(new FileWriter(f, true))
    try {
      op(bw)
    } finally {
      bw.close()
    }
  }

}

