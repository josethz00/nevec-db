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
        this.index = Some(HnswIndex[String, Array[Float], DataItem, Float](
            dimensions = dimensions, 
            distanceFunction = floatCosineDistance, 
            maxItems = dataItems.size, 
            m = 16, ef = 200, efConstruction = 200
        ))
        val outputStream = FileUtil.createOutputStream(s"./$name-hsnwIndex.bin")
        this.index.save(outputStream)
        outputStream.close()
    }

    def connect(name: String): Annoy[Int] = {
        return Annoy.load[Int](s"./$name-hsnwIndex.bin")
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