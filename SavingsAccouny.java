public class SavingsAccount extends CheckingAccount {
    private double interestRate; // represented as a decimal (e.g., 0.02 for 2%)

    public SavingsAccount() {
        super();
        this.interestRate = 0.0;
    }//End SavingAccount

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }//End public SavingAccount double balance and double interestRate

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(500.00, 0.03);
        sa.start();
    }//End public static void main String args

    public void calcInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("Applied interest of %.2f; new balance: %s%n", interest, getBalanceString());
    }//End public void calcInterest

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }//End public void setInterestRate double rate

    public double getInterestRate() {
        return interestRate;
    }//End public double get InterestRate

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
    }//End public String menu

}//End public class SavingAccount extends CheckingAccount
