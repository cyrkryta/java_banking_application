import java.util.Scanner;

public class Account {
    // Class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    public Account(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    // Function for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // Function for withdrawing money
    void withdrawal(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // Function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction has occurred!");
        }
    }

    // Function calculating interest of current funds after a number of years
    void calculateInterest(int years) {
        double interestRate = .185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance wil be: " + newBalance);
    }

    // Function showing the main menu
    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("What would you like yo do?");
        System.out.println();
        System.out.println("A => Check balance");
        System.out.println("B => Deposit money");
        System.out.println("C => Make a withdrawal");
        System.out.println("D => View previous transaction");
        System.out.println("E => Calculate interest");
        System.out.println("F => Exit");
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase((option1));
            System.out.println();

            switch (option) {
                // Check balance
                case 'A' -> {
                    System.out.println("======================");
                    System.out.println("Balance = " + balance + " kr.");
                    System.out.println("======================");
                    System.out.println();
                }
                // Deposit money
                case 'B' -> {
                    System.out.println("Enter an amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println();
                }
                // Withdraw money
                case 'C' -> {
                    System.out.println("Enter an amount to withdraw");
                    int withdrawAmount = scanner.nextInt();
                    withdrawal(withdrawAmount);
                    System.out.println();
                }
                // View most recent transaction.
                case 'D' -> {
                    System.out.println("======================");
                    getPreviousTransaction();
                    System.out.println("======================");
                    System.out.println();
                }
                // Calculate interest
                case 'E' -> {
                    System.out.println("Enter the amount of years: ");
                    int yearsAmount = scanner.nextInt();
                    calculateInterest(yearsAmount);
                }
                // Exit
                case 'F' -> System.out.println("======================");

                // Default
                default -> System.out.println("The input is not valid. Pick another.");
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
