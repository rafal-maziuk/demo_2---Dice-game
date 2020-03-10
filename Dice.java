package diceGame;

import java.util.Random;

public class Dice {

    private int sides; // liczba ścianek na kostce
    private int value; // uzyskana wartość

    public Dice(int numSides) {
        sides = numSides;
        roll();
    }

    public void roll() {  // symulacja rzutu kostką

        Random random = new Random();

        value = random.nextInt(sides) + 1;
    }

    public int getSides() {
        return sides;
    }

    public int getValue() {
        return value;
    }
}