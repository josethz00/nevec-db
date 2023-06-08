package core
import scala.collection.mutable
import java.nio.file._

class NevecDB(name: String, dim: Int) {
    val dbName: String = name
    val dimensions: String = dim

    val path = Paths.get(s"$dbName.json")
    if (!Files.exists(path)) {
        Files.createFile(path)
        print("Database created succesfully")
    } else {
        print("A database with this name already exists")
    }
}
