package scalangine.states

import scalangine.entities.Entity
import scalangine.entities.Player
import scalangine.engine.GameRunner
import scalangine.entities.SplashItem
import scalangine.engine.StateGameRunner
import scalangine.entities.Background

class FlashSampleState(id: Int) extends GameState(id: Int) {
 
	var entities: List[Entity] = Nil
	var timer: Long = 0
  
	override def init(gameRunner: GameRunner) {
	  entities = new Background :: new SplashItem("/home/justin/Pictures/spritesheets/brickwork.png", "Wacky Adventures") :: Nil
	  entities(0).init(0, 0)
	  entities(1).init(300, 300)
	}
	
	override def update(gameRunner: GameRunner, delta: Long) {
	  entities.foreach(x => x.update(gameRunner, delta))
	  timer += delta
	  if(timer > 10000) {
	    gameRunner match {
	      case sgr: StateGameRunner => sgr.nextGameState = Some(2)  
	    }
	  }
	}
	
	override def draw(gameRunner: GameRunner) {
	  entities.foreach(x => x.draw(gameRunner))
	}
}