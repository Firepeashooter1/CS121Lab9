import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    protected double balance;

    public CheckingAccount() {
        this.balance = 0.0;
    }//End public CheckingAccount

    public CheckingAccount(double balance) {
        this.balance = balance;
    }//End public CheckingAccount double balance

    public static void main(String[] args) {
        CheckingAccount acct = new CheckingAccount(100.0);
        acct.start();
    }//End public static void main String args

    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAccount menu\n\n");
        sb.append("0) quit\n");
        sb.append("1) check balance\n");
        sb.append("2) make a deposit\n");
        sb.append("3) make a withdrawal\n\n");
        sb.append("Please enter 0-3: ");
        return sb.toString();
    }//End public String menu

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
            }//End switch

        }//End While

    }//End public void start

    public double getBalance() {
        return balance;
    }//End public double getBalance

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }//End public String getBalanceString

    public void setBalance(double balance) {
        this.balance = balance;
    }//End public void setBalance double balnce

    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    }//End public void checkBalance

    protected double getDouble(Scanner sc) {
        try {
            String token = sc.nextLine().trim();
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Using 0.0.");
            return 0.0;
        }//End try and catch

    }//End protected double getDOuble Scanner sc

    protected int getInt(Scanner sc) {
        try {
            String token = sc.nextLine().trim();
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return -1;
        }//End try and catch

    }//End protected int getInt Scanner sc

    public void makeDeposit(Scanner sc) {
        System.out.println("Making a deposit...");
        System.out.print("How much to deposit? ");
        double amt = getDouble(sc);
        if (amt <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }//End if
        balance += amt;
        System.out.println("New balance: " + getBalanceString());
    }//End public void makeDeposit Scanner sc

    public void makeWithdrawal(Scanner sc) {
        System.out.println("Making a withdrawal...");
        System.out.print("How much to withdraw? ");
        double amt = getDouble(sc);
        if (amt <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }//End if
        if (amt > balance) {
            System.out.println("Insufficient funds. Current balance: " + getBalanceString());
            return;
        }//End if
        balance -= amt;
        System.out.println("New balance: " + getBalanceString());
    }//End public void makeWithdrawal Scanner sc

}//End public class CheckingAccount implements HasMenu
