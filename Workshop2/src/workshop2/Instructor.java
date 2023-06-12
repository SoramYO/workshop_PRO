
package workshop2;


public class Instructor extends Person {
    private String instructorCode;
    private String specializationSubject;
    private int yearsOfExperience;
    private float salary;
    private String workingPosition;

    public Instructor(String fullName, String idNumber, String address, String email, String phoneNumber, String instructorCode, String specializationSubject, int yearsOfExperience, float salary, String workingPosition) {
        super(fullName, idNumber, address, email, phoneNumber);
        this.instructorCode = instructorCode;
        this.specializationSubject = specializationSubject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.workingPosition = workingPosition;
    }

    public String getInstructorCode() {
        return instructorCode;
    }

    public String getSpecializationSubject() {
        return specializationSubject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public float getSalary() {
        return salary;
    }

    public String getWorkingPosition() {
        return workingPosition;
    }
}

