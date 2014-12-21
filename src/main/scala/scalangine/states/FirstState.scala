package scalangine.states

import scalangine.entities.Entity
import scalangine.entities.Player
import scalangine.engine.GameRunner

class FirstState(id: Int) extends GameState(id: Int) {
 
	var entities: List[Entity] = Nil
  
	override def init(gameRunner: GameRunner) {
	  entities = new Player :: Nil
	  entities.foreach(x => x.init(400, 400))
	}
	
	override def update(gameRunner: GameRunner, delta: Long) {
	  entities.foreach(x => x.update(gameRunner, delta))
	}
	
	override def draw(gameRunner: GameRunner) {
	  entities.foreach(x => x.draw(gameRunner))
	}
}