package model;

public class Tester extends Employee {

    protected String type;
    protected double bonusRate;

    public Tester(String empID, String empName, double bonusRate, String type, double baseSal) {
        super(empID, empName, baseSal);
        this.bonusRate = bonusRate;
        this.type = type;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    public String getType() {
        return type;
    }

    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getSalary() {
        return baseSal + bonusRate * baseSal;
    }

    @Override
    public String toString() {
        return super.toString() + "_" + bonusRate + "_" + type;
    }

}
