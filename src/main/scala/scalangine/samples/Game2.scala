package scalangine.samples

import org.lwjgl.opengl.Display
import org.lwjgl.LWJGLException
import org.lwjgl.opengl.DisplayMode
import org.lwjgl.opengl.GL11
import java.io.IOException
import org.newdawn.slick.opengl.Texture
import org.newdawn.slick.opengl.TextureLoader
import org.newdawn.slick.util.ResourceLoader

object Game2 {
	var texture: Texture = null

	def main(args: Array[String]) {
		start
	}
	
	def start {
		initGL(800,600)
		init
		println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION))
 
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
 
		
 
		GL11.glClearColor(1f, 1f, 1f, 1f)          
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
 
	def init {
 
		try {
			//texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("/home/justin/Pictures/spritesheets/Whiskey-barrel.png"))
			texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("/home/justin/Pictures/spritesheets/brickwork.png"))
			//texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("/home/justin/Pictures/spritesheets/brickwork.png")))
 
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
		//GL11.glBindTexture(GL11.GL_TEXTURE_2D, texture.getTextureID())
		texture.bind()
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(100, 100);
			GL11.glTexCoord2f(1f, 0);
			GL11.glVertex2f(100 + texture.getImageWidth() * 3,100);
			GL11.glTexCoord2f(1f, 1f);
			GL11.glVertex2f(100 + texture.getImageWidth() * 3,100 + texture.getImageHeight() * 3);
			GL11.glTexCoord2f(0, 1f);
			GL11.glVertex2f(100, 100 + texture.getImageHeight() * 3);
		GL11.glEnd();
	}
}