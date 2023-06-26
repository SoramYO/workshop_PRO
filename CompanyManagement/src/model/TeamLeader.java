package model;

import java.util.ArrayList;

public class TeamLeader extends Developer {
    private double bonus_rate;

    public TeamLeader(String empID, String empName, int baseBal, String teamName, ArrayList<String> programmingLanguages, int expYear, double bonus_rate) {
        super(empID, empName, baseBal, teamName, programmingLanguages, expYear);
        this.bonus_rate = bonus_rate;
    }

    

    public double getBonus_rate() {
        return bonus_rate;
    }
    @Override
    public double getSalary(){
       return getSalary() + bonus_rate * getSalary(); 
    }
}
