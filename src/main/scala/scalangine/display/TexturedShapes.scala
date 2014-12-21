package scalangine.display

import org.lwjgl.opengl.GL11
import org.newdawn.slick.opengl.Texture

object TexturedShapes {
	type Color = Tuple3[Float, Float, Float]
	
	def drawRectangle(rect: Rectangle, color: Color, texture: Texture) {
		drawTexturedRectangle(rect, color, texture)
	}
	
	private def drawTexturedRectangle(rect: Rectangle, color: Color, texture: Texture) {
		beginTextureDraw(texture)
	    GL11.glBegin(GL11.GL_QUADS)
	    	 // for whatever reason texture draw is upside down.. I know I'm doing something wrong here but it works so fuck it. 
	    	GL11.glTexCoord2f(0, 1)
		    GL11.glVertex2f(rect.x, rect.y)
	    	GL11.glTexCoord2f(1, 1)
		    GL11.glVertex2f(rect.x + rect.width, rect.y)
	    	GL11.glTexCoord2f(1, 0)
		    GL11.glVertex2f(rect.x + rect.width, rect.y + rect.height)
	    	GL11.glTexCoord2f(0, 0)
		    GL11.glVertex2f(rect.x, rect.y + rect.height)
	    GL11.glEnd
	    endTextureDraw
	}
	
	private def beginTextureDraw(texture: Texture) = {
		GL11.glEnable(GL11.GL_TEXTURE_2D)
		GL11.glColor4f(1, 1, 1, 1);
		texture.bind()	  
	}
	
	private def endTextureDraw = GL11.glDisable(GL11.GL_TEXTURE_2D)
}