package utils

import java.nio.file._

object FileUtil {
  def createFile(filename: String): Boolean = {
        val path = Paths.get(s"$filename.json")
        if (!Files.exists(path)) {
            Files.createFile(path)
            print("File created succesfully")
            return true
        } else {
            print("A file with this name already exists")
            return false
        }
  }
}
