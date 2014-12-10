package scalangine.display

import scala.collection.mutable.{Map, HashMap}

case class RGB(r: Int, g: Int, b: Int)

object Color {
	val RED = 		(1f, 0f, 0f)
	val GREEN = 	(0f, 1f, 0f)
	val BLUE = 		(0f, 0f, 1f)
	val BLACK = 	(0f, 0f, 0f)
	val WHITE = 	(1f, 1f, 1f)
	val YELLOW = 	(1f, 1f, 0f)
	val PURPLE = 	(1f, 0f, 1f)
	val CYAN = 		(0f, 1f, 1f)
	val MAGENTA = 	(1f, 0f, 1f)
	val ORANGE = 	(1f, .5f, 0f)
	
	var customColor: Map[String, Tuple3[Float, Float, Float]] = new HashMap[String, Tuple3[Float, Float, Float]]()
	
	/**
	 * Can set a custom color for use everywhere.
	 */
	def addCustomColor(colorName: String, newColor: Tuple3[Float, Float, Float]): Unit = {
	  customColor + (colorName -> newColor)
	}
	
	/**
	 * Can set a custom color for use everywhere.
	 */
	def addCustomColor(colorName: String, newColor: RGB): Unit = {
	  customColor + (colorName -> (newColor.r.toFloat / 255f, newColor.g.toFloat / 255f, newColor.b.toFloat / 255f))
	}
	
	/**
	 * Gets a custom color or black if there isn't one.
	 */
	def getColor(colorName: String): Tuple3[Float, Float, Float] = {
	  customColor.getOrElse(colorName, BLACK)
	}
}