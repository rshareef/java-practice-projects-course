package emailapp;
// contains main method
// This is the application.
public class EmailApp {
    public static void main(String[] args) {
        Email em1 = new Email("John", "Smith");
        System.out.println(em1.showInfo());
        
        em1.setMailBoxCapacity(200);
        em1.setAlternateEmail("smith.john@outlook.com");
        em1.changePassword("john_4528");
        System.out.println(em1.showInfo());

    }
}
