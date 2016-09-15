package nl.vgames.max.game

import scala.util.Random

/**
  * Created by maxvasterd on 08/09/16.
  */

/**
  * @param maxValue
  */
sealed case class Game (
                         maxValue: Int,
                         identifier: Int
           ) {

  val random = Random

  def createExpression() = createExpression(random.nextInt(8) + 2)
  def createExpression(remainingLevels: Int): Expression =
    if (remainingLevels <= 0)
      Number(random.nextInt(maxValue) + 1)
    else
      random.nextInt(3) match {
        case 0 => Plus(createExpression(remainingLevels - 1), Number(random.nextInt(maxValue)))
        case 1 => Minus(createExpression(remainingLevels - 1), Number(random.nextInt(maxValue)))
        case 2 => Sqrt(createExpression(remainingLevels - 1))
      }

  def getExpressionResult(operand: Expression) = operand.eval()
}
