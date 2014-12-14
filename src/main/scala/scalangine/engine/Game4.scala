package scalangine.engine

import org.newdawn.slick.BasicGame
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.AppGameContainer

object Game4 extends BasicGame("Title Damn") {
  
	def main(args: Array[String]) {
		val agc: AppGameContainer = new AppGameContainer(this);
	    agc.setDisplayMode(400,400,false);
	    agc.start();
	}
	
  
	override def init(gc: GameContainer): Unit = {
	  
	}
	
	override def render(gc: GameContainer, g: Graphics): Unit = {
	  
	}
	
	override def update(gc: GameContainer, delta: Int): Unit = {
	  
	}
}