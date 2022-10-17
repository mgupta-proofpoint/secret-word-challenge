package com.proofpoint.secretword.runner

import com.proofpoint.secretword.strategy.NaiveStrategy
import com.proofpoint.secretword.{SecretWordGame => Game}

/**
 * Example main method that selects a word at random from a file full of words and plays until the game is won or the
 * maximum number of incorrect guesses is reached (and the game is lost). Use this to quickly test your solution on a
 * more diverse set of words than the examples defined in the unit test suite.
 */
object SecretWordRunner {
  def main(args:Array[String]): Unit = {
    val maxGuesses = 5

    val wordLines = io.Source.fromInputStream(getClass().getResourceAsStream("/words.txt")).getLines()
    val allWords = wordLines.toList

    // Find a random word to play the game
    val randomWord = scala.util.Random.shuffle(allWords).take(1)(0)
    val game = new Game(randomWord, maxGuesses)

    // Initialize strategy
    val strategy = new NaiveStrategy(game) // Replace with your implementation

    while(game.gameStatus().equals(Game.Status.KEEP_GUESSING)) {
      strategy.nextGuess(game).makeGuess(game)
      println(game)
    }
  }
}
