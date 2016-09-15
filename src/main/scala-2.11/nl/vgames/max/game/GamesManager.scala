package nl.vgames.max.game

/**
  * Created by maxvasterd on 11/09/16.
  */
case class GamesManager(games: List[Game]) {

  def newGame(maximumNumber: Int, sumLength: Int) = Game(maximumNumber, games.length) :: games
//  def removeGame(identifier: Int) = this.games diff List(Game(_,_,identifier))
//  def getGameNumbers(identifier: Int) = this.games.filter(_.identifier == identifier).head.numbers
}
