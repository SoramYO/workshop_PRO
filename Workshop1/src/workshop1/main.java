package workshop1;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        inputStudent();
    }

    public static void inputStudent() {
        Scanner sc = new Scanner(System.in);
        String code, name, address, email, phone;
        String courseCode;
        String courseName;
        int numberPeriods;
        int numberCredits;
        int numberTests;
        String instructor;
        int count;

        System.out.print("How many students you want to input?\n");
        count = Integer.parseInt(sc.nextLine());

        Students arr[] = new Students[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Input student " + (i + 1) + "/" + count);
            System.out.print("Input student code: ");
            code = sc.nextLine();

            System.out.print("Input name: ");
            name = sc.nextLine();

            System.out.print("Input address: ");
            address = sc.nextLine();

            System.out.print("Input email: ");
            email = sc.nextLine();
            
            boolean validPhone = false;
            do {
                System.out.print("Enter student phone number (10 digits): ");
                phone = sc.nextLine();
                if(phone.length()==10 && phone.matches("\\d+")) {
                    validPhone = true;
                } else {
                    System.out.println("Invalid phone number! Please enter a 10-digit numeric value.");
                }
            } while (!validPhone);

            System.out.print("Input courseCode: ");
            courseCode = sc.nextLine();

            System.out.print("Input courseName: ");
            courseName = sc.nextLine();

            System.out.print("Input numberPeriods: ");
            numberPeriods = Integer.parseInt(sc.nextLine());

            System.out.print("Input numberCredits: ");
            numberCredits = Integer.parseInt(sc.nextLine());

            System.out.print("Input numberTests: ");
            numberTests = Integer.parseInt(sc.nextLine());

            System.out.print("Input instructor: ");
            instructor = sc.nextLine();

            Subjects sub = new Subjects(courseCode, courseName, numberCredits, numberPeriods, numberTests, instructor);
            arr[i] = new Students(name, address, email, phone, code, sub);

            arr[i].doHomeWork(arr[i].getScore(), sub.getNumberTests());
        }
        for (int i = 0; i < count; i++) {
            arr[i].showProfile();
        }
    }
}
