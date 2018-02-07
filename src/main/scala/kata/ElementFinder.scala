package kata

sealed trait Answer
case class Element(symbol: String, name: String)
case class NoSolution() extends Answer

case class PossibleAnswer(elements: List[Element]) extends Answer {
  override def toString(): String = {
    s"${elements.map(_.symbol).mkString} (${elements.map(_.name).mkString(" ")})"
  }
}

class ElementFinder {
  def spell(word: String): String = {
    findElements(word.toLowerCase()).toString
  }

  def findElements(word: String): PossibleAnswer = {
    attempt(word) match {
      case solution: PossibleAnswer => solution
      case _ => throw new Exception("No solution")
    }
  }

  private def attempt(word: String): Answer = {
    if (word.length == 0) { return PossibleAnswer(List.empty) }
    for (element <- PeriodicTable.elements) {
      if (word.startsWith(element.symbol.toLowerCase())) {
        val rest = word.substring(element.symbol.length)
        attempt(rest) match {
          case answer: PossibleAnswer => return PossibleAnswer(List(element) ++ answer.elements)
          case _ =>
        }
      }
    }
    NoSolution()
  }
}

object PeriodicTable {

  val csv = scala.io.Source.fromFile("src/main/resources/table.csv")

  val elements = csv.getLines.map(line => {
    val cols = line.split(",").map(_.trim)
    Element(cols(1), cols(0).toLowerCase())
  }).toList

  // println(elements)
}