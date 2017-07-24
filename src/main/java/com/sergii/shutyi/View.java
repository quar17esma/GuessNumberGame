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
    public static final String BARRIERS_NOT_INCLUDED = "Barriers not included.";
    public static final String HYPHEN = " - ";
    public static final String DOT = ".";
    public static final String SPACE = " ";

    /**
     * Prints invitation and current range of numbers
     */
    public void printInvitation(Model model){
        printMessage(GUESS_NUMBER_IN_RANGE + model.getFloor() + HYPHEN + model.getCeil()
                + DOT + SPACE + BARRIERS_NOT_INCLUDED);
    }

    /**
     * Prints error and new invitation
     */
    public void printIncorrectInput(Model model){
        printMessage(WRONG_INPUT);
        printInvitation(model);
    }

    /**
     * Prints message that user did not guess and his attempts
     */
    public void printWrongTry(Model model){
        printMessage(WRONG_GUESS);
        printMessage(YOUR_ATTEMPTS + model.getTriesList().toString());
    }

    /**
     * Prints congratulation and user's statistics
     */
    public void printResult(Model model){
        printMessage(RIGHT_GUESS);
        printMessage(YOUR_ATTEMPTS + model.getTriesList().toString());
    }

    /**
     * Prints message to commandline
     * @param message message to print
     */
    private void printMessage(String message){
        System.out.println(message);
    }
}
