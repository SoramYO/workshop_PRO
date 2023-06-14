
package workshop2;

public class Person {
    private String fullName;
    private String idNumber;
    private String address;
    private String email;
    private String phoneNumber;
public Person(){
    
}
    public Person(String fullName, String idNumber, String address, String email, String phoneNumber) {
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "fullName=" + fullName + ", idNumber=" + idNumber + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }

    
}

