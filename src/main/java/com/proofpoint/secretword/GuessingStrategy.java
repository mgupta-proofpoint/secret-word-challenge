package com.proofpoint.secretword;

/**
 * A strategy for generating guesses given the current state of a SecretWord game.
 * Your solution will extend/implement this base signature (specifically the nextGuess method).
 */
public abstract class GuessingStrategy {
  protected int secretWordLength = 0;

  public GuessingStrategy(SecretWordGame game) {
    this.secretWordLength = game.getSecretWordLength();
  }

  abstract public Guess nextGuess(SecretWordGame game);
}
