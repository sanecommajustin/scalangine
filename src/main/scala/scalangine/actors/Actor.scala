package scalangine.actors

import scalangine.entities.Entity

abstract class Actor {
  def init
  def act(entity: Entity, delta: Long)
}