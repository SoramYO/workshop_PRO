
package workshop2;

public class Dean extends Instructor {
    String tenureInYears;
    String membersAchievements;

    public Dean() {
    }

    public Dean(String tenureInYears, String membersAchievements) {
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

    
}
