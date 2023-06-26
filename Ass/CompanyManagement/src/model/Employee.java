package model;

public abstract class Employee {
    protected String empID;
    protected String empName;
    protected int baseSal;

    public Employee(String empID, String empName, int baseBal) {
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

    public int getBaseBal() {
        return baseSal;
    }

    @Override
    public String toString() {
        return "Employee{" + "empID=" + empID + ", empName=" + empName + ", baseBal=" + baseSal + '}';
    }
    
    public abstract double getSalary();
}
