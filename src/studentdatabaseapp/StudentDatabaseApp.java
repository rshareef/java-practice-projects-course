package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {
        // the label 'Student' at the beginning indicated what type of object 'stu' is.
        //Student stu = new Student();
        // Ask the user how many new students will be added to the database.
        System.out.println("Enter number of new students to enroll: ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();

        // CREATING AN ARRAY OF OBJECTS OF SIZE N.
        Student [] students = new Student[numOfStudents];

        // Create n number of new students (loop constructor for this many times).
        for (int n = 0; n < numOfStudents; n++) {
            // the student at position n is the new student created.
            students[n] = new Student();
            students[n].enroll();
            students[n].payTuition();
            //students[n].showInfo();

            // Below is an example of method overriding.
            // The method 'toString' belongs to the object class which is the base class of all other methods.
            // In 'Student.java' we can override this method by redefining what it does. e.g. make it return all of the showInfo() information.
            //System.out.println(students[n].toString());
        }
        // See all the information for each student
        for (int n = 0; n < numOfStudents; n++) {
            students[n].showInfo();
        }
    }
}
