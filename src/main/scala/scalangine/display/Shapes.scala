package scalangine.display

import org.lwjgl.opengl.GL11

case class Rectangle(x: Float, y: Float, width: Float, height: Float)
case class Triangle(p1: Tuple2[Float, Float], p2: Tuple2[Float, Float], p3: Tuple2[Float, Float])
case class Circle(x: Float, y: Float, radius: Float, chunks: Double)

object Shapes {
	type Color = Tuple3[Float, Float, Float]
	
	def drawRectangle(rect: Rectangle, color: Color, fill: Boolean) {
	  fill match {
	    case true => drawFilledRectangle(rect, color)
	    case false => drawRectangle(rect, color)
	  }
	}
	
	def drawTriangle(tri: Triangle, color: Color, fill: Boolean) {
	  fill match {
	    case true => drawFilledTriangle(tri, color)
	    case false => drawTriangle(tri, color)
	  }
	}
	
	def drawCircle(circ: Circle, color: Color, fill: Boolean) {
	  fill match {
	    case true => drawFilledCircle(circ, color)
	    case false => drawCircle(circ, color)
	  }
	}
	
	private def drawRectangle(rect: Rectangle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	    GL11.glBegin(GL11.GL_LINE_STRIP)
		    GL11.glVertex2f(rect.x, rect.y)
		    GL11.glVertex2f(rect.x + rect.width, rect.y)
		    GL11.glVertex2f(rect.x + rect.width, rect.y + rect.height)
		    GL11.glVertex2f(rect.x, rect.y + rect.height)
		    GL11.glVertex2f(rect.x, rect.y)
	    GL11.glEnd
	}
	
	private def drawFilledRectangle(rect: Rectangle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	    GL11.glBegin(GL11.GL_QUADS)
		    GL11.glVertex2f(rect.x, rect.y)
		    GL11.glVertex2f(rect.x + rect.width, rect.y)
		    GL11.glVertex2f(rect.x + rect.width, rect.y + rect.height)
		    GL11.glVertex2f(rect.x, rect.y + rect.height)
	    GL11.glEnd
	}
	
	private def drawFilledTriangle(tri: Triangle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	    GL11.glBegin(GL11.GL_TRIANGLES)
		    (GL11.glVertex2f _).tupled(tri.p1)
		    (GL11.glVertex2f _).tupled(tri.p2)
		    (GL11.glVertex2f _).tupled(tri.p3)
	    GL11.glEnd
	}
	
	private def drawTriangle(tri: Triangle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	    GL11.glBegin(GL11.GL_LINE_STRIP)
		    (GL11.glVertex2f _).tupled(tri.p1)
		    (GL11.glVertex2f _).tupled(tri.p2)
		    (GL11.glVertex2f _).tupled(tri.p3)
		    (GL11.glVertex2f _).tupled(tri.p1)
	    GL11.glEnd
	}
	
	private def drawCircle(circ: Circle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	  	GL11.glBegin(GL11.GL_LINE_STRIP)
  		var i: Double = 0
  		while(i < 2d * Math.PI) {
			GL11.glVertex2f((Math.cos(i) * circ.radius).toFloat + circ.x, (Math.sin(i) * circ.radius).toFloat + circ.y)
			i += Math.PI / circ.chunks 
  		}
	  	GL11.glEnd()
	}
	
	private def drawFilledCircle(circ: Circle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	  	GL11.glBegin(GL11.GL_POLYGON)
  		var i: Double = 0
  		while(i < 2d * Math.PI) {
			GL11.glVertex2f((Math.cos(i) * circ.radius).toFloat + circ.x, (Math.sin(i) * circ.radius).toFloat + circ.y)
			i += Math.PI / circ.chunks 
  		}
	  	GL11.glEnd()
	}
}