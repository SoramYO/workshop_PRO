package workshop2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StudentList {

    Students[] list;

    int numOfStudent;
    final int MAX = 10;

    public StudentList() {
        list = new Students[MAX];
        numOfStudent = 0;
    }

    public void addStudent(Students Students) {
        if (Students == null || numOfStudent >= MAX) {
            System.out.println("Error: student list is full");
            return;
        }
        list[numOfStudent] = Students;
        numOfStudent++;
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
            rate = sc.nextInt();
            if (rate >= 0) {
                studentToUpdate.setStudentRatings(rate);
            }
        } else {
            System.out.println("Error: student not found.");
        }
    }

    public void deleteStudent(String fullName) {
        for (int i = 0; i < numOfStudent; i++) {
            if (list[i].getFullName().equals(fullName)) {
                // Shift all elements to the left of the deleted element
                for (int j = i; j < numOfStudent - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[numOfStudent - 1] = null;
                numOfStudent--;
                System.out.println("Student " + fullName + " has been deleted.");
                return;
            }
        }
        System.out.println("Error: student not found.");
    }

   public Students searchStudentByName(String name) {
    for (int i = 0; i < numOfStudent; i++) {
        if (list[i].getFullName().equals(name)) {
            return list[i];
        }
    }
    return null;
}

public Students searchStudentByCode(String code) {
    for (int i = 0; i < numOfStudent; i++) {
        if (list[i].getStudentCode().equals(code)) {
            return list[i];
        }
    }
    return null;
}



    public void sortStudentByName() {
        Arrays.sort(list, 0, numOfStudent, Comparator.comparing(Students::getFullName));
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        String name, id, address, email, phone, code, key, major;
        int rate;
        System.out.println("Enter full name: ");
        name = sc.nextLine();
        System.out.println("ID: ");
        id = sc.nextLine();
        System.out.println("Address: ");
        address = sc.nextLine();
        System.out.println("Email: ");
        email = sc.nextLine();
        System.out.println("Phone number: ");
        phone = sc.nextLine();
        System.out.println("Student code: ");
        code = sc.nextLine();
        System.out.println("Key: ");
        key = sc.nextLine();
        System.out.println("Specialization majors: ");
        major = sc.nextLine();
        System.out.println("Student ratings : ");
        rate = sc.nextInt();
        Students std = new Students(name, id, address, email, phone, code, key, major, rate);
    }
}
