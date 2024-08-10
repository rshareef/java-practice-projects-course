package emailapp;

import java.util.Scanner;

// class to create the objects
public class Email {
    // set up variables for methods to later interact with.
    // make variables private for encapsulation to stop people accessing directly.
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail = "N/A";
    private String companySuffix = "company.com";
    private String email;

    // *Constructor to receive the firstname and lastname (so email can be generated).
    // Constructor for the public class email. Parameters (passed through the: firstname, lastname.
    public Email (String firstname, String lastname){
        // 'this.firstname' refers to the class level variable 'firstname'.
        // 'firstname' after the equals sign is the passed in parameter value assigned to the 'firstname' variable for this instance.
        this.firstname = firstname;
        this.lastname = lastname;
        //System.out.println("EMAIL CREATED: " + this.firstname + " " + this.lastname);

        // *Call a method asking for the department. Then return the department.
        // Setting class variable department which is private, equal to the department provided by the user in the method.
        this.department = setDepartment();
        System.out.println("\nDEPARTMENT: " + this.department);
        if (this.department == "None") {
            this.department = "";
        }
        else {
            department = department + ".";
        }

        // Call a method that returns a random password.
        this.password = randomPassword(defaultPasswordLength);
        //System.out.println("Your password is: " + this.password);

        // Combine elements to generate a email;
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        //System.out.println("Your email is: " + email);

    }

    // *Ask for the department.
    // method private as it only needs to be invoked within this class.
    // 'Email' method above is public as it needs to be invoked outside of this class (i.e. in EmailApp).
    private String setDepartment() {
       System.out.print("Hello, " + firstname
                        + ".\nDEPARTMENT CODES:"
                        + "\n1 for Sales"
                        + "\n2 for Development"
                        + "\n3 for Accounting"
                        + "\n0 for None"
                        + "\n\nEnter department code: ");

       Scanner in = new Scanner(System.in);
       int deptChoice = in.nextInt();

       if (deptChoice == 1) { return "Sales"; }
       else if (deptChoice == 2) { return "Development"; }
       else if (deptChoice == 3) { return "Accounting"; }
       else { return "None"; }
    }

    // *Generate random password.
    // 'length' parameter to indicate how long the password generated should be.
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!£$%^&*";
        // generate a random number and look at above string as an array. Then find the value of that array at a given number.
        // build new password set (i.e. an array of characters)
        // https://www.geeksforgeeks.org/use-char-array-string-storing-passwords-java/
        // character array is a data structure used to store a sequence of characters.
        // 'new' creates a new array object.
        char[] password = new char[length];
        // for each character in the password
        for (int i = 0; i < length; i++) {
            // Random number: generate a random (decimal) number between 0 and 1 (Math.random()), multiply this by the (passwordSet.length()), and convert to an integer.
            int rand = (int) (Math.random() * passwordSet.length());
            // charAt() method returns the character at the specified index in a string.
            // set the character at the 'rand' index of 'passwordSet' to the element at position 'i' in the character array 'password'.
            password[i] = passwordSet.charAt(rand);
        }
        // creates a new string object with value as that of passed string parameter (password), and returns it.
        return new String(password);

    }
    // Not in constructor as they are not mandatory methods to use.
    // setting is defining properties, getting is retrieving them.

    // SET METHODS:
    // *Set mailbox capacity. (default value initialised with variable to 500). using encapsulation to hide actual values.
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }
    // *Set the alternate email.
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    // *Change password
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // GET METHODS:
    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }
    // Display information: name, email address, mailbox capacity.
    public String showInfo(){
        return "\nDISPLAY NAME: " + firstname + " " + lastname
                + "\nCOMPANY EMAIL: " + email
                + "\nALTERNATE EMAIL: " + alternateEmail
                + "\nPASSWORD: " + password
                + "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }
}
