package nl.vgames.max.testing.game

import nl.vgames.max.game._
import org.scalatest.FunSuite

/**
  * Created by maxvasterd on 14/09/16.
  *
  * Because of randomness in expression creation a lot of <=
  * Also because of randomness almost never 100% lines/method covered
  */
class GameTestSuit extends FunSuite{

  test("Game numbers size createExpression") {
    val creator = Game(10,0)
    val expression = creator.createExpression(3)

    assert( expression.numbers.size <= 4)
  }

  test("Game expression size 1 + 2 + 2 + 2 = 7 ") {
    val creator = Game(10, 0)
    val expression = creator.createExpression(3)

    assert(expression.size <= 7)
  }

  test("Game get expression result") {
    val creator = Game(10, 0)
    val expression = Plus(Minus(Number(2),Number(3)), Sqrt(Number(4)))
    val result = 3

    assert(creator.getExpressionResult(expression) === 1)
  }


}
