package bankaccountapp;
// CHILD CLASS
public class Savings extends Account {
    // extends = inherits

    // List properties specific to a savings account.
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialise savings account properties.
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    // List any methods specific to the savings account.
    @Override
    public void setRate(){
        rate = getBaseRate() - 0.25;
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(
        "Your Savings Account Features:"
        + "\n   - Safety Deposit Box ID: " + safetyDepositBoxID
        + "\n   - Safety Deposit Box Key: " + safetyDepositBoxKey);
    }

    private void setSafetyDepositBox() {
        // Generate a random 3-digit and 4-digit number for safety deposit box ID and key, respectively.
        safetyDepositBoxID = randomNumberGen(3);
        safetyDepositBoxKey = randomNumberGen(4);
    }
}
