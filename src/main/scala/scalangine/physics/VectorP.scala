package scalangine.physics

class VectorP(magnitude: Double, direction: Double) {
  def toVector2d: Vector2[Double] = {
    val x = Math.cos(direction) * magnitude
    val y = Math.sin(direction) * magnitude
    Vector2[Double](x, y)
  }
  
  def toVector2f: Vector2[Float] = {
    val result: Vector2[Double] = toVector2d
    Vector2[Float](result.x.toFloat, result.y.toFloat)
  }
}