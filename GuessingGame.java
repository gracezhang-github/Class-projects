// This program allows the user to play a game in
// which the program thinks of a random integer
// and accepts guesses from the user until the user
// guesses the number correct.

import java.util.*;
public class GuessingGame {
    public static final int MAX_VALUE = 100;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        int guessNum = 0;
        int totalguessNum = 0;
        int games = 1;
        int fewestGuess = 1000000;

        intro();

        boolean gameNotOver = true;
        while (gameNotOver) {
            guessNum = playGame(console, rand);
            totalguessNum += guessNum;

            if (guessNum < fewestGuess) {
                fewestGuess = games;
                fewestGuess = guessNum; 
            }

            System.out.print("Do you want to play again? ");
            String pick = console.next();
            char first = pick.toLowerCase().charAt(0);
            
            if (first == 'y') {
                gameNotOver = true;
                games++;
            } else {
                gameNotOver = false;
            }
        }
        overallResult(totalguessNum, games, fewestGuess);
    }

    // prints out the introduction to the game in the form of a haiku
    public static void intro() {
        System.out.println("Hey! Guess a number!");
        System.out.println("There're no guess amount limits");
        System.out.println("GOOD LUCK! best wishes, John Green");
    }

    // This method allow the user to play a singular game
    // This method also returns the guesses each user had per game
    // Parameters:
    //    <Scanner console> - this parameter obtains the input from the user within the method
    //    <Random rand> - this parameter generates a set of random numbers within the method
    // Return values:
    //    <guessPerGame> - returns the total guesses user had per game
    public static int playGame(Scanner console, Random rand) {
        boolean gameNotOver = true;
        System.out.println();
        System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
        int number = rand.nextInt(MAX_VALUE) + 1;
        int guessPerGame = 0;

        while (gameNotOver) {
            System.out.print("Your guess? ");
            int guess = console.nextInt();
            guessPerGame++;

            if (guess > number) {
                System.out.println("It's lower.");
            } else if (guess < number) {
                System.out.println("It's higher.");
            } else {
                gameNotOver = false;
            }
        }

        String guessFormat = "";
        if (guessPerGame == 1) {
            guessFormat = "guess!";
        } else {
            guessFormat = "guesses!";
        }
        
        System.out.println("You got it right in " + guessPerGame + " " + guessFormat);
        return guessPerGame;
    }

    // This method prints out the overall results and stats of the game an user has played
    // Parameters:
    //    <int totalguessNum> - passes through the totalguessNum value from the main method
    //    <int games> - passes through the games value from the main method
    //    <int fewestGuess> - passes through the fewestGuess from the main method
    public static void overallResult(int totalguessNum, int games, int fewestGuess) {
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("Total games   = " + games);
        System.out.println("Total guesses = " + totalguessNum);
        double percent = (double) totalguessNum / games;
        System.out.println("Guesses/game  = " + round2(percent));
        System.out.println("Best game     = " + fewestGuess);

    }

    // Rounds a given number "number" to one decimal place
    // Parameter:
    //    <double number> - passes the number value from the playGame method
    // Return values:
    //    <Math.round> - returns the value of the "number" rounded to a one digit decimal
    public static double round2(double number) {
        return Math.round(number * 10.0) / 10.0;
    }
}
