package com.proofpoint.secretword;

/**
 * A Guess that represents guessing a letter for the current SecretWord game
 */
public class GuessLetter implements Guess {
  private final char guess;

  public GuessLetter(char guess) {
    this.guess = guess;
  }

  @Override
  public void makeGuess(SecretWordGame game) {
    game.guessLetter(guess);
  }

  @Override
  public String toString() {
    return "GuessLetter[" + guess + "]";
  }
}
