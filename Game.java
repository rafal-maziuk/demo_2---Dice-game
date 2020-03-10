package diceGame;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        final int MAX_ROUNDS = 5;   // liczba rund
        String player1Name;
        String player2Name;

        Scanner keyboard = new Scanner(System.in);

        // pobieranie imion graczy
        System.out.println("Give name of first player : ");
        player1Name = keyboard.nextLine();
        System.out.println("Give name of second player : ");
        player2Name = keyboard.nextLine();


        Dealer dealer = new Dealer();   // obiekt diler/krupier

        // tworzenei graczy
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        for (int round = 0; round < MAX_ROUNDS; round++) {
            System.out.println("========");
            System.out.printf("Round number %d.\n", round + 1);

            dealer.rollDice();  // rzut kostkami

            // typowanie wyników
            player1.makeGuess();
            player2.makeGuess();

            // określanie zwycięzcy rundy
            roundResults(dealer, player1, player2);
        }

        //zwyciezca gry
        displayWinner(player1, player2);
    }

    public static void roundResults(Dealer dealer, Player player1, Player player2) {

        //wartości rzutów
        System.out.printf("Dealer threw ou %d i %d.\n", dealer.getDice1Value(), dealer.getDice2Value());
        System.out.printf("Score is: %s\n", dealer.getEvenOrOddNumbers());

        // sprawdzanie typów graczy i przyznawanie punktów
        checkGuess(player1, dealer);
        checkGuess(player2, dealer);
    }

    public static void checkGuess(Player player, Dealer dealer) {

        final int ADD_POINTS = 1;   //punkty za dobre trafienie
        String guess = player.getGuess();   //typ gracza
        String evenOrOddResult = dealer.getEvenOrOddNumbers();  //parzyste lub nie

        //typowanie gracza
        System.out.printf("Player %s, you have selected %s.\n", player.getName(), player.getGuess());

        //przyznawanie punktów
        if (guess.equalsIgnoreCase(evenOrOddResult)) {
            player.addPoints(ADD_POINTS);
            System.out.printf("Good job! Player %s, you have %d more point.\n", player.getName(), ADD_POINTS);
        }
    }

    public static void displayWinner(Player player1, Player player2) {

        System.out.println("======");
        System.out.println("End of game. Results:");
        System.out.printf("Player %s, sum of points: %d.\n", player1.getName(), player1.getPoints());
        System.out.printf("Player %s, sum of points: %d.\n", player2.getName(), player2.getPoints());

        if (player1.getPoints() > player2.getPoints())
            System.out.println(player1.getName() + " is winner of the game!");
        else if (player2.getPoints() > player1.getPoints())
            System.out.println(player2.getName() + " is winner of the game!");
        else
            System.out.println("Draw!");

    }
}
