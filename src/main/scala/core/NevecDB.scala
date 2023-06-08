package core
import scala.collection.mutable
import java.nio.file._

class NevecDB(dbName: String, dimensions: Int) {
    val dbName: String = dbName
    val dimensions: String = dimensions

    val path = Paths.get(s"$dbName.json")
    if (!Files.exists(path)) {
        Files.createFile(path)
        print("Database created succesfully")
    } else {
        print("A database with this name already exists")
    }
}
