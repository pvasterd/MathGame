package nl.vgames.max.main

import nl.vgames.max.game.Game

/**
  * Created by maxvasterd on 08/09/16.
  */
object Main extends App{


  val creator = new Game(10, 0)

  val expression = creator.createExpression
  val unbalancedSumNumbers = expression.numbers
  val unbalancedSumResult = expression.eval()


  print (
   "Expression: " + expression + "\n Numbers: " + unbalancedSumNumbers + "\n Result: " + unbalancedSumResult + "\n"
  )
}
