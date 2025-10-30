// Customer.java
import java.util.Scanner;

public class Customer extends User {
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer() {
        // default test customer per instructions
        super("Alice", "0000");
        this.checking = new CheckingAccount(0.0);
        this.savings = new SavingsAccount(0.0, 0.0);
    }

    public Customer(String userName, String PIN) {
        super(userName, PIN);
        this.checking = new CheckingAccount(0.0);
        this.savings = new SavingsAccount(0.0, 0.0);
    }

    public Customer(String userName, String PIN, double checkingBal, double savingsBal, double savingsRate) {
        super(userName, PIN);
        this.checking = new CheckingAccount(checkingBal);
        this.savings = new SavingsAccount(savingsBal, savingsRate);
    }

    // Main for quick manual test: prompts login for Alice/0000 then shows menu
    public static void main(String[] args) {
        Customer alice = new Customer();
        System.out.println("Welcome to the ATM demo.");
        if (alice.login()) {
            System.out.println("Login Successful\n");
            alice.start();
        } else {
            System.out.println("Login failed.");
        }
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
                    System.out.println("Checking Account");
                    checking.start();
                    break;
                case 2:
                    System.out.println("Savings Account");
                    savings.start();
                    break;
                case 3:
                    changePin(sc);
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
        System.out.println("Exiting customer menu.");
    }

    @Override
    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCustomer Menu\n\n");
        sb.append("0) Exit\n");
        sb.append("1) Manage Checking Account\n");
        sb.append("2) Manage Savings Account\n");
        sb.append("3) change PIN\n\n");
        sb.append("Action (0-3): ");
        return sb.toString();
    }

    public void changePin(Scanner sc) {
        System.out.print("Enter current PIN: ");
        String current = sc.nextLine().trim();
        if (!login(this.getUserName(), current)) {
            System.out.println("Current PIN incorrect.");
            return;
        }
        System.out.print("Enter new PIN: ");
        String newPin = sc.nextLine().trim();
        if (newPin.length() == 0) {
            System.out.println("PIN cannot be blank.");
            return;
        }
        setPIN(newPin);
        System.out.println("PIN changed successfully.");
    }

    @Override
    public String getReport() {
        // A short report string describing this customer (for admin views later)
        return String.format("User: %s | Checking: %s | Savings: %s", 
            getUserName(), checking.getBalanceString(), savings.getBalanceString());
    }

    // Small helper to read int similar to CheckingAccount's getInt
    private int getInt(Scanner sc) {
        try {
            String token = sc.nextLine().trim();
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
