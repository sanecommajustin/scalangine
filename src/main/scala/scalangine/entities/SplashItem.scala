package scalangine.entities

import scalangine.display.Rectangle
import scalangine.display.Shapes
import scalangine.display.Color
import scalangine.engine.GameRunner
import org.newdawn.slick.opengl.Texture
import org.newdawn.slick.opengl.TextureLoader
import org.newdawn.slick.util.ResourceLoader
import scalangine.display.TexturedShapes
import java.io.FileInputStream
import java.io.File

class SplashItem(splashImage: String, subtitle: String) extends Entity {
  zIndex = 0
  val texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(splashImage))
  var texRec = Rectangle(0, 0, 100, 100)
  
	override def update(gameRunner: GameRunner, delta: Long) = {
	  val newWidth = texRec.width + 1
	  val newHeight = texRec.height + 1
	  val middleX = gameRunner.screenWidth / 2
	  val middleY = gameRunner.screenHeight / 8 * 5
	  texRec = Rectangle(middleX - newWidth / 2, middleY - newHeight / 2, newWidth, newHeight)
	}
	
	override def draw(gameRunner: GameRunner) = {
	  TexturedShapes.drawRectangle(texRec, Color.BLACK , texture)
	}
}