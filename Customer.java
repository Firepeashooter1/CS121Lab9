import java.util.Scanner;

public class Customer extends User {
    private CheckingAccount checking;
    private SavingsAccount savings;

    public Customer() {
        super("Alice", "0000");
        this.checking = new CheckingAccount(0.0);
        this.savings = new SavingsAccount(0.0, 0.0);
    }//End public Customer

    public Customer(String userName, String PIN) {
        super(userName, PIN);
        this.checking = new CheckingAccount(0.0);
        this.savings = new SavingsAccount(0.0, 0.0);
    }//End public Customer String userName String PIN

    public Customer(String userName, String PIN, double checkingBal, double savingsBal, double savingsRate) {
        super(userName, PIN);
        this.checking = new CheckingAccount(checkingBal);
        this.savings = new SavingsAccount(savingsBal, savingsRate);
    }//End public Customer String userName String PIN double checkingBal double savingBal double savingRate

    public static void main(String[] args) {
        Customer alice = new Customer();
        System.out.println("Welcome to the ATM demo.");
        if (alice.login()) {
            System.out.println("Login Successful\n");
            alice.start();
        } else {
            System.out.println("Login failed.");
        }//End if else
    }//End public static void main String args
 
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
            }//End switch

        }//End while
        System.out.println("Exiting customer menu.");
    }//End puvlic void start

    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCustomer Menu\n\n");
        sb.append("0) Exit\n");
        sb.append("1) Manage Checking Account\n");
        sb.append("2) Manage Savings Account\n");
        sb.append("3) change PIN\n\n");
        sb.append("Action (0-3): ");
        return sb.toString();
    }//public String menu

    public void changePin(Scanner sc) {
        System.out.print("Enter current PIN: ");
        String current = sc.nextLine().trim();
        if (!login(this.getUserName(), current)) {
            System.out.println("Current PIN incorrect.");
            return;
        }//End if
        System.out.print("Enter new PIN: ");
        String newPin = sc.nextLine().trim();
        if (newPin.length() == 0) {
            System.out.println("PIN cannot be blank.");
            return;
        }//End if
        setPIN(newPin);
        System.out.println("PIN changed successfully.");
    }//End public void changePin Scanner sc

    public String getReport() {
        return String.format("User: %s | Checking: %s | Savings: %s", 
            getUserName(), checking.getBalanceString(), savings.getBalanceString());
    }//End public String getReport

    private int getInt(Scanner sc) {
        try {
            String token = sc.nextLine().trim();
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return -1;
        }//End try and catch
	
    }//End private int getInt Scanner sc

}//End public class Customer extends User
