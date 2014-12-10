package scalangine.display

import org.lwjgl.opengl.GL11

case class Rectangle(x: Float, y: Float, width: Float, height: Float)
case class Triangle(p1: Tuple2[Float, Float], p2: Tuple2[Float, Float], p3: Tuple2[Float, Float])

object Shapes {
	type Color = Tuple3[Float, Float, Float]
	
	def drawRectangle(rect: Rectangle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	    GL11.glBegin(GL11.GL_QUADS)
		    GL11.glVertex2f(rect.x, rect.y)
		    GL11.glVertex2f(rect.width, rect.y)
		    GL11.glVertex2f(rect.width, rect.height)
		    GL11.glVertex2f(rect.x, rect.height)
	    GL11.glEnd
	}
	
	def drawTriangle(tri: Triangle, color: Color) {
	  (GL11.glColor3f _).tupled(color)
	    GL11.glBegin(GL11.GL_TRIANGLES)
		    (GL11.glVertex2f _).tupled(tri.p1)
		    (GL11.glVertex2f _).tupled(tri.p2)
		    (GL11.glVertex2f _).tupled(tri.p3)
	    GL11.glEnd
	}
}