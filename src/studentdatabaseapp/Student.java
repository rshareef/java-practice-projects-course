package studentdatabaseapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private String firstname;
    private String lastname;
    private int gradeYear;
    private String studentID;
    private String[] courses = {"History 101", "Mathematics 101", "English 101", "Chemistry 101", "Computer Science 101"};
    // static: property is not specific to a singular object, but is true for all objects of the class.
    private static int courseCost = 600;
    private int balance;
    private static int id = 1000;
    ArrayList <String> enrolled = new ArrayList();

    // Constructor. The IDE recognises it as a constructor because it has the same name as the class. It doesn't need a return type because it is a constructor.
    public Student() {
        // Ask the user to enter the name of the student
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstname = in.nextLine();
        System.out.println("Enter student last name: ");
        this.lastname = in.nextLine();

        // Ask the user to enter the year of the student.
        System.out.println("Enter student year (e.g. '1' for Stage 1:");
        this.gradeYear = in.nextInt();

        // Generate student id.
        setID();

        //System.out.println( firstname + " " + lastname + " " + gradeYear + " " + studentID);
    }

    // Generate student id.
    private String setID() {
        studentID = String.valueOf(gradeYear)+ String.valueOf(id + 1);
        return studentID;
    }

    // Ask the student to choose a course to enroll on. Save the change. Ask them till they quit.
    public void enroll() {
        // Get inside a loop, user hits 0 to exit.
        int choice;

        while (true) {
            System.out.println(
                    """
                            1 - History 101
                            2 - Mathematics 101
                            3 - English 101
                            4 - Chemistry 101
                            5 - Computer Science 101
                            Enter course to enroll, or 0 to quit:\s""");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            if (choice == 0) {
                break;
            }
            else if (choice < 1 || choice > 5 ) {
                System.out.println("Invalid choice. Try again.");
            }
            else if (enrolled.contains(courses[choice-1])) {
                System.out.println("You already have an enrolled in this course.");
            }
            else {
                enrolled.add(courses[choice-1]);
                balance += courseCost;
            }
            System.out.println("Enrolled courses: " + enrolled);
            viewBalance();
        }
    }

    // Method to allow student to view balance.
    public void viewBalance (){
        System.out.println("Balance to pay: £" + balance);
    }

    // Method to allow student to pay tuition.
    public void payTuition(){
        viewBalance();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter how much you would like to pay: ");
        int pay = in.nextInt();
        balance -= pay;
        viewBalance();
    }

    // Method to show student status: name, ID, courses enrolled, balance.
    public void showInfo(){
        System.out.println("\nName: " + firstname + " " + lastname
                + "\nGrade Level: " + gradeYear
                + "\nStudent ID: " + studentID
                + "\nCourses Enrolled: ");
        for (String i : enrolled) {
            // Print all elements of ArrayList
            System.out.println("- " + i);
        }
        viewBalance();
    }

}




