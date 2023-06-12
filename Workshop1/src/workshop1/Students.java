package workshop1;

import java.util.Scanner;

public class Students {

    String name, address, email, phoneNumber, studentCode;
    Subjects course;
    private int[] score = new int[5];

    public Students() {
    }

    public Students(Subjects course) {
        this.course = course;
    }

    public Students(String name, String address, String email, String phoneNumber, String studentCode, Subjects course) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.studentCode = studentCode;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public Subjects getCourse() {
        return course;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setCourse(Subjects course) {
        this.course = course;
    }

    public void doHomeWork(int[] Score, int numberTests) {
    if (course == null) {
        return;
    }
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < numberTests; i++) {
        int score;
        do {
            System.out.printf("Enter your score for test %d (0-10): ", i + 1);
            score = sc.nextInt();
        } while (score < 0 || score > 10);
        Score[i] = score;
    }
}


    public double calculatedTuition(int numberCredits) {
        return course.getNumberCredits() * 560;
    }

    public double taskExam() {
        double avg = 0;
        switch (course.getNumberTests()) {
            case 2:
                avg = 0.3 * score[0] + 0.7 * score[1];
                break;
            case 3:
                avg = 0.2 * score[0] + 0.3 * score[1] + 0.5 * score[2];
                break;
            case 4:
                avg = 0.15 * score[0] + 0.25 * score[1] + 0.3 * score[2] + 0.3 * score[3];
                break;
            case 5:
                avg = 0.1 * score[0] + 0.2 * score[1] + 0.2 * score[2] + 0.25 * score[3] + 0.25 * score[4];
                break;
        }
        return avg;
    }

    public void showProfile() {
        System.out.println("Student information:");
        System.out.println("Name: " + getName());
        System.out.println("Address: " + getAddress());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone number: " + getPhoneNumber());
        System.out.println("Student code: " + getStudentCode());
        System.out.println("Course code: " + course.getCourseCode());
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Number of credits: " + course.getNumberCredits());
        System.out.println("Number of periods: " + course.getNumberPeriods());
        System.out.println("Instructor: " + course.getInstructor());
        System.out.println("Calculated tuition: " + calculatedTuition(course.getNumberCredits()));
        System.out.println("Task Exam: " + taskExam());
        double avg = taskExam();
        String status = avg >= 4 ? "Passed" : "Failed";
        for (int i = 0; i < course.getNumberTests(); i++) {
            System.out.printf("Test scores "+(i+1)+": %d\n", getScore()[i]);
        }
        System.out.printf("Average score: %.2f\n", avg);
        System.out.println("Status: " + status);

    }
}
