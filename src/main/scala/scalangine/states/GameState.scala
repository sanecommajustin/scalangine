package scalangine.states

import scalangine.engine.GameRunner

abstract class GameState(val id: Int) {
	def init(gameRunner: GameRunner)
	def update(gameRunner: GameRunner, delta: Long)
	def draw(gameRunner: GameRunner)
	def exitGameState() = {}
	def enterGameState() = {}
}