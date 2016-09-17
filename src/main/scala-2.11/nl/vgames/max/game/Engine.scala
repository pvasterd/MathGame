package nl.vgames.max.game

case class Game(val values: List[Int], val operators: List[Operator], val outcome: Int)

object Engine {

  def createGame(numValues: Int, maxValue: Int, operators: List[Operator]): Game = {
    val values = ExpressionGenerator.generateValues(numValues, maxValue)
    val solution = ExpressionGenerator.createExpression(values, operators)
    Game(values, operators, solution.eval)
  }


}
