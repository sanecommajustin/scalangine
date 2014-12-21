package scalangine.samples

import org.newdawn.slick.GameContainer
import org.newdawn.slick.AppGameContainer
import org.newdawn.slick.state.StateBasedGame

object Game4 extends StateBasedGame("Title Damn") {
  
	def main(args: Array[String]) {
		val agc: AppGameContainer = new AppGameContainer(this)
	    agc.setDisplayMode(400,400,false)
	    agc.setShowFPS(true)
	    agc.start()
	}
	
  
	override def initStatesList(gc: GameContainer): Unit = {
	  //addState(new FirstState(0))
	}
}