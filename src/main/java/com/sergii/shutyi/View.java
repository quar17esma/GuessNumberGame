package com.sergii.shutyi;

/**
 * Created by S.Shutyi on 19.07.2017.
 */
public class View {
    // Text's constants
    public static final String GUESS_NUMBER_IN_RANGE = "Please, try too guess number in range: ";
    public static final String WRONG_GUESS = "Wrong try. ";
    public static final String RIGHT_GUESS = "Congratulations! You guessed the number.";
    public static final String YOUR_ATTEMPTS = "Your attempts: ";
    public static final String WRONG_INPUT = "Incorrect input! ";
    public static final String HYPHEN = " - ";

    /**
     * Prints message to commandline
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

}
