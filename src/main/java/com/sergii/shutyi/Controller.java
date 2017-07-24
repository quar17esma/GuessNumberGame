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
        model.pickSecretNumber();

        Scanner sc = new Scanner(System.in);

        while (!model.checkTry(inputIntValue(sc))) {
            view.printWrongTry(model);
        }

        view.printResult(model);
    }

    /**
     * Gets data from user.
     * Method shows invitation for user to input data and check it.
     * Returns entered number if input is correct, or propose another try if not.
     *
     * @return entered (@code int) value in range of numbers to guess
     */
    private int inputIntValue(Scanner sc) {
        view.printInvitation(model);

        while (true) {
            if (!sc.hasNextInt()) {
                view.printIncorrectInput(model);
                sc.next();
            } else {
                int inputtedInt = sc.nextInt();
                if (model.isValueInRange(inputtedInt)) {
                    return inputtedInt;
                }
                view.printIncorrectInput(model);
            }
        }
    }
}
