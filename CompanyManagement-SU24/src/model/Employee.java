package model;

public abstract class Employee {
    protected String empID;
    protected String empName;
    protected double baseSal;

    public Employee(String empID, String empName, double baseBal) {
        this.empID = empID;
        this.empName = empName;
        this.baseSal = baseBal;
    }

    public String getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public double getBaseBal() {
        return baseSal;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setBaseBal(double baseBal) {
        this.baseSal = baseBal;
    }

    @Override
    public String toString() {
        return empID + "_" + empName + "_" + baseSal;
    }

    public abstract double getSalary();
}
