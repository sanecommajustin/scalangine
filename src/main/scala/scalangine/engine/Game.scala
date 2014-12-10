package scalangine.engine

import scalangine.components.MouseInputComponent
import org.lwjgl.input.{Keyboard, Mouse}
import org.lwjgl.opengl.{GL11, Display, DisplayMode}

/**
 * Created by maxim_000 on 11/19/2014.
 */
object Game extends BasicGameRunner with MouseInputComponent {

  var mouseCoordinates1: Tuple2[Float, Float] = (0, 0)
  var mouseCoordinates2: Tuple2[Float, Float] = (800, 0)
  var mouseCoordinates3: Tuple2[Float, Float] = (400, 600)

//  def main(args: Array[String]): Unit = {
//    start
//  }

  override def initialize: Unit = {
    Display setDisplayMode(new DisplayMode(800,600));
    Display create()
    Display setTitle("Let's make a game!")
    
    GL11.glMatrixMode(GL11.GL_PROJECTION);
    GL11.glLoadIdentity();
    GL11.glOrtho(0, 800, 0, 600, 1, -1);
    GL11.glMatrixMode(GL11.GL_MODELVIEW);
  }

  override def update: Unit = {
    pollInput
  }

  override def draw: Unit = {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)

    GL11.glColor3f(0.5f,0.5f,1.0f)

    GL11.glBegin(GL11.GL_TRIANGLES)
    (GL11.glVertex2f _).tupled(mouseCoordinates1)
    (GL11.glVertex2f _).tupled(mouseCoordinates2)
    (GL11.glVertex2f _).tupled(mouseCoordinates3)
    GL11.glEnd

    GL11.glColor3f(0.3f, 0.6f, 0.9f)
    GL11.glBegin(GL11.GL_QUADS)
    GL11.glVertex2f(0, 0)
    GL11.glVertex2f(50, 0)
    GL11.glVertex2f(50, 50)
    GL11.glVertex2f(0, 50)
    GL11.glEnd
  }

  def pollInput = {
    determineMouseInput

    if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
      println("SPACE KEY IS DOWN");
    }

    while (Keyboard.next()) {
      if (Keyboard.getEventKeyState()) {
        if (Keyboard.getEventKey() == Keyboard.KEY_A) {
          println("A Key Pressed");
        }
        if (Keyboard.getEventKey() == Keyboard.KEY_S) {
          println("S Key Pressed");
        }
        if (Keyboard.getEventKey() == Keyboard.KEY_D) {
          println("D Key Pressed");
        }
      } else {
        if (Keyboard.getEventKey() == Keyboard.KEY_A) {
          println("A Key Released");
        }
        if (Keyboard.getEventKey() == Keyboard.KEY_S) {
          println("S Key Released");
        }
        if (Keyboard.getEventKey() == Keyboard.KEY_D) {
          println("D Key Released");
        }
        if(Keyboard.getEventKey == Keyboard.KEY_ESCAPE) {
          initiateGameClose = true
        }
      }
    }
  }
}
