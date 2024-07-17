import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.Some

class
MainTest extends AnyFlatSpec with Matchers:
  "A trivial test" should "pass" in:
    println("Hello World Scala :)")
    true shouldBe true
