package emailApp;
import java.util.Scanner;

public final class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private int defaultPassowrdLength = 8;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created:: " + this.firstName + ' ' + this.lastName);
        
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        this.password = this.randomPassword(defaultPassowrdLength);
    }

    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char [length];
        for (int i=0; i<length; i++) {
            int rando = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rando);
        }
        
        return new String(password);
    }
}
