// This programs is able to interpet a YazLang file, and 
// view the interpreted files if they enter the correct
// input file names.

import java.util.*;
import java.io.*;

public class YazInterpreter {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        intro();
        String choice = "";
    
        while (!choice.equalsIgnoreCase("Q")) {
            System.out.print("(I)nterpret YazLang program, (V)iew output, (Q)uit? ");
            choice = console.nextLine();

            if (choice.equalsIgnoreCase("I")) {
                interpretProgram(console);
                
            } else if (choice.equalsIgnoreCase("V")) {
                viewProgram(console);
            }
        }
    }

    // Allows for the reprompt of entering the input file name to scan
    // Parameters:
    //    <Scanner console> - this parameter obtains the input from the user within the method
    // Return values:
    //    <f> - returns the file that was scanned
    public static File prompt(Scanner console) throws FileNotFoundException {
        System.out.print("Input file name: ");
        String userFile = console.nextLine();
        File f = new File(userFile);
        while (!f.exists()) {
            System.out.print("File not found. Try again: ");
            userFile = console.nextLine();
            f = new File(userFile);
        }
        return f;
    }

    // Prints out the introduction to the YazLang program
    public static void intro() {
        System.out.println("Welcome to YazInterpreter!");
        System.out.println("You may interpret a YazLang program and output");
        System.out.println("the results to a file or view a previously");
        System.out.println("interpreted YazLang program.");
        System.out.println();
    }

    // Reads the file the user entered and interpret the file based on commands given
    // Parameters:
    //    <Scanner console> - this parameter obtains the input from the user within the method
    public static void interpretProgram(Scanner console) throws FileNotFoundException {

        File file = prompt(console);
        System.out.print("Output file name: ");
        String userOutput = console.nextLine();
        System.out.println("YazLang interpreted and output to a file!");
        System.out.println();
        
        PrintStream output = new PrintStream(new File(userOutput));
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            String word = lineScan.next();
            if (word.equals("CONVERT")) {
                convert(lineScan, output);
            } else if (word.equals("RANGE")) {
                range(lineScan, output);
            } else if (word.equals("REPEAT")) {
                repeat(lineScan, output);
            }  
        }
    }

    // Allow the user to enter an input file and view the interpreted YazLang program
    // Parameters:
    //    <Scanner console> - this parameter obtains the input from the user within the method
    public static void viewProgram(Scanner console) throws FileNotFoundException {

        File file = prompt(console);
        System.out.println();
        Scanner process = new Scanner(file);
        while (process.hasNextLine()) {
            String processLine = process.nextLine();
            Scanner processScan = new Scanner(processLine);
            System.out.println(processLine);
        }
        System.out.println();
    }
    
    // Allow the program to convert temperatures from
    // Fahrenheit to Celsius or vice versa
    // Parameters:
    //    <Scanner lineScan> - processes and reads the information on "lineScan" line
    //    <PrintStream output> - prints the interpreted program into another file
    public static void convert(Scanner lineScan, PrintStream output) {
        double temp = lineScan.nextDouble();
        String degree = lineScan.next();
        // if the argument 2 is C, then multiply by 1.8 and add 32
        if (degree.equalsIgnoreCase("C")) {
            temp =  temp * 1.8 + 32;
            degree = degree.replace("C", "F");
            degree = degree.replace("c", "f");
        // if the argument 3 is F, then subtract by 32 and divide by 1.8
        } else if (degree.equalsIgnoreCase("F")) {
            temp = (temp - 32) / 1.8;
            degree = degree.replace("F", "C");
            degree = degree.replace("f", "c");
        }
        output.println((int)temp + degree);
    } 
    
    // Allow the program to print a sequence of integers starting from arg1
    // and increments by the amount of arg3 until it reaches a value equal/greater than arg2
    // Fahrenheit to Celsius or vice versa
    // Parameters:
    //    <Scanner lineScan> - processes and reads the information on "lineScan" line
    //    <PrintStream output> - prints the interpreted program into another file
    public static void range(Scanner lineScan, PrintStream output) {
        int firstInt = lineScan.nextInt();
        int secondInt = lineScan.nextInt();
        int thirdInt = lineScan.nextInt();
        for (int i = firstInt; i < secondInt; i = i + thirdInt) {
            output.print(i + " ");
        }
        output.println();
    }

    // Allow the program to print out each string argument repeated
    // amounts of time indicated by the following integer argument
    // Parameters:
    //    <Scanner lineScan> - processes and reads the information on "lineScan" line
    //    <PrintStream output> - prints the interpreted program into another file
    public static void repeat(Scanner lineScan, PrintStream output) {
        // repeat the numbers by how many integer num of times
        while (lineScan.hasNext()) {
            String letter = lineScan.next();
            letter = letter.replace("_", " ");
            letter = letter.substring(1, letter.length() - 1);
            int repeatNum = lineScan.nextInt();
            for (int i = 0; i < repeatNum; i++) {
                output.print(letter);
            } 
        }
        output.println(); 
    }
}
