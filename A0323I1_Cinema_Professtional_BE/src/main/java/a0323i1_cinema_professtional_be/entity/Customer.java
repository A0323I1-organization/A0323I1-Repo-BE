package a0323i1_cinema_professtional_be.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "fullname",columnDefinition = "VARCHAR(28)")
    private String fullname;

    @Column(name = "birthday",columnDefinition = "DATE")
    private Date birthday;

    private boolean gender;

    @Column(name = "id_card",columnDefinition = "VARCHAR(28)")
    private String idCard;

    @Column(name = "email",columnDefinition = "VARCHAR(250)")
    private String email;

    @Column(name = "phone",columnDefinition = "VARCHAR(28)")
    private String phone;


    private String address;

    @Column(name = "customer_image",columnDefinition = "TEXT")
    private String customerImage;

    private int point;



@JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoiceList;


}
