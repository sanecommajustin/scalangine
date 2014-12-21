package scalangine.engine

import org.lwjgl.opengl.{DisplayMode, Display}

/**
 * Created by maxim_000 on 11/19/2014.
 */
trait BasicGameRunner extends ScreenCleaner {
  var initiateGameClose: Boolean = false
  var fps: Int = 60

  def start = {
    initialize

    while(!Display.isCloseRequested && !initiateGameClose) {
      update
      draw
      flip
    }

    Display.destroy
    System.exit(0)
  }

  def initialize
  def update 
  def draw
  def flip = Display.update;Display.sync(fps)
}
