package nl.vgames.max.game

import scala.util.Random


object ExpressionGenerator {

  val random = Random

//  def createExpression(numValues: Int, maxValue: Int): Expression = ???

  def createExpression(values: List[Int], operators: List[Operator], parentExpression: Expression = null): Expression = {

    assert(operators != null && operators.size > 0)

    val operator = operators(random.nextInt(operators.size))

    (values, operator, parentExpression) match {
      case (Nil, _, _) =>
        parentExpression
      case (x1::Nil, _, null) =>
        createExpression(Nil, operators, Number(x1))
      case (x1::x2::rest, oper: BinaryOperator, null) =>
        createExpression(rest, operators, oper.createExpression(Number(x1),Number(x2)))
      case (x1::Nil, oper:BinaryOperator, parent) =>
        createExpression(Nil, operators, oper.createExpression(parentExpression, Number(x1)))
      case (x1::rest, oper: BinaryOperator, parentExpression) =>
        createExpression(rest, operators, oper.createExpression(parentExpression,Number(x1)))
      case (values, oper: UnaryOperator, parentExpression) =>
        createExpression(values, operators, oper.createExpression(parentExpression))
    }

  }

  def generateValues(numValues: Int, maxValue: Int): List[Int] =
    (1 to numValues).toList.map( a => random.nextInt(maxValue))
}
