package core

import scala.collection.mutable
import utils.FileUtil
import com.github.jelmerk.knn.scalalike.hsnw._

class NevecDB {
    var dbName: String = ""
    var dimensions: Int = 0
    var index: Option[HnswIndex[String, Array[Float], DataItem, Float]] = None
    var count: Int = 1

    def create(name: String, dimensions: Int): Unit = {
        this.dbName = name
        this.dimensions = dimensions

        this.index = new FileOutputStream("hnswIndex.bin")
        hnswIndex.save(outputStream)
        outputStream.close()
    }

    def connect(name: String): Annoy[Int] = {
        return Annoy.load[Int](s"./$name-results")
    }

    def insert(vector: Array[Float]): Unit = {
        index match {
            case Some(index) => 
                index.addItem(index, count, vector)
                count += 1
                index.save()
            case None => 
                println("Annoy index has not been initialized.")
        }
    }
}