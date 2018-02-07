package kata

import org.scalatest.{FlatSpec, Matchers}

class AnswerSpec extends FlatSpec with Matchers {

  "PossibleAnswer" should "convert a list of elements to the answer format" in {
    val answer = PossibleAnswer(List(Element("Ge", "germanium"), Element("Ni", "nickel")))

    answer.toString shouldBe "GeNi (germanium nickel)"
  }
}