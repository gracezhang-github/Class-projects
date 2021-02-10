// 10/25/2020
// CSE142
// Take-home Assessment #4
// 
// This program will create budgeter method where it prompts 
// a person for income and expense amounts, then calculates their
// net monthly income.

import java.util.*;

public class Budgeter {
    public static final int DAYS_IN_MONTH = 31;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        title();
        double totalIncome = incomeCategory(console, "income");
        double totalExpense = expenseCategory(console, "expense");
        results(totalIncome, totalExpense);

    }

    // Prints the Title/Introduction to the program
    public static void title() {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }
    
    // Computes the total income the user earned
    // Parameters:
    //    <Scanner console> - this parameter obtains the input from the user within the method
    //    <String category> - this parameter allows for computation of both income and expense
    // Return values:
    //    <incomeEarned> - returns the total income earned by the user
    public static double incomeCategory(Scanner console, String category) {
        System.out.print("How many categories of " + category + "? ");
        int incomeCount = console.nextInt();
        double incomeEarned = 0;
        for (int i = 0; i < incomeCount; i++) {
            System.out.print("    Next " + category + " amount? $");
            double incomeVal = console.nextDouble();
            incomeEarned += incomeVal;
        }
        System.out.println();
        return incomeEarned;
    }

    // Computes the total expense the user spent
    // Parameters:
    //    <Scanner console> - this parameter obtains the input from the user within the method
    //    <String category> - this parameter allows for computation of both income and expense
    // Return values:
    //    <expenseSpent> - returns the total expense spent by the user
    public static double expenseCategory(Scanner console, String category) {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        int num = console.nextInt();
        double expenseSpent = incomeCategory(console, "expense");
        if (num == 2) {
            expenseSpent *= DAYS_IN_MONTH;
        }
        return expenseSpent;
    }
    
    // Prints out the total income/expense of the user 
    // and indicates if they are a spender or saver
    // Parameters:
    //    <double income> - this parameter passes in the value of total income
    //    <double expense> - this parameter passes in the value of total expense
    public static void results(double income, double expense) {
        System.out.println("Total income = $" + round2(income) + 
                " ($" + round2(income / DAYS_IN_MONTH) + "/day)");
        System.out.println("Total expenses = $" + round2(expense) + 
                " ($" + round2(expense / DAYS_IN_MONTH) + "/day)");
        System.out.println();

        double incomeDifference = income - expense;
        if (incomeDifference > 0) {
            System.out.println("You earned $" + Math.abs(round2(incomeDifference)) + 
                    " more than you spent this month.");
            if (incomeDifference > 250) {
                System.out.println("You're a big saver.");
                System.out.println("Are you saving up for your dream car? I like tesla");
            } else {
                System.out.println("You're a saver.");
                System.out.println("Congrats you should try harder to save money ");
            }
        } else {
            System.out.println("You spent $" + Math.abs(round2(incomeDifference)) + 
                    " more than you earned this month.");
            if (incomeDifference > -250) {
                System.out.println("You're a spender.");
                System.out.println("wow stop spending money");
            } else {
                System.out.println("You're a big spender.");
                System.out.println("Congrats!! You have reached a superior level of spending!!" +
                    " you should save some money!");
            }
        }
    }

    // Method where it allows numbers to be rounded up
    // to only 2 decimals places
    // Parameter:
    //    <double number> - passes the num value from the expenseCategory method
    // Return values:
    //    <Math.round> - returns the value of the "num" rounded to a one digit decimal
    public static double round2(double num) {
      return Math.round(num * 100.0) / 100.0;
   }
}
