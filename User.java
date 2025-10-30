import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
    private static final long serialVersionUID = 1L;

    protected String userName;
    protected String PIN;

    public User() {
        this.userName = "";
        this.PIN = "";
    }//End public User

    public User(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    }//End public User String userName String PIN

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("User name: ");
        String u = sc.nextLine().trim();
        System.out.print("PIN: ");
        String p = sc.nextLine().trim();
        return login(u, p);
    }//End public boolean login

    public boolean login(String userName, String PIN) {
        if (this.userName == null || this.PIN == null) {
            return false;
        }//End if
        return this.userName.equals(userName) && this.PIN.equals(PIN);
    }//End public boolean login String userName, String PIN

    public void setUserName(String userName) {
        this.userName = userName;
    }//End public void setUserName String userName

    public String getUserName() {
        return userName;
    }//End public String getUSerName

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }//End public void setPIN String PIN

    public String getPIN() {
        return PIN;
    }//End Public String getPIN
    public abstract String getReport();
}//End public abstract class User implements HasMenu and Serializable
