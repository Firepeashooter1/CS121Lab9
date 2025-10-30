// CheckingAccount.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    protected double balance;

    public CheckingAccount() {
        this.balance = 0.0;
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    // For quick testing
    public static void main(String[] args) {
        CheckingAccount acct = new CheckingAccount(100.0);
        acct.start();
    }

    @Override
    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAccount menu\n\n");
        sb.append("0) quit\n");
        sb.append("1) check balance\n");
        sb.append("2) make a deposit\n");
        sb.append("3) make a withdrawal\n\n");
        sb.append("Please enter 0-3: ");
        return sb.toString();
    }

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.print(menu());
            int choice = getInt(sc);
            switch (choice) {
                case 0:
                    done = true;
                    break;
                case 1:
                    checkBalance();
                    break;
                case 2:
                    makeDeposit(sc);
                    break;
                case 3:
                    makeWithdrawal(sc);
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    }

    // Helper to read a double safely; returns 0.0 on invalid input
    protected double getDouble(Scanner sc) {
        try {
            String token = sc.nextLine().trim();
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Using 0.0.");
            return 0.0;
        }
    }

    // Helper to read an int safely; returns -1 on invalid input
    protected int getInt(Scanner sc) {
        try {
            String token = sc.nextLine().trim();
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void makeDeposit(Scanner sc) {
        System.out.println("Making a deposit...");
        System.out.print("How much to deposit? ");
        double amt = getDouble(sc);
        if (amt <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amt;
        System.out.println("New balance: " + getBalanceString());
    }

    public void makeWithdrawal(Scanner sc) {
        System.out.println("Making a withdrawal...");
        System.out.print("How much to withdraw? ");
        double amt = getDouble(sc);
        if (amt <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amt > balance) {
            System.out.println("Insufficient funds. Current balance: " + getBalanceString());
            return;
        }
        balance -= amt;
        System.out.println("New balance: " + getBalanceString());
    }
}
