package workshop2;

import java.util.Scanner;

public class Workshop2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();
        int choice;
        String fullName, code;

        do {
            System.out.println("\n1. Add a new student");
            System.out.println("2. Update student information");
            System.out.println("3. Clear student information");
            System.out.println("4. Search for students by name");
            System.out.println("5. Search for students by code");
            System.out.println("6. Sort students by name");
            System.out.println("7. Show list of students");
            System.out.println("Type 0 to exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    studentList.input();
                    break;
                case 2:
                    System.out.println("\nEnter student full name to update: ");
                    fullName = sc.nextLine();
                    studentList.updateStudent(fullName);
                    break;
                case 3:
                    System.out.println("Enter student code to clear information: ");
                    code = sc.nextLine();
                    studentList.deleteStudent(code);
                    break;
                case 4:
                    System.out.println("Enter student full name to search: ");
                    fullName = sc.nextLine();
                    Students studentByName = studentList.searchStudentByName(fullName);
                    if (studentByName != null) {
                        System.out.println(studentByName.toString());
                    } else {
                        System.out.println("\nError: student name not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter student code to search: ");
                    code = sc.nextLine();
                    Students studentByCode = studentList.searchStudentByCode(code);
                    if (studentByCode != null) {
                        System.out.println(studentByCode.toString());
                    } else {
                        System.out.println("\nError: student code not found.");
                    }
                    break;

                case 6:
                    studentList.sortStudentByName();
                    break;
                case 7:
                    studentList.showStudentList();
                    break;
                case 0:
                    System.out.println("\nExiting program...");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

}
