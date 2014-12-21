package scalangine.engine

import org.lwjgl.opengl.GL11

trait ScreenCleaner {
	def clean = {
	  GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
      GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f)
	}
}