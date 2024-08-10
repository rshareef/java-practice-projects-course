package bankaccountapp;
// CHILD CLASS
public class Checking extends Account {
    // List properties specific to a checking account.
    private int debitCardNumber;
    private int debitCardPin;

    // Constructor to initialise checking account properties.
    public Checking(String name, String sSN, double initDeposit) {
        // THIS CALLS THE CONSTRUCTOR OF THE PARENT CLASS AND PASSES THE VARIABLE 'NAME' IN WHICH WAS RECEIVED THROUGH THIS CHILD CLASS BEING INVOKED
        // we use the super keyword to access things in the parent class of the class we are working on. this can be used in 2 ways:
        // 1. to call the original method that has been overridden in the child class e.g. 'super.walk()' if walk() has already been redefined for this child class.
        // 2. to call the constructor of the parent class in the child class, passing any relevant parameters to the parent class too.
        // as seen below we are invoking the parent constructor first and then the lines from the child constructor will execute.
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    // List any methods specific to the checking account.
    @Override
    public void setRate(){
        // rate variable  is available for use to use here because it was defined in the 'Account' class.
        rate = getBaseRate() * 0.15;
    }
    // Overriding the inherited 'showInfo()' method by running the original method, and then adding the rest of what we would like.
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
        "Your Checking Account Features:"
                + "\n   - Debit Card Number " + debitCardNumber
                + "\n   - Debit Card PIN: " + debitCardPin);
    }

    // private method: prevents method from being accessed directly.
    private void setDebitCard() {
        debitCardNumber = randomNumberGen(12);
        debitCardPin = randomNumberGen(4);
    }
}
