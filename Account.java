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
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("What would you like yo do?");
        System.out.println();
        System.out.println("Check => Check balance");
        System.out.println("Deposit => Deposit money");
        System.out.println("Withdraw => Make a withdrawal");
        System.out.println("Prev => View previous transaction");
        System.out.println("Calcint => Calculate interest");
        System.out.println("Exit => Exit");
        //do {
          //  System.out.println();
            //System.out.println("Enter an option: ");
            //String option1 = scanner.next();
            //option = Character.toUpperCase()
        //} while (option != "Exit");
        System.out.println("Thank you for banking with us!");
    }
}
