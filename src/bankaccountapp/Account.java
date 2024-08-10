package bankaccountapp;
// PARENT CLASS
// parent class for common elements between 'checking' and 'saving' classes (using inheritance).
public abstract class Account implements IBaseRate {
    // abstract means we do not (and can't) want to create objects from this class. But we can (and want to) create objects from 'saving' and 'checking' which are classes that inherit 'account'.
    // 'implements IBaseRate' means whatever is inside 'IBaseRate', will now be included in 'Account'. (checking and saving classes will also inherit this when they inherit the account class).


    // List common properties for savings and checking accounts.
    private String name;
    private String sSN;
    private double balance;

    // static is fixed for all instances of a class, not different between instances of classes.
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;
    // protected access modifier means that it can be accessed within the class it has been defined in and it's subclasses.
    // (public would mean it can be accessed in any class.)
    // (private would mean it can only be accessed within the class it has been defined in.)

    // Constructor to set base properties and initialise the account.
    public Account(String name, String sSN, double initDeposit){
        // parent class gets called before child class.
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        // Set account number ( and increment index counter).
        index++;
        this.accountNumber = setAccountNumber();

        // Because this method has been overridden in each child class with the same name, we can call the method from our superclass, and it will provide the appropriate result.
        setRate();
    }

    // Setting specific rates for each type of account
    // abstract keyword: has the general outline, but leaves the implementation to the subclasses.
    // if we tried to write a body to this method, the IDE would flag an error because you can only define this through inheritance in subclasses (checking and savings).
    // abstract also forces us that if a class inherits the 'Account' class, we need to implement this abstract method.
    public abstract void setRate();

    public void compound(){
        // divide rate by 100 to get the actual multiplier (because it is currently a percentage).
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: £" + accruedInterest);
        printBalance();
    }

    private String setAccountNumber() {
        // Get last two characters of SSN.
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        // Generate a unique id (done by initialising a static value and incrementing it for each object created (that is why we do it in the constructor);
        int uniqueID = index;
        // Generate a random 3 digit number.
        // 'Math.random()' generates a random number between 0 and 1.
        // 'Math.pow(10,3)' returns 10 to the power of 3 which is 1000. This makes our number 3 digits long.
        // We then convert: the multiplication of 1000 from 'Math.pow(10,3)' and the decimal generated from 'Math.random()': to an integer, for our random 3-digit number.
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    // List common methods.
    // Generate a random number of length n
    public int randomNumberGen(int n) {
        return (int) (Math.random() * Math.pow(10,n));
    }

    public void deposit(double amount) {
        balance  = balance + amount;
        System.out.println("Depositing £" + amount);
    }
    public void withdraw(double amount) {
        balance  = balance - amount;
        System.out.println("Withdrawing £" + amount);
    }
    public void transfer(String toWhere, double amount) {
        balance  = balance - amount;
        System.out.println("Transferring £" + amount + " to " + toWhere);
    }
    public void printBalance() {
        System.out.println("Your balance is now: £" + balance);
    }

    public void showInfo(){
        System.out.println(
                "\nNAME: " + name
                + "\nACCOUNT NUMBER: " + accountNumber
                + "\nBALANCE: £" + balance
                + "\nRATE: " + rate + "%");
    }


}
