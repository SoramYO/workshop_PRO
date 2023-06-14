package workshop2;

public class Graduates extends Students {

    String positions;
    int salary;

    public Graduates(String fullName, String idNumber, String address, String email, String phoneNumber, String studentCode, String key, String specializationMajors, int studentRatings, String positions, int salary) {
        super(fullName, idNumber, address, email, phoneNumber, studentCode, key, specializationMajors, studentRatings);
        this.positions = positions;
        this.salary = salary;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Graduates{" + "positions=" + positions + ", salary=" + salary + '}';
    }
    
}
