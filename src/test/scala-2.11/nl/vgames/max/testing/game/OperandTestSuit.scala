package nl.vgames.max.testing.game

import nl.vgames.max.game._
import org.scalatest.FunSuite

/**
  * Created by maxvasterd on 08/09/16.
  */
class OperandTestSuit extends FunSuite {


  /**
    * Testing class for the Operand.scala file including:
    *  - 'Operand'.eval
    *  - 'Operand'.numbers
    *  - 'Operand'.size
    *
    *  'Operand' is one of: Plus,Minus,Sqrt
    */

  test("Plus(1,1) should be 2") {
    assert(Plus(Number(1), Number(1)).eval() === 2)
  }

  test("eval() a number is the integer value passed to the number") {
    assert(Number(1).eval() === 1)
  }

  test("Minus(1,1) should be 0") {
    assert( Minus(Number(1),Number(1)).eval() === 0)
  }

  test("Sqrt(4) should be 2") {
    assert( Sqrt(Number(4)).eval() === 2)
  }

  test("Size of Plus(2,2)") {
    assert(Plus(Number(2),Number(2)).size() === 3)
  }

  test("Size of Sqrt(2)") {
    assert( Sqrt(Number(2)).size === 2)
  }

  test("Size of Plus(Plus(2,2),Minus(2,2))") {
    assert( Plus (Plus(Number(2),Number(2)),Minus(Number(2),Number(2)) ).size() === 7)
  }

  test("List of Plus(Plus(2,2),Minus(2,2))") {
    assert( Plus (Plus(Number(2),Number(2)),Minus(Number(2),Number(2)) ).numbers === List(2,2,2,2))
  }

  test("List of Plus(2,2)") {
    assert( Plus(Number(2),Number(2)).numbers === List(2,2))
  }

  test("List of Sqrt(2)") {
    assert( Sqrt(Number(2)).numbers === List(2))
  }

  test("toString of all operators = Plus( Minus(2,2),Sqrt(2) )") {
    assert( Plus( Minus(Number(2),Number(2)), Sqrt(Number(2))).toString() === "Plus(Minus(2,2),Sqrt(2))")
  }


}
