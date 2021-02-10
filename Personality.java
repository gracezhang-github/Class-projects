import java.util.*;
import java.io.*;

public class Personality {
    public static final int NUM_DIMENSIONS = 4; 
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        intro();

        System.out.print("input file name? ");
        String userInput = console.nextLine();
        Scanner input = new Scanner(new File(userInput));
        System.out.print("output file name? ");
        String userOutput = console.next();
        PrintStream output = new PrintStream(new File(userOutput));

        while(input.hasNextLine()) {
            String name = input.nextLine();
            String choice = input.nextLine();
            int[] countA = new int[NUM_DIMENSIONS];
            int[] countB = new int[NUM_DIMENSIONS];
            computeCount(countA, countB, choice);
            int[] percentages = percentage(countA, countB);
            output.println(name + ": " + Arrays.toString(percentages) + " = " 
                                    + personality(percentages));
        }
    }

    // Prints out the introduction to the Personality Test program
    public static void intro() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    // Computes the amount of counts for both A and B 
    // Parameters:
    //    <String choice> - this parameter takes in the answers to each question
    //    <int[] countA> - passes in the array that stores the amount of A counts
    //    <int[] countB> - passes in the array that stores the amount of B counts
    public static void computeCount(int[] countA, int[] countB, String choice) {
        for (int i = 0; i < choice.length(); i++) {
            char pick = choice.charAt(i);

            if (pick == 'A' || pick == 'a') {
                countA[(i % 7 + 1) / 2]++;
            } else if (pick == 'B' || pick == 'b') {
                countB[(i % 7 + 1) / 2]++;
            } 
        }
    }
    
    // Computes the percentage of responses that were "B"
    // Parameters:
    //    <int[] countA> - passes in the array that stores the amount of A counts
    //    <int[] countB> - passes in the array that stores the amount of B counts
    // Return values:
    //    <percent> - returns the total percentage of B for each dimension 
    public static int[] percentage(int[] countA, int[] countB) {
        int[] percent = new int[NUM_DIMENSIONS];
        for (int i = 0; i < NUM_DIMENSIONS; i++) {
            double perc = (countB[i] * 100.0) / (countA[i] + countB[i]);
            percent[i] = (int) Math.round(perc);
        }
        return percent;
    }

    // Converts each percentage into a personality type
    // Parameters:
    //    <int[] choice> - this parameter passes in the array that 
    //                     stores the choice/answer user picked
    // Return values:
    //    <dimension> - returns the dimension/personality type of each individual
    public static String personality(int[] choice) {
        String dimension = "";

        String[] pickA = {"E", "S", "T", "J"};

        String[] pickB = {"I", "N", "F", "P"};

        String equal = "X";

        for (int i = 0; i < NUM_DIMENSIONS; i++) {
            if (choice[i] < 50) {
                dimension += pickA[i];
            } else if (choice[i] > 50) {
                dimension += pickB[i];
            } else {
                dimension += equal;
            }
        }
        return dimension;
    }
}
