package a0323i1_cinema_professtional_be.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")

    private int EmployeeId;

    @Column(name = "image",columnDefinition = "TEXT")
    private String image;

    @Column(name = "birth_day",columnDefinition = "DATE")
    private Date birthday;

    private boolean gender;

    @Column(name = "fullname",columnDefinition = "VARCHAR(28)")
    private String fullname;

    @Column(name = "id_card",columnDefinition = "VARCHAR(28)")
    private String idCard;

    @Column(name = "email",columnDefinition = "VARCHAR(250)")
    private String email;

    @Column(name = "phone",columnDefinition = "VARCHAR(28)")
    private String phone;

    private String address;
    @ManyToOne
    @JoinColumn(name = "employee_account_id",referencedColumnName = "account_id")
    private Account account;

    @OneToMany(mappedBy = "employee")
    private List<Invoice> invoiceList;


}
