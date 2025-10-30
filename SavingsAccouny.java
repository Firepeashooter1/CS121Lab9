// SavingsAccount.java
public class SavingsAccount extends CheckingAccount {
    private double interestRate; // represented as a decimal (e.g., 0.02 for 2%)

    public SavingsAccount() {
        super();
        this.interestRate = 0.0;
    }

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    // Quick test
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(500.00, 0.03);
        sa.start();
    }

    public void calcInterest() {
        // calculate interest and add to balance
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("Applied interest of %.2f; new balance: %s%n", interest, getBalanceString());
    }

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Savings account will reuse CheckingAccount's menu and start for deposits/withdrawals.
    // If desired, override menu() to customize the printed header.
    @Override
    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nSavings Account\n\n");
        sb.append("Account menu\n\n");
        sb.append("0) quit\n");
        sb.append("1) check balance\n");
        sb.append("2) make a deposit\n");
        sb.append("3) make a withdrawal\n\n");
        sb.append("Please enter 0-3: ");
        return sb.toString();
    }
}
