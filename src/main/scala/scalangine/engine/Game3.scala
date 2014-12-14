package scalangine.engine

import org.lwjgl.opengl.Display
import org.lwjgl.opengl.GL11
import scalangine.components.MouseInputComponent
import org.lwjgl.input.Keyboard
import org.lwjgl.opengl.DisplayMode
import scalangine.display.Shapes
import scalangine.display.Color
import scalangine.display.Rectangle
import scalangine.display.Triangle
import scalangine.display.Circle

object Game3 extends BasicGameRunner {

  def main(args: Array[String]): Unit = {
    start
  }

  override def initialize: Unit = {
    Display setDisplayMode(new DisplayMode(800,600));
    Display create()
    Display setTitle("Let's make a game!")
    
    GL11 glMatrixMode(GL11.GL_PROJECTION);
    GL11 glLoadIdentity();
    GL11 glOrtho(0, 800, 0, 600, 1, -1);
    GL11 glMatrixMode(GL11.GL_MODELVIEW);
  }

  override def update: Unit = {
    
  }

  override def draw: Unit = {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
    GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    
//    Shapes.drawRectangle(Rectangle(0, 0, 800, 600), Color.BLACK, true)
//    Shapes.drawRectangle(Rectangle(10, 10, 50, 50), Color.ORANGE, false)
//    Shapes.drawTriangle(Triangle((200, 200),(200, 250), (250, 250)) , Color.PURPLE, true)
//    Shapes.drawCircle(Circle(400,400, 40, 40), Color.CYAN, true)
    
  }
}