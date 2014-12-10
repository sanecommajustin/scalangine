package scalangine.utilities

/**
 * Created by maxim_000 on 11/27/2014.
 */
object MathUtil {
  /**
   * Basic distance formula. Finds the distance between 2 points on a 2d plane
   * @param point1 The first x, y coordinate
   * @param point2 The second x, y coordinate.
   * @return The distance between the 2 points.
   */
  def distance2D(point1: Tuple2[Float, Float], point2: Tuple2[Float, Float]): Float = {
    Math.sqrt(Math.pow(point1._1 - point2._1, 2) + Math.pow(point1._2 - point2._2, 2)).toFloat
  }

  def distance3D(point1: Tuple3[Float, Float, Float], point2: Tuple3[Float, Float, Float]): Float = {
    Math.sqrt(Math.pow(point1._1 - point2._1, 2) + Math.pow(point1._2 - point2._2, 2) + Math.pow(point1._3 - point2._3, 2)).toFloat
  }
}
