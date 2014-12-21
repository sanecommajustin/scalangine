package scalangine.samples

import org.lwjgl.opengl.Display
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.DisplayMode
import scalangine.states.FirstState
import scalangine.states.FlashSampleState
import scalangine.engine.StateGameRunner

object Game5 extends StateGameRunner {

  def main(args: Array[String]): Unit = {
    startScreen
    start
  }

  def startScreen: Unit = {
    screenWidth = 800
    screenHeight = 600
    Display setDisplayMode(new DisplayMode(screenWidth , screenHeight));
    Display create()
    Display setTitle("Let's make a game!")
    
    GL11 glMatrixMode(GL11.GL_PROJECTION);
    GL11 glLoadIdentity();
    GL11 glOrtho(0, 800, 0, 600, 1, -1);
    GL11 glMatrixMode(GL11.GL_MODELVIEW);
  }
  
  override def initializeStates = {
    gameStates = new FlashSampleState(1) :: new FirstState(2) :: Nil
  }
}