package com.sergii.shutyi;

import java.util.ArrayList;

/**
 * Created by S.Shutyi on 19.07.2017.
 */
public class Model {

    private int number;
    private int floor = 0;
    private int ceil = 100;
    private int lastTry;
    private ArrayList<Integer> triesList = new ArrayList<Integer>();

    /**
     * Assigns random positive value to this.number.
     */
    public void pickNumber(){
        number = rand(floor, ceil);
    }

    /**
     * Returns a {@code int} pseudorandom value from a range included max and min.
     *
     * @param min minimum number of the range
     * @param max maximum number of the range
     * @return the random number from range
     * @throws IllegalArgumentException {@inheritDoc}
     */
    private static int rand(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    /**
     * Returns a {@code int} pseudorandom value from {@code 0} to {@code 32767}.
     *
     * @return the random number from range
     * @throws IllegalArgumentException {@inheritDoc}
     */
    private static int rand() {
        int min = 0;
        int max = Short.MAX_VALUE;

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    /**
     * Returns <tt>true</tt> if this.lastTry equals this.number.
     *
     * @return <tt>true</tt> if this.lastTry equals this.number
     */
    public boolean isLastTryEqualNumber() {
        return lastTry == number;
    }

    /**
     * Returns <tt>true</tt> if this.lastTry greater than this.number.
     *
     * @return <tt>true</tt> if this.lastTry greater than this.number
     */
    public boolean isLastTryGreaterThanNumber() {
        if (lastTry > number){
            return true;
        } else {
            return false;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
