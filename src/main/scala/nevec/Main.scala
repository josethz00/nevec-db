package nevec
import core.NevecDB

object Hello extends Greeting with App {
  println(greeting)
  val db = new NevecDB().create("mytestdb", 1536)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
