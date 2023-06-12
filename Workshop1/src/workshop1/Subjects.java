package workshop1;

public class Subjects {
    String courseCode;
    String courseName;
    int numberPeriods = 0;
    int numberCredits = 1;
    int numberTests = 2;
    String instructor;

    //Constructor
    public Subjects() {
    }

    public Subjects(String courseCode, String courseName, int numberPeriods, int numberCredits, int numberTests, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.setNumberPeriods(numberPeriods);
        this.setNumberCredits(numberCredits);
        this.setNumberTests(numberTests);
        this.instructor = instructor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberPeriods() {
        return numberPeriods;
    }

    public int getNumberCredits() {
        return numberCredits;
    }

    public int getNumberTests() {
        return numberTests;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean setNumberPeriods(int numberPeriods) {
        if (numberPeriods >= 0){
            this.numberPeriods = numberPeriods;
            return true;
        }
        return false;
    }

    public boolean setNumberCredits(int numberCredits) {
        if (numberCredits > 1 && numberCredits < 5){
            this.numberCredits = numberCredits;
            return true;
        }
        return false;
    }

    public boolean setNumberTests(int numberTests) {
        if (numberTests > 1 && numberTests < 6){
            this.numberTests = numberTests;
            return true;
        }
        return false;
    }


    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Subjects{" + "courseCode=" + courseCode + ", courseName=" + courseName + ", numberCredits=" + numberCredits +", numberTests=" + numberTests + "instructor=" + instructor + '}';
    }
}

