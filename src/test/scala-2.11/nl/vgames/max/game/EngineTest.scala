package nl.vgames.max.game

import nl.vgames.max.game._
import org.scalatest.FunSuite

/**
  * Created by maxvasterd on 14/09/16.
  *
  * Because of randomness in expression creation a lot of <=
  * Also because of randomness almost never 100% lines/method covered
  */
class EngineTest extends FunSuite{

  test("Test Game 1 number 1 Operator") {
    val game = Engine.createGame(1, 2, List(PlusOperator))
    assert(game.operators === List(PlusOperator))
    assert(game.values.size == 1)
  }

  test("Test Game 3 numbers 1 Operator") {
    val game = Engine.createGame(3, 10, List(PlusOperator))
    assert(game.operators === List(PlusOperator))
    assert(game.values.size == 3)
    assert(game.values.fold(0)(_ + _) === game.outcome)
  }

}
