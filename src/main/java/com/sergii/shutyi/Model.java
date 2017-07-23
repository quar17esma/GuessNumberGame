package com.sergii.shutyi;

import java.util.ArrayList;

/**
 * Created by S.Shutyi on 19.07.2017.
 */
public class Model {

    private int secretNumber;
    private int floor = InitialConstants.INITIAL_BARRIER_FLOOR;
    private int ceil = InitialConstants.INITIAL_BARRIER_CEIL;
    private int lastTry;
    private ArrayList<Integer> triesList = new ArrayList<Integer>();

    /**
     * Assigns random positive value to this.secretNumber.
     */
    public void pickSecretNumber() {
        secretNumber = rand(floor, ceil);
    }

    /**
     * Returns a {@code int} pseudorandom value from a range included max and min.
     * @param min minimum number of the range
     * @param max maximum number of the range
     * @return the random number from range
     * @throws IllegalArgumentException {@inheritDoc} if min is greater or equals max
     */
    public static int rand(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        if ((max - min - 1) < (InitialConstants.MINIMUM_NUMBERS_IN_RANGE)){
            throw  new IllegalArgumentException("between initial barriers must be at least " +
                    + InitialConstants.MINIMUM_NUMBERS_IN_RANGE + " number(s)");
        }

        return (int) (Math.random() * ((max - min)-1)) + min + 1;
    }

    /**
     * Returns a {@code int} pseudorandom value from {@code 0} to {@code 32767}.
     * @return the random secretNumber from range
     */
    private static int rand() {
        int min = 0;
        int max = Short.MAX_VALUE;

        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    /**
     * Adds inputted value to triesList and check that it equals secretNumber, otherwise changes range.
     * @param value number inputted by user
     * @return true if value equals secretNumber
     */
    public boolean checkTry(int value) {
        lastTry = value;
        triesList.add(lastTry);

        if (lastTry == secretNumber) {
            return true;
        } else {
            changeRange();
            return false;
        }
    }

    /**
     * Changes range of numbers where secretNumber lies.
     * Divides range on number of last try and leave the part that consists secretNumber.
     */
    private void changeRange() {
        if (lastTry != secretNumber) {
            if (lastTry > secretNumber) {
                setCeil(lastTry - 1);
            } else {
                setFloor(lastTry + 1);
            }
        }
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCeil() {
        return ceil;
    }

    public void setCeil(int ceil) {
        this.ceil = ceil;
    }

    public int getLastTry() {
        return lastTry;
    }

    public void setLastTry(int lastTry) {
        this.lastTry = lastTry;
    }

    public ArrayList<Integer> getTriesList() {
        return triesList;
    }

    public void setTriesList(ArrayList<Integer> triesList) {
        this.triesList = triesList;
    }

}
