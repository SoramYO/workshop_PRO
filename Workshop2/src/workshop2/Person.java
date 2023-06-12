
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

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
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
}

