package a0323i_cinema_professtional_be.dto;

import a0323i_cinema_professtional_be.entity.Customer;

import java.util.Date;


public class CustomerDto {
    private String fullname;
    private Date birthday;
    private String gender;
    private String idCard;
    private String email;
    private String phone;
    private String address;
    private String password;
    private Customer customer;

    public CustomerDto() {
    }

    public CustomerDto(String fullname, Date birthday, String gender, String idCard, String email, String phone, String address, String password, Customer customer) {
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.customer = customer;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}