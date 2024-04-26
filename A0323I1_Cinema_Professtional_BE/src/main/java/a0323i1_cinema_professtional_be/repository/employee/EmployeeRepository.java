package a0323i1_cinema_professtional_be.repository.employee;


import a0323i1_cinema_professtional_be.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO employee (address, birth_day, gender, fullname, id_card, email, phone, employe_image, employee_account_id,status) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)", nativeQuery = true)
    void createEmployee(@Param("address") String address, @Param("birthday") Date birthday, @Param("gender") boolean gender,
                        @Param("fullname") String fullname, @Param("idCard") String idCard, @Param("email") String email,
                        @Param("phone") String phone, @Param("employeImage") String employeImage,
                        @Param("accountId") int accountId,@Param("status") boolean status);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET address=:address, birth_day=:birthday, gender=:gender, fullname=:fullname, id_card=:idCard, " +
            "email=:email, phone=:phone, employe_image=:image, employee_account_id=:accountId " +
            "WHERE employee_id=:id", nativeQuery = true)
    void updateEmployee(@Param("address") String address, @Param("birthday") Date birthday, @Param("gender") boolean gender,
                        @Param("fullname") String fullname, @Param("idCard") String idCard, @Param("email") String email,
                        @Param("phone") String phone, @Param("image") String image, @Param("accountId") int accountId, @Param("id") int id);
}
