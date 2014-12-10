package scalangine.engine

import scalangine.components.MouseInputComponent
import org.lwjgl.opengl.Display
import org.lwjgl.LWJGLException
import org.lwjgl.opengl.DisplayMode
import org.lwjgl.opengl.GL11
import java.io.IOException
import org.newdawn.slick.Color
import org.newdawn.slick.opengl.Texture
import org.newdawn.slick.opengl.TextureLoader
import org.newdawn.slick.util.ResourceLoader

object Game2 {
	var texture: Texture = null

//	def main(args: Array[String]) {
//		start
//	}
	
	def start {
		initGL(800,600)
		init
 
		while (true) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT)
			render
 
			Display.update()
			Display.sync(100)
 
			if (Display.isCloseRequested()) {
				Display.destroy();
				System.exit(0);
			}
		}
	}
 
	def initGL(width: Int, height: Int) {
		try {
			Display.setDisplayMode(new DisplayMode(width,height))
			Display.create()
			Display.setVSyncEnabled(true)
		} 
		catch {
			case e: LWJGLException => e.printStackTrace();System.exit(0)
		}
 
		GL11.glEnable(GL11.GL_TEXTURE_2D)
 
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f)          
        GL11.glEnable(GL11.GL_BLEND)
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
 
        GL11.glViewport(0,0,width,height)
		GL11.glMatrixMode(GL11.GL_MODELVIEW)
 
		GL11.glMatrixMode(GL11.GL_PROJECTION)
		GL11.glLoadIdentity()
		GL11.glOrtho(0, width, height, 0, 1, -1)
		GL11.glMatrixMode(GL11.GL_MODELVIEW)
	}
 
	def init {
 
		try {
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("C:\\Users\\maxim_000\\Documents\\Development\\Ludum Dare\\31\\src\\EntireGameOnOneScreen\\resources\\textures\\healthkitspritesheet.png"))
 
			System.out.println("Texture loaded: "+texture);
			System.out.println(">> Image width: "+texture.getImageWidth());
			System.out.println(">> Image height: "+texture.getImageHeight());
			System.out.println(">> Texture width: "+texture.getTextureWidth());
			System.out.println(">> Texture height: "+texture.getTextureHeight());
			System.out.println(">> Texture ID: "+texture.getTextureID());
		} catch {
			case e: IOException => e.printStackTrace();
		}
	}
 
	def render {
		Color.white.bind();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.getTextureID());
		val scale = .4f
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(100,100);
			GL11.glTexCoord2f(scale, 0);
			GL11.glVertex2f(100+texture.getTextureWidth() * scale,100);
			GL11.glTexCoord2f(scale,1);
			GL11.glVertex2f(100+texture.getTextureWidth() * scale,100+texture.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(100,100+texture.getTextureHeight());
		GL11.glEnd();
	}
}