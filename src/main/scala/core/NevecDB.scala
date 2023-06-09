package core

import scala.collection.mutable
import annoy4s._
import utils.FileUtil

class NevecDB {
    var dbName: String = ""
    var dimensions: Int = 0
    var index: Option[Annoy[Int]] = None

    def create(name: String, dimensions: Int): Unit = {
        this.dbName = name
        this.dimensions = dimensions
        val isDbFileCreated = FileUtil.createFile(s"./$dbName.json")

        index = 
            if (isDbFileCreated) {
                FileUtil.createFile(s"./$dbName-input-vectors.ann")
                Some(Annoy.create[Int](s"./$dbName-input-vectors.ann", 10, outputDir = s"./$dbName-results/", Angular))
            } else {
                None
            }
    }

    def connect(name: String): Unit = {
        Annoy.load[Int](s"./$name-input-vectors.ann")
    }
}