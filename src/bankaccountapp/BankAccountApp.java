package bankaccountapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// MAIN CLASS
// main application (contains main function)
public class BankAccountApp {
    public static void main(String[] args) {
        // 1. We need a data structure to hold the objects (instances of new customers).

        // the <Account> label describes the type of what objects will be contained in the list
        // i.e. the label is the name of the class, and the class is a BLUEPRINT FOR OBJECTS
        // (even though we will not create objects from the account class - instead we create them from checking and savings classes).
        List<Account> accounts = new LinkedList<Account>();

        // 2. Read a CSV file, then create new accounts based on that data in the data structure.

        // Save to a variable the file pathway of desired file.
        String file = "C:\\Users\\Ruqay\\OneDrive\\Documents\\Java\\NewBankAccounts.txt";

        // We want to create a new account, so we will:
        // assign the list of data returned from the 'utilities.CSV.read(file)' function, to the list 'newAccountHolders'.
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        // for each account holder in the list 'newAccountHolders'.
        for (String[] accountHolder : newAccountHolders) {
            // assign value at each index of the array 'accountHolder', to its respective variable, so that we can use the information.
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            // convert string value to double
            double initDeposit = Double.parseDouble(accountHolder[3]);

            //System.out.println("\n" + name + " " + sSN + " " + accountType + " " + initDeposit);

            // determine type of account to open
            // then add the appropriate type of object, to the list for objects (created at the start of this main method)
            if (accountType.equals("Savings")) {
                // create a new savings account
                accounts.add(new Savings(name, sSN, initDeposit));

            } else if (accountType.equals("Checking")) {
                // create a new checking account
                accounts.add(new Checking(name, sSN, initDeposit));
            } else{
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        //3.  Iterate through data structure of objects 'accounts'.

        // HOW TO GET THE OBJECT AT A SPECIFIC LIST INDEX:
        // E.G. accounts.get(5).showInfo();
        // this line will return the 6th element in the specified list
        // don't need the 'get' method when using the 'for each' as below, because we will iterate through all of them

        // for each account in accounts, run the showInfo() method for that object.
        for (Account acc : accounts) {
            System.out.println("\n------------------------------");
            acc.showInfo();
        }
    }
    // now that we have a database, we can make other methods utilising the fact that we can find or store information.
}
