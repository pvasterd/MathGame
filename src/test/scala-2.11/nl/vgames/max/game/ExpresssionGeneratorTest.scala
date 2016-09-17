package nl.vgames.max.game

import org.scalatest.FunSuite

/**
  * Created by peter on 17-9-16.
  */
class ExpresssionGeneratorTest  extends FunSuite {

  test("Generate test single value and single binary operator") {
    val expression = ExpressionGenerator.createExpression(List(1), List(MinusOperator))
    assert(expression == Number(1))
  }

  test("Generate test single value and single unary operator") {
    val expression = ExpressionGenerator.createExpression(List(1), List(SqrtOperator))
    assert(expression == Number(1))
  }

  test("Generate test two values") {
    val expression = ExpressionGenerator.createExpression(List(1,2), List(MinusOperator))
    assert(expression == Minus(Number(1), Number(2)))
  }

  test("Generate test two values, two binary operators") {
    val expression = ExpressionGenerator.createExpression(List(1,2), List(MinusOperator, PlusOperator))
    assert(expression == Minus(Number(1), Number(2)) || expression == Plus(Number(1), Number(2)))
  }

  test("Generate test mulitple values, single binary operators, no unary") {
    val expression = ExpressionGenerator.createExpression(List(1,2,3,4), List(MinusOperator))
    assert(expression.toString == "(((1-2)-3)-4)")
  }

}
