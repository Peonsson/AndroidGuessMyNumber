package se.kth.anderslm.guessmynumber;

import java.util.Random;

public class GuessMyNumberModel {

    public GuessMyNumberModel(int MAX) {
        this.MAX = MAX;
        this.initGame();
    }

    public void initGame() {
        this.number = rand.nextInt(MAX) + 1; // 0..MAX
        this.noOfGuesses = 0;
        this.guess = -1;
    }

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public int getGuess() {
        return guess;
    }

    public int getMAX() {
        return MAX;
    }

    public int getNumber() {
        return number;
    }

    public void setGuess(int guess) {
        this.guess = guess;
        this.noOfGuesses++;
    }

    /**
     * This method returns <0 if guess is to low,
     * 0 if correct and >0 if to high.
     */
    public int compareGuessToNumber() {
        return (guess - number);
    }

    public String compareGuessToNumberToString() {
        if(this.compareGuessToNumber() < 0) return "to low";
        if(this.compareGuessToNumber() == 0) return "correct";
        return "to high";
    }

    private int number, noOfGuesses, guess;
    private final int MAX;
    private static Random rand = new Random();
}

