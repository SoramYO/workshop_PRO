
package workshop2;


public class Instructor extends Person {
    private String instructorCode;
    private String specializationSubject;
    private int yearsOfExperience;
    private double salary;
    private String workingPosition;

    public Instructor(String fullName, String idNumber, String address, String email, String phoneNumber, String instructorCode, String specializationSubject, int yearsOfExperience, double salary, String workingPosition) {
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

    public double getSalary() {
        return salary;
    }

    public String getWorkingPosition() {
        return workingPosition;
    }

    public void setInstructorCode(String instructorCode) {
        this.instructorCode = instructorCode;
    }

    public void setSpecializationSubject(String specializationSubject) {
        this.specializationSubject = specializationSubject;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setWorkingPosition(String workingPosition) {
        this.workingPosition = workingPosition;
    }

    @Override
    public String toString() {
        return "Name: " + getFullName()
                + "\nID Number: " + getIdNumber()
                + "\nAddress: " + getAddress()
                + "\nEmail: " + getEmail()
                + "\nPhone Number: " + getPhoneNumber()
                + "\nInstructor Code: " + getInstructorCode()
                + "\nSpecialization Subject: " + getSpecializationSubject()
                + "\nYears Of Experience: " + getYearsOfExperience()
                + "\nSalary: " + getSalary()
                + "\nWorking Position: " +  getWorkingPosition();
    }
}

