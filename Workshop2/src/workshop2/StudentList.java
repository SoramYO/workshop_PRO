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
            return ;
        }
        list[numOfStudent] = Students;
        numOfStudent++;
    }

    public void updateStudent() {
    }

    public void deleteStudent() {
    }

    public Students searchStudent(String fullName) {
        for (int i = 0; i < numOfStudent; i++) {
            if (list[i].getFullName().equals(fullName)) {
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
        String name, id, address, email,phone, code, key, major;
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
