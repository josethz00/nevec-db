package utils

import java.nio.file._

object FileUtil {
  def createFile(filename: String): Boolean = {
    val path = Paths.get(filename)
    if (!Files.exists(path)) {
        Files.createFile(path)
        println("File created succesfully")
        return true
    } else {
        println("A file with this name already exists")
        return false
    }
  }

  def createOutputStream(filename: String): java.io.FileOutputStream = {
    val path = Paths.get(filename)
    if (!Files.exists(path)) {
        Files.createFile(path)
        println("File created succesfully")
    } else {
        println("A file with this name already exists")
    }
    return new java.io.FileOutputStream(filename)
  }
}
