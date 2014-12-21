package scalangine.engine

import org.lwjgl.opengl.{DisplayMode, Display}
import scalangine.states.GameState
import scala.compat.Platform

/**
 * Created by maxim_000 on 11/19/2014.
 */
trait StateGameRunner extends GameRunner {
  var initiateGameClose: Boolean = false
  var fps: Int = 60
  var gameStates: List[GameState] = List.empty
  var currentGameState: Option[Int] = None
  var previousDelta: Long = Platform.currentTime
  var nextGameState: Option[Int] = None

  def start = {
    initializeStates
    init

    while(!Display.isCloseRequested && !initiateGameClose) {
      update
      draw
      flip
    }

    Display.destroy
    System.exit(0)
  }
  
  private def init {
    if(currentGameState == None) {
    	currentGameState = Some(gameStates(0).id)
    }
    gameStates.foreach(x => x.init(this))
  }

  private def update {
    updateGameState
    val newDelta = Platform.currentTime
    val delta = newDelta - previousDelta
    previousDelta = newDelta
    gameStates.find{g => g.id == currentGameState.get}.get.update(this, delta)
  }
  
  private def draw {
    clean
    gameStates.find{g => g.id == currentGameState.get}.get.draw(this)
  }
  
  private def updateGameState {
    if(!nextGameState.isEmpty) {
      val newGameState = gameStates.find{g => g.id == currentGameState.get}
      if(!newGameState.isEmpty) {
	      gameStates.find{g => g.id == currentGameState.get}.get.exitGameState
	      currentGameState = nextGameState
	      newGameState.get.enterGameState
	      nextGameState = None
      }
    }
  }
  
  def initializeStates
  
  def flip = Display.update;Display.sync(fps)
}
