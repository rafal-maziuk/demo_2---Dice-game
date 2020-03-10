package diceGame;

import java.util.Random;

public class Player {

    private String name;
    private String guess;  // wartość podana przez gracza
    private int points;

    public Player(String playerName) {

        name = playerName;
        guess = "";
        points = 0;
    }

    public void makeGuess() {   // typowanie wyniku

        Random random = new Random();

        int guessNumber = random.nextInt(2);

        if (guessNumber % 2 == 0)
            guess = "Even number (parzyste)";
        else
            guess = "Odd number (nieparzyste)";
    }

    public void addPoints(int newPoints) {  // dodawanie punktów do aktualnej punktacji

        points += newPoints;
    }

    public String getName(){

        return name;
    }

    public String getGuess() {

        return guess;
    }

    public int getPoints(){

        return points;
    }
}
