package scalangine.actors

import scalangine.entities.Entity
import scalangine.components.Component
import scalangine.physics.Vector2
import scalangine.entities.Player
import scalangine.components.GravityComponent

class PhysicsActor extends Actor {
	
	var components: Seq[Component] = Seq.empty
	var vectors: Seq[Vector2[Float]] = Seq.empty
  
	override def init() {
	  val gravity: Component = new GravityComponent(2)
	  components ++= Seq[Component] { gravity }
	}
  
	override def act(entity: Entity, delta: Long) {
	  vectors = Seq.empty
	  components.foreach(x => x.act(entity, this, delta))
	  entity.deltaV = Vector2(vectors.foldLeft(0f)((x,y) => x + y.x), vectors.foldLeft(0f)((x,y) => x + y.y))
	}
}