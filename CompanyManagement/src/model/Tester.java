package model;

public class Tester extends Employee {

    protected double bonusRate;
    protected String type;

    public Tester(String empID, String empName, double bonusRate, String type, int baseBal) {
        super(empID, empName, baseBal);
        this.bonusRate = bonusRate;
        this.type = type;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return empID + "_" + empName + "_" + baseSal;
    }
    

    

    @Override
    public double getSalary() {
        return baseSal + bonusRate * baseSal;
    }

}
