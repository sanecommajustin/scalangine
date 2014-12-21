package scalangine.entities

import scalangine.display.Rectangle
import scalangine.display.Shapes
import scalangine.display.Color
import scalangine.physics.Vector2
import scalangine.components.Component
import scalangine.components.GravityComponent
import scalangine.engine.GameRunner
import scalangine.actors.Actor
import scalangine.actors.PhysicsActor

class Player extends Entity {
	zIndex = 10000
	val physicsActor: Actor = new PhysicsActor
	
	override def init(_x: Float, _y: Float) {
		physicsActor.init
		x = _x
		y = _y
	}
	
	override def update(gameRunner: GameRunner, delta: Long) = {
	  physicsActor.act(this, delta)
	  x += deltaV.x
	  y += deltaV.y
	}
	
	override def draw(gameRunner: GameRunner) = {
	  Shapes.drawRectangle(Rectangle(x, y, 20, 20), Color.BLUE, true)
	}
}