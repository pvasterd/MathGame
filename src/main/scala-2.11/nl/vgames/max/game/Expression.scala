package nl.vgames.max.game

/**
  * Created by maxvasterd on 08/09/16.
  */
trait Expression {
  def eval(): Int
  def size(): Int
  def numbers: List[Int]
}

trait Operation {

}

//TODO Operation extends Operand seems "odd"
abstract class BinaryOperation(val operand1: Expression, val operand2: Expression) extends Operation with Expression {
  def size(): Int = 1 + operand1.size() + operand2.size()
  def numbers = operand1.numbers ::: operand2.numbers
}

abstract class UnaryOperation(val operand1: Expression) extends  Operation with Expression {
  def size(): Int = 1 + operand1.size()
  def numbers = operand1.numbers
}

case class Plus(override val operand1: Expression, override val operand2: Expression) extends BinaryOperation(operand1, operand2) {
  def eval(): Int = operand1.eval() + operand2.eval()
  override def toString() = "Plus(" + operand1 + "," + operand2 + ")"
}

case class Minus(override val operand1: Expression, override val operand2: Expression) extends BinaryOperation(operand1, operand2) {
  def eval(): Int = operand1.eval() - operand2.eval()
  override def toString() = "Minus(" + operand1 + "," + operand2 + ")"
}

case class Sqrt(override val operand1: Expression) extends UnaryOperation(operand1) {
  def eval(): Int = Math.sqrt(operand1.eval()).toInt
  override def toString() = "Sqrt(" + operand1 + ")"
}

case class Number(number: Int) extends Expression {
  def eval(): Int = number
  def size(): Int = 1
  def numbers: List[Int] = List(number)
  override def toString() = number.toString
}
