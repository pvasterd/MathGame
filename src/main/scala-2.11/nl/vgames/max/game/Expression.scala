package nl.vgames.max.game

trait Expression {
  def eval: Int
}

case class Minus(val left:Expression, val right: Expression) extends Expression {
  def eval: Int = left.eval  - right.eval
  override def toString: String = "(" + left + "-" + right + ")"
}

case class Plus(val left:Expression, val right: Expression) extends Expression  {
  def eval: Int = left.eval + right.eval
  override def toString: String = "(" + left + "+" + right + ")"
}

case class Sqrt(val expr: Expression) extends Expression {

  /**
    * Execute SQRT on expr, but only if returns a integer. If not
    * it returns an AssertionError
    *
    * @return
    */
  def eval: Int = {
    assert (Math.pow(Math.sqrt(expr.eval),2) == expr.eval)
    Math.sqrt(expr.eval).toInt
  }
  override def toString: String = "V" + expr

}

case class Number(val value: Int) extends Expression {
  def eval: Int = value
  override def toString: String = String.valueOf(value)
}
