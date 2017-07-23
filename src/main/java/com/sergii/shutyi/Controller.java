package com.sergii.shutyi;

import java.util.Scanner;

/**
 * Created by S.Shutyi on 19.07.2017.
 */
public class Controller {

    Model model;
    View view;

    // Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Processes user's actions.
     * Request model to pick a number to guess.
     * Checks and processes user's try if input is correct, and ask for another try if not.
     * Compare user's try with guessing number.
     * If try is right, request view to show result,
     * or changes the range and propose another try with showing previous attempts.
     */
    public void processUser() {
        model.pickNumber();

        Scanner sc = new Scanner(System.in);

        while (!model.isLastTryEqualNumber()) {
            model.setLastTry(inputIntValue(sc));
            model.getTriesList().add(model.getLastTry());

            if (!model.isLastTryEqualNumber()){
                view.printMessage(View.WRONG_GUESS);
                view.printMessage(view.YOUR_ATTEMPTS + model.getTriesList().toString());
                changeRange();
            }
        }

        showResult();
    }

    /**
     * Gets data from user.
     * Method shows invitation for user to input data and check it.
     * Returns entered number if input is correct, or propose another try if not.
     * @return entered (@code int) value in range of numbers to guess
     */
    private int inputIntValue(Scanner sc) {
        showInvitation();

        while (true) {
            if (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT);
                showInvitation();
                sc.next();
            } else {
                int inputtedInt = sc.nextInt();
                if (inputtedInt >= model.getFloor() && inputtedInt <= model.getCeil()) {
                    return inputtedInt;
                }
                view.printMessage(view.WRONG_INPUT);
                showInvitation();
            }
        }
    }

    /**
     * Requests view to print invitation and current range of numbers
     */
    private void showInvitation(){
        view.printMessage(view.GUESS_NUMBER_IN_RANGE + model.getFloor() + view.HYPHEN + model.getCeil());
    }

    /**
     * Changes range of numbers to guess.
     * Divides range on number of last try and leave the part that consists number.
     */
    private void changeRange() {
        if (!model.isLastTryEqualNumber()) {
            if (model.isLastTryGreaterThanNumber()) {
                model.setCeil(model.getLastTry()-1);
            } else {
                model.setFloor(model.getLastTry()+1);
            }
        }
    }

    /**
     * Requests view to print congratulation and user's statistics
     */
    private void showResult() {
        view.printMessage(view.RIGHT_GUESS);
        view.printMessage(view.YOUR_ATTEMPTS + model.getTriesList().toString());
    }
}
