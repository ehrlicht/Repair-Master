/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

/**
 *
 * @author Hourglass
 */
public class Customer {
    
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String addressDetails;
    private int npa;
    private String area;

    public Customer(int id, String firstname, String lastname, String email, String phone, String address, String addressDetails, int npa, String area) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.addressDetails = addressDetails;
        this.npa = npa;
        this.area = area;
    }

    public int getId() {
        return id;
    }
   
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return "+41 " + phone.substring(1,3) + " " + phone.substring(3, 6) + " " + phone.substring(6, 8) + " " + phone.substring(8, 10);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public int getNpa() {
        return npa;
    }

    public void setNpa(int npa) {
        this.npa = npa;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
   
    public String getFullAddress() {
        return address + "\n" + npa + ", " + area;
    }
    
    public String toString() {
        return lastname + " " + firstname + "\n" + address + "\n" + npa + ", " + area;
    }
    
}
