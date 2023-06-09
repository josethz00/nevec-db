package core

import scala.collection.mutable
import annoy4s._
import utils.FileUtil

class NevecDB(name: String, dim: Int) {
    val dbName: String = name
    val dimensions: Int = dim

    val isDbFileCreated = FileUtil.createFile(s"$dbName.json")

    val index: Option[Annoy[Int]] = 
        if (isDbFileCreated) {
            FileUtil.createFile(s"$dbName-input-vectors.ann")
            Some(Annoy.create[Int](s"$dbName-input-vectors.ann", 10, outputDir = s"./$dbName-results/", Angular))
        } else {
            None
        }
    print("aaaaaaaaaaaaa")
}