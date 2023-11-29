// Student Registration System
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A class to represent student information
class StudentInfo {
    private String name;
    private String department;
    private String id;
    private String gender;

    public StudentInfo(String name, String department, String id, String gender) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.gender = gender;
    }

    // Getter methods to retrieve the value of individual attributes
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }
}

// A class to represent a registration system that can register different types of students
class RegistrationSystem {

    // A list to store the registered students along with their names and departments
    private List<StudentInfo> registeredStudents;

    // A constructor to initialize the list
    public RegistrationSystem() {
        registeredStudents = new ArrayList<>();
    }

    // A method to register a student
    public void registerStudent(Student student, String name, String department) {
        // Checking if the student's GPA is greater than or equal to 1.85
        if (student.getGpa() >= 1.85) {
            // Adding the student info to the list of registered students
            registeredStudents.add(new StudentInfo(name, department, student.getId(), student.getGender()));
            // Printing a success message
            System.out.println("Student successfully registered!");
            // Print additional information (ID, Gender, Name, and Department)
            System.out.println("ID: " + student.getId());
            System.out.println("Gender: " + student.getGender());
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
        } else {
            // Printing a failure message
            System.out.println("GPA is less than 1.85. Registration failed.");
        }
    }

    // A method to get the list of registered students
    public List<StudentInfo> getRegisteredStudents() {
        return registeredStudents;
    }
}

// Creating student class
class Student {
    // Instance variables
    private String id; // The ID number of the student
    private String gender; // The gender of the student
    private double gpa; // The grade point average of the student

    // A constructor to initialize the instance variables
    public Student(String id, String gender, double gpa) {
        this.id = id;
        this.gender = gender;
        this.gpa = gpa;
    }

    // Getter methods to retrieve the value of individual attributes
    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public double getGpa() {
        return gpa;
    }
}

// A class to represent an undergraduate student, which is a subclass of student
class Undergraduate extends Student {
    // A constructor to initialize the instance variables
    public Undergraduate(String id, String gender, double gpa) {
        super(id, gender, gpa);
    }
}

// A class to test the program
public class Main {
    public static void main(String[] args) {
        // Creating a registration system object
        RegistrationSystem system = new RegistrationSystem();

        // Creating a scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Using try-with-resources to automatically close the scanner
        try {
            // Creating a loop to continue the registration until the user input quit
            while (true) {
                // Prompting the user to enter the undergraduate student's details or quit
                System.out.println("Enter the undergraduate student's name or quit: ");
                String name = scanner.nextLine();

                // Checking if the user wants to quit
                if (name.equalsIgnoreCase("quit")) {
                    break; // Breaking the loop
                }

                // Reading student details
                System.out.println("Enter the student's ID: ");
                String id = scanner.nextLine();
                System.out.println("Enter the student's gender: ");
                String gender = scanner.nextLine();
                System.out.println("Enter the student's GPA: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                System.out.println("Enter the student's department: ");
                String department = scanner.nextLine();

                // Creating an undergraduate student object
                Undergraduate undergraduate = new Undergraduate(id, gender, gpa);
                // Registering the undergraduate student
                system.registerStudent(undergraduate, name, department);
            }

            // Displaying the list of registered students
            List<StudentInfo> registeredStudents = system.getRegisteredStudents();
            System.out.println("\nList of Registered Students:");
            for (StudentInfo studentInfo : registeredStudents) {
                System.out.println("Name: " + studentInfo.getName());
                System.out.println("ID: " + studentInfo.getId());
                System.out.println("Gender: " + studentInfo.getGender());
                System.out.println("Department: " + studentInfo.getDepartment() + "\n");
            }

        }
        catch (Exception e) {
            // Printing the exception message
            System.out.println("Error occurred during registration: " + e.getMessage());
        }
        finally {
            // closing scanner
            scanner.close();
        }
    }
}
