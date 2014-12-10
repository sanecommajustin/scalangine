package scalangine.components

import scalangine.engine.Game
import scalangine.utilities.MathUtil
import org.lwjgl.input.Mouse
import scalangine.engine.Game3

/**
 * Created by maxim_000 on 11/27/2014.
 */
trait MouseInputComponent {

  /**
   * Determines mouse location when mouse button 0 is pressed.
   */
  def determineMouseInput = {
    if (Mouse.isButtonDown(0)) {
      val mouseCoordinates = (Mouse.getX().toFloat, Mouse.getY.toFloat)

      val coordinates = Map(1 -> Game.mouseCoordinates1, 2 -> Game.mouseCoordinates2, 3 -> Game.mouseCoordinates3)
      val shortestDistance = coordinates.map(v => v._1 -> MathUtil.distance2D(mouseCoordinates, v._2)).toMap.minBy(_._2)._1

      shortestDistance match {
        case 1 => Game.mouseCoordinates1 = mouseCoordinates
        case 2 => Game.mouseCoordinates2 = mouseCoordinates
        case 3 => Game.mouseCoordinates3 = mouseCoordinates
      }
    }
  }
}
