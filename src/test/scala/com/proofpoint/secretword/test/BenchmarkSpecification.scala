package com.proofpoint.secretword.test

import org.specs2.specification.core.Fragment

import com.proofpoint.secretword.SecretWordGame
import com.proofpoint.secretword.strategy.NaiveStrategy

trait SecretWordTest {
  def runGame(word:String) : Int = {
    val game = new SecretWordGame(word, 5) // Use default max guesses of 5
    val strategy = new NaiveStrategy(game) // Replace with your solution's strategy

    while(game.gameStatus().equals(SecretWordGame.Status.KEEP_GUESSING)) {
      strategy.nextGuess(game).makeGuess(game)
    }

    game.currentScore()
  }
}

class ReferenceSpecification extends org.specs2.mutable.Specification with SecretWordTest {
  val expectations = List(
    ("COMAKER", 25),
    ("CUMULATE", 9),
    ("ERUPTIVE", 5),
    ("MONADISM", 8),
    ("MUS", 25),
    ("NAGGING", 7),
    ("OSES", 5),
    ("REMEMBERED", 5),
    ("SPODUMENES", 4),
    ("STEREOISOMERS", 2),
    ("TOXICS", 11),
    ("TRICHROMATS", 5),
    ("TRIOSE", 5),
    ("UNIFORMED", 5)
  )

  "README.md examples should perform well" >> {
    Fragment.foreach(expectations) { case (word, expectedScore) =>
      word ! { runGame(word) must beLessThanOrEqualTo(expectedScore) }
    }
  }
}

// Un-comment this block to test your solution with a larger amount of random words
/*class BenchmarkSpecification extends org.specs2.mutable.Specification with SecretWordTest {
  val wordLines = io.Source.fromInputStream(getClass().getResourceAsStream("/words.txt")).getLines
  val allWords = wordLines.toList

  // Find random words to play the game
  val randomWords = scala.util.Random.shuffle(allWords).take(100) // Change from 100 to take more or less words

  "A random selection of words should perform well in aggregate" >> {
    Fragment.foreach(randomWords) { word =>
      // Change the +2 allowance to make the game easier or more difficult
      word ! { runGame(word) must beLessThanOrEqualTo(word.length + 2) }
    }
  }
}*/
