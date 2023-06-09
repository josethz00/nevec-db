package core

import scala.collection.mutable
import java.nio.file._
import annoy4s._

class NevecDB(name: String, dim: Int) {
    val dbName: String = name
    val dimensions: Int = dim
    val index = Annoy.create[Int]("./input_vectors", 10, outputDir = "./annoy_result/", Angular)

    val path = Paths.get(s"$dbName.json")
    if (!Files.exists(path)) {
        Files.createFile(path)
        print("Database created succesfully")
    } else {
        print("A database with this name already exists")
    }
}
