
package workshop2;

import java.util.List;

public class Students extends Person {
    private String studentCode;
    private String key;
    private String specializationMajors;
    private int studentRatings;

    public Students() {
        super();
    }
    

    public Students(String fullName, String idNumber, String address, String email, String phoneNumber, String studentCode, String key, String specializationMajors, int studentRatings) {
        super(fullName, idNumber, address, email, phoneNumber);
        this.studentCode = studentCode;
        this.key = key;
        this.specializationMajors = specializationMajors;
        this.studentRatings = studentRatings;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getKey() {
        return key;
    }

    public String getSpecializationMajors() {
        return specializationMajors;
    }

    public int getStudentRatings() {
        return studentRatings;
    }

  
    
}
