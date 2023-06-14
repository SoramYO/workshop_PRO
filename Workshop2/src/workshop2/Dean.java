
package workshop2;

public class Dean extends Instructor {
    String tenureInYears;
    String membersAchievements;

    public Dean(String fullName, String idNumber, String address, String email, String phoneNumber, String instructorCode, String specializationSubject, int yearsOfExperience, double salary, String workingPosition,String tenureInYears,String membersAchievements) {
        super(fullName, idNumber, address, email, phoneNumber,instructorCode,specializationSubject,yearsOfExperience,salary,workingPosition);
        this.tenureInYears = tenureInYears;
        this.membersAchievements = membersAchievements;
    }

    public String getTenureInYears() {
        return tenureInYears;
    }

    public void setTenureInYears(String tenureInYears) {
        this.tenureInYears = tenureInYears;
    }

    public String getMembersAchievements() {
        return membersAchievements;
    }

    public void setMembersAchievements(String membersAchievements) {
        this.membersAchievements = membersAchievements;
    }

    @Override
    public String toString() {
        return "Dean{" + "tenureInYears=" + tenureInYears + ", membersAchievements=" + membersAchievements + '}';
    }

}
