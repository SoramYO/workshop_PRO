package workshop2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentList {

    private final ArrayList<Students> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Students student) {

        if (this.studentList.size() >= 10) {
            System.out.println("Error: student list is full");
            return;
        }
        this.studentList.add(student);
    }

    public void updateStudent(String fullName) {
        Students studentToUpdate = searchStudentByName(fullName);

        if (studentToUpdate != null) {
            Scanner sc = new Scanner(System.in);
            String id, address, email, phone, key, major;
            int rate;

            System.out.println("Update student ID (" + studentToUpdate.getIdNumber() + "):");
            id = sc.nextLine();
            if (!id.isEmpty()) {
                studentToUpdate.setIdNumber(id);
            }

            System.out.println("Update student address (" + studentToUpdate.getAddress() + "):");
            address = sc.nextLine();
            if (!address.isEmpty()) {
                studentToUpdate.setAddress(address);
            }

            System.out.println("Update student email (" + studentToUpdate.getEmail() + "):");
            email = sc.nextLine();
            if (!email.isEmpty()) {
                studentToUpdate.setEmail(email);
            }

            System.out.println("Update student phone number (" + studentToUpdate.getPhoneNumber() + "):");
            phone = sc.nextLine();
            if (!phone.isEmpty()) {
                studentToUpdate.setPhoneNumber(phone);
            }

            System.out.println("Update student key (" + studentToUpdate.getKey() + "):");
            key = sc.nextLine();
            if (!key.isEmpty()) {
                studentToUpdate.setKey(key);
            }

            System.out.println("Update student specialization major (" + studentToUpdate.getSpecializationMajors() + "):");
            major = sc.nextLine();
            if (!major.isEmpty()) {
                studentToUpdate.setSpecializationMajors(major);
            }

            System.out.println("Update student ratings (" + studentToUpdate.getStudentRatings() + "):");
            try {
                rate = sc.nextInt();
                if (rate >= 0) {
                    studentToUpdate.setStudentRatings(rate);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Rating must be an integer.");
            }
        } else {
            System.out.println("Error: student not found.");
        }
    }

    public void deleteStudent(String fullName) {
        Students studentToDelete = searchStudentByName(fullName);

        if (studentToDelete != null) {
            this.studentList.remove(studentToDelete);
            System.out.println("Student " + fullName + " has been deleted.\n");
        } else {
            System.out.println("Error: student not found.");
        }
    }

    public Students searchStudentByName(String name) {
        for (int i = 0; i < studentList.size(); i++) {
             System.out.println("=================================================");
            Students std = studentList.get(i);
            if (std.getFullName().equalsIgnoreCase(name)) {
                return std;
            }
            System.out.println("=================================================");
        }
        return null;
    }

    public Students searchStudentByCode(String code) {
        for (int i = 0; i < studentList.size(); i++) {
             System.out.println("=================================================");
            Students std = studentList.get(i);
            if (std.getStudentCode().equals(code)) {
                return std;
            }
            System.out.println("=================================================");
        }
        return null;
    }

    public void sortStudentByName() {
        studentList.sort(Comparator.comparing(Students::getFullName));
        System.out.println("Sort student list success");
    }

    public void showStudentList() {
        System.out.println("List of students:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("Student" + (i + 1));
            System.out.println("=================================================");
            Students std = studentList.get(i);
            System.out.println(std.toString());
            System.out.println("=================================================");
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        String name, id, address, email, phone, code, key, major;
        int rate;

        System.out.println("\nEnter full name:");
        name = sc.nextLine();

        System.out.println("Enter student ID:");
        id = sc.nextLine();

        System.out.println("Enter student address:");
        address = sc.nextLine();

        System.out.println("Enter student email:");
        email = sc.nextLine();

        System.out.println("Enter student phone number:");
        phone = sc.nextLine();

        System.out.println("Enter student code:");
        code = sc.nextLine();

        System.out.println("Enter student key:");
        key = sc.nextLine();

        System.out.println("Enter specialization major:");
        major = sc.nextLine();

        System.out.println("Enter student ratings:");
        rate = sc.nextInt();

        Students std = new Students(name, id, address, email, phone, code, key, major, rate);
        addStudent(std);
        System.out.println("Add student success!\n");
    }
}
