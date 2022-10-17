package com.proofpoint.secretword.strategy;

import com.proofpoint.secretword.Guess;
import com.proofpoint.secretword.GuessLetter;
import com.proofpoint.secretword.GuessingStrategy;
import com.proofpoint.secretword.SecretWordGame;

/**
 * Naive guessing strategy that is a terrible problem solution, but serves as a reference
 */
public class NaiveStrategy extends GuessingStrategy {
  protected char nextGuessChar = 'a';

  public NaiveStrategy(SecretWordGame game) {
    super(game);
  }

  @Override
  public Guess nextGuess(SecretWordGame game) {
    return new GuessLetter(nextGuessChar++); // Guesses a, then b, then c, then ...
  }
}
