package nl.vgames.max.game

import nl.vgames.max.game._
import org.scalatest.FunSuite

import scala.util.{Failure, Try}

/**
  * Created by maxvasterd on 08/09/16.
  */
class ExpressionTest extends FunSuite {

  test("Plus(1,1) should be 2") {
    assert(Plus(Number(1), Number(1)).eval === 2)
  }

  test("eval() a number is the integer value passed to the number") {
    assert(Number(1).eval === 1)
  }

  test("Minus(1,1) should be 0") {
    assert( Minus(Number(1),Number(1)).eval === 0)
  }

  test("Sqrt(4) should be 2") {
    assert( Sqrt(Number(4)).eval === 2)
  }

  test("Sqrt(5) should throw assertion error") {
    assert(Try(Sqrt(Number(5)).eval).isSuccess === false)

  }

  test("Result of Plus(Plus(2,2),Minus(2,2))") {
    assert( Plus (Plus(Number(2),Number(2)),Minus(Number(2),Number(2)) ).eval=== 4)
  }

  test("toString of all operators = Plus( Minus(2,2),Sqrt(2) )") {
    assert( Plus( Minus(Number(2),Number(2)), Sqrt(Number(4))).toString() === "((2-2)+V4)")
  }

  test("toString of all operators = Plus( Minus(2,2),Sqrt(Plus(2,2)) )") {
    assert( Plus( Minus(Number(2),Number(2)), Sqrt(Plus(Number(2), Number(2)))).toString() === "((2-2)+V(2+2))")
  }

}
