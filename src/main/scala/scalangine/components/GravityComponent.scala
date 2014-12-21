package scalangine.components

import scalangine.actors.Actor
import scalangine.entities.Entity
import scalangine.physics.VectorP
import scalangine.actors.PhysicsActor
import scalangine.physics.Vector2
import scalangine.actors.PhysicsActor

class GravityComponent(terminalVelocity: Float) extends Component {
	def act(entity: Entity, actor: Actor, delta: Long) {
	  actor match {
	    case x: PhysicsActor => x.vectors ++= Seq[Vector2[Float]] { (new VectorP(Math.min(terminalVelocity, 1.0 + Math.abs(entity.y)), (3.0/2.0) * Math.PI)).toVector2f }
	  }
	}
}