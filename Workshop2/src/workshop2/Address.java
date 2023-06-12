
package workshop2;


public class Address {
    int houseNumber;
    String streetName;
    String ward;
    String district;
    String province;
    String city;

    public Address() {
    }
    
    public Address(int houseNumber, String streetName, String ward, String district, String province, String city) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.ward = ward;
        this.district = district;
        this.province = province;
        this.city = city;
    }


    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
