package a0323i1_cinema_professtional_be.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    private String username;

    private String password;

    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private Role role;
    @OneToMany(mappedBy = "account")
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "account")
    private List<Customer> customerList;
}
