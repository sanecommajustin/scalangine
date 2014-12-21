package scalangine.entities

import scalangine.physics.Vector2
import scalangine.engine.GameRunner

abstract class Entity {
	var x: Float = 0f
	var y: Float = 0f
	var deltaV: Vector2[Float] = Vector2(0f, 0f)
	var zIndex: Int = 0
	
	def init(x: Float, y: Float) {
		this.x = x
		this.y = y
	}
	
	def update(gameRunner: GameRunner, delta: Long)
	def draw(gameRunner: GameRunner)
}