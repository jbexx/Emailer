package emailApp;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPassowrdLength = 8;
    private String alternateEmail;
    private String companySuffix = "handMachine.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
        //call method asking for department from user, return department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        //call method that generates and return random password
        this.password = this.randomPassword(defaultPassowrdLength);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //ask for the department
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
    }

    //generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char [length];
        for (int i=0; i<length; i++) {
            int rando = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rando);
        }
        
        return new String(password);
    }

    //set email capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //set the alternate email
    public void setAltEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //change the password
    public void setPassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAltEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return ("Display Name: " + firstName + " " + lastName +
                "\nComapny Email: " + email + " " +
                "\nMailbox Capacity: " + mailboxCapacity + "mb");

    }
}
