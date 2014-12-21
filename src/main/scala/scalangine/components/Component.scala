package scalangine.components

import scalangine.actors.Actor
import scalangine.entities.Entity

abstract class Component {
	def act(entity: Entity, actor: Actor, delta: Long)
}