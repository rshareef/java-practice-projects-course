package bankaccountapp;
// INTERFACE CLASS
// interface. provides information from external sources.
public interface IBaseRate {
    // methods in here will deal with interest rate provided by external source.

    // HOW THE INTERFACE THING WORKS:
    // 1. Interface receives base rate (i.e. through an API)
    // 2. We put an abstract method in the Account superclass, saying the checking and savings HAVE to implement this method.
    // 3. The implementation of the above is the override in the checking and saving classes, with whatever algorithm we define
    // 4. Then because it's the same method, we call it in teh account superclass.
    // 5. We use the rate variable (that was set at the superclass level) when setting the respective values, and print it in showInfo.

    // Write a method that returns the base rate.
    default double getBaseRate() {
        return 2.5;
    }

}
