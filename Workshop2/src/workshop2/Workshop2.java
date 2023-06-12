
package workshop2;

import java.util.Scanner;

public class Workshop2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();
        int choice;
        String fullName, code;

        do {
            System.out.println("1. Add a new student");
            System.out.println("2. Update student information");
            System.out.println("3. Clear student information");
            System.out.println("4. Search for students by name");
            System.out.println("5. Search for students by code");
            System.out.println("6. Sort students by name");
            System.out.println("Type 0 to exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    studentList.input();
                    break;
                case 2:
                    System.out.println("Enter student full name to update: ");
                    sc.nextLine();
                    fullName = sc.nextLine();
                    studentList.updateStudent(fullName);
                    break;
                case 3:
                    System.out.println("Enter student code to clear information: ");
                    sc.nextLine();
                    code = sc.nextLine();
                    studentList.deleteStudent(code);
                    break;
                case 4:
                    System.out.println("Enter student full name to search: ");
                    sc.nextLine();
                    fullName = sc.nextLine();
                    Students studentByName = studentList.searchStudentByName(fullName);
                    if (studentByName != null) {
                        System.out.println(studentByName.toString());
                    } else {
                        System.out.println("Error: student name not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter student code to search: ");
                    sc.nextLine();
                    code = sc.nextLine();
                    Students studentByCode = studentList.searchStudentByCode(code);
                    if (studentByCode != null) {
                        System.out.println(studentByCode.toString());
                    } else {
                        System.out.println("Error: student code not found.");
                    }
                    break;
                case 6:
                    studentList.sortStudentByName();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }
}

    
    
 

