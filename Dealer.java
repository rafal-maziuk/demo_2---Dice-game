package diceGame;

public class Dealer {

    private int dice1Value;
    private int dice2Value;

    public Dealer() {
        dice1Value = 0;
        dice2Value = 0;
    }

    public void rollDice() {

        final int SIDES = 6;

        Dice dice1 = new Dice(SIDES);
        Dice dice2 = new Dice(SIDES);

        dice1Value = dice1.getValue();
        dice2Value = dice2.getValue();
    }

    public String getEvenOrOddNumbers() {

        String result;  // przechowywanie wyniku

        int sum = dice1Value + dice2Value;

        if (sum % 2 == 0)
            result = "Even number (parzyste)";
        else
            result = "Odd number (nieparzyste)";

        return result;
    }

    public int getDice1Value() {

        return dice1Value;
    }

    public int getDice2Value() {

        return dice2Value;
    }
}
