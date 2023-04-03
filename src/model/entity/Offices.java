package model.entity;

public class Offices {
    private String officeCode;
    private String city;
    private String phoneNumber;
    private String address;
    private String postalCode;

    public Offices() {
    }

    public Offices(String officeCode, String city, String phoneNumber, String address, String postalCode) {
        this.officeCode = officeCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }
}
