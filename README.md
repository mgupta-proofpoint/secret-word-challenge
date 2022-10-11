# Secret Word Challenge

## The Goal
Write a program that plays "Secret Word" (unfortunately more commonly referred to as "hangman"). A description of the game can be found on Wikipedia: http://en.wikipedia.org/wiki/Hangman_(game).

## The Problem
Your goal is to use a provided API to play Secret Word efficiently. You will need to guess a word with as few guesses as possible, and make no more than maxWrongGuesses incorrect guesses. Your contribution will be writing the letter/word guessing strategy.

We would like you to use the provided Java APIs and to write your solution in Scala or another JVM-based language (Java, Kotlin, Groovy, etc.). Please provide build instructions if they are not straightforward.

Your score for a word will be:

   **number of letter guesses + number of incorrect word guesses** _if you guessed the word correctly before exceeding maxWrongGuesses incorrect guesses_
OR
   **25** _if you lost the game before guessing the word correctly_

You will need to write an implementation of the GuessingStrategy class, and some code to use your GuessingStrategy on a SecretWordGame instance. An example runner for one word at a time can be found at com.proofpoint.secretword.runner.SecretWordRunner. There is also a set of parameterized tests than can be executed using the ```sbt test``` command.

The pseudocode to run your strategy for a SecretWordGame is:

```java
// runs your strategy for the given game, then returns the score
public int run(SecretWordGame game, GuessingStrategy strategy) {
  while (game has not been won or lost) {
    ask the strategy for the next guess
    apply the next guess to the game
  }

  return game.score();
}
```

A trivial strategy might be to guess 'A', then 'B', then 'C', etc. until you've guessed every letter in the word or you've lost. (This will work great for words like "cab"; not so much for others.)

Every word you encounter will be a word from the words.txt file.

## Example

For example, let's say the word is APPLE.

Here is what a series of calls might look like:

```java
SecretWordGame game = new SecretWordGame("apple", 4); // secret word is apple, 4 wrong guesses are allowed
System.out.println(game);

new GuessLetter('a').makeGuess(game);
System.out.println(game);

new GuessWord("acorn").makeGuess(game);
System.out.println(game);

new GuessLetter('n').makeGuess(game);
System.out.println(game);

new GuessLetter('l').makeGuess(game);
System.out.println(game);

new GuessLetter('p').makeGuess(game);
System.out.println(game);

new GuessWord("apple").makeGuess(game);
System.out.println(game);
```

The output would be:

```
-----; score=0; status=KEEP_GUESSING
A----; score=1; status=KEEP_GUESSING
A----; score=2; status=KEEP_GUESSING
A----; score=3; status=KEEP_GUESSING
A--L-; score=4; status=KEEP_GUESSING
APPL-; score=5; status=KEEP_GUESSING
APPLE; score=5; status=GAME_WON
```

game.score() will be 5 in this case since there were 4 letter guesses and 1 incorrect word guess made.

## Sample Data
As a baseline, here are scores for a reasonably good guessing strategy against a set of 14 random words. Your strategy will likely be better for some of the words and worse for other words, but the average score/word should be in the same ballpark.

```
COMAKER = 25 (was not able to guess the word before making more than 5 mistakes)
CUMULATE = 9
ERUPTIVE = 5
MONADISM = 8
MUS = 25 (was not able to guess the word before making more than 5 mistakes)
NAGGING = 7
OSES = 5
REMEMBERED = 5
SPODUMENES = 4
STEREOISOMERS = 2
TOXICS = 11
TRICHROMATS = 5
TRIOSE = 5
UNIFORMED = 5
```


## Resources

You should have been provided an archive file containing source code and a dictionary file to get you started. If any materials appear to be missing, or if you have any questions, please contact us right away.

The resources contain a dictionary file called words.txt. You can assume all words that your program will be tested with come from this dictionary file.


## Judging

Your solution will be graded on the following criteria

* Code quality, readability, and design. In terms of quality, please write your code as if it would eventually be pushed into production.
* Performance (speed/memory footprint). We are more concerned with average time per game, so expensive one-time initialization is okay (as long as it's not too egregious)
* Total score for ~1000 random words, compared to the total score of reference implementations for the same ~1000 words (max wrong guesses is typically set to 5)

## Submitting Your Solution

When you are ready to submit your solution, please respond to our recruiting team with an archive file containing your solution's source code.

Please note that Proofpoint's email gateways are very sensitive to compiled code, and will likely reject any emails that contain .class, .jar, and related files.
