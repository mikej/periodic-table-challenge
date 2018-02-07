package kata

import org.scalatest.{FlatSpec, Matchers}

class ElementFinderSpec extends FlatSpec with Matchers {

  it should "find the elements that spell genius" in {
    val finder = new ElementFinder

    val result = finder.spell("genius")

    result shouldBe "GeNiUS (germanium nickel uranium sulfur)"
  }

  it should "find the elements that spell bacon" in {
    val finder = new ElementFinder

    val result = finder.spell("bacon")

    result shouldBe "BaCoN (barium cobalt nitrogen)"
  }

}
