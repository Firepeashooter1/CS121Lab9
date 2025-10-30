// User.java
import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
    private static final long serialVersionUID = 1L;

    protected String userName;
    protected String PIN;

    public User() {
        this.userName = "";
        this.PIN = "";
    }

    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }

    /**
     * Prompted login: asks user for username and PIN via console.
     * @return true if entered credentials match this user's credentials.
     */
    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("User name: ");
        String u = sc.nextLine().trim();
        System.out.print("PIN: ");
        String p = sc.nextLine().trim();
        return login(u, p);
    }

    /**
     * Direct login with credentials
     */
    public boolean login(String userName, String PIN) {
        if (this.userName == null || this.PIN == null) {
            return false;
        }
        return this.userName.equals(userName) && this.PIN.equals(PIN);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getPIN() {
        return PIN;
    }

    /**
     * Each subclass must implement a report string for admin listing, etc.
     */
    public abstract String getReport();
}
