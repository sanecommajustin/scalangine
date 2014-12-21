package scalangine.entities

import scalangine.display.Rectangle
import scalangine.display.Shapes
import scalangine.display.Color
import scalangine.engine.GameRunner

class Background extends Entity {
  zIndex = 0
	
//	override def init(_x: Float, _y: Float) {
//		x = _x
//		y = _y
//	}
	
	override def update(gameRunner: GameRunner, delta: Long) = {
	}
	
	override def draw(gameRunner: GameRunner) = {
	  Shapes.drawRectangle(Rectangle(x, y, 800, 800), Color.BLUE, true)
	}
}