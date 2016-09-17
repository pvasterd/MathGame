package nl.vgames.max.game

trait Operator

trait BinaryOperator extends Operator {
  def createExpression(left:Expression, right: Expression): Expression
}

trait UnaryOperator extends Operator {
  def createExpression(expr:Expression): Expression
}

object MinusOperator extends BinaryOperator {
  def createExpression(left:Expression, right: Expression): Expression = Minus(left,right)
}

object PlusOperator extends BinaryOperator {
  def createExpression(left:Expression, right: Expression): Expression = Plus(left,right)
}

object SqrtOperator extends UnaryOperator {
  def createExpression(expr:Expression): Expression = Sqrt(expr)
}
