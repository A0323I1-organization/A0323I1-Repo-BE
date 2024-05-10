package a0323i_cinema_professtional_be.entity;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "customer")
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "username")
    private String username;

    private String password;

    private String conformPassword;

    @Column(name = "fullname", columnDefinition = "VARCHAR(28)")
    private String fullname;

    @Column(name = "birthday", columnDefinition = "DATE")
    private Date birthday;

    @Column(name = "id_card", columnDefinition = "VARCHAR(28)")
    private String idCard;

    @Column(name = "email", columnDefinition = "VARCHAR(250)")
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(28)")
    private String phone;

    private String address;

    private boolean gender;


    private Role role;

    @OneToMany(mappedBy = "customer")
    private List< Invoice > invoiceList;

    @Override
    public Collection< ? extends GrantedAuthority > getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Customer(int customerId, String username, String password, String fullname, Date birthday, String idCard, String email, String phone, String address, boolean gender, Role role, List< Invoice > invoiceList) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.birthday = birthday;
        this.idCard = idCard;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.role = role;
        this.invoiceList = invoiceList;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List< Invoice > getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List< Invoice > invoiceList) {
        this.invoiceList = invoiceList;
    }
}


