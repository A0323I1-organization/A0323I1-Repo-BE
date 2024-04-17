package a0323i1_cinema_professtional_be.repository.employee;

import a0323i1_cinema_professtional_be.entity.Account;
import a0323i1_cinema_professtional_be.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Modifying
    @Query(value = "INSERT INTO employee (`address`, `birth_day`, `email`, `fullname`, `gender`, `id_card`, `image`, `phone`,`account`)   " +
            "VALUES (:address, :birthday, :email, :fullname, :gender, :idCard, :image, :phone,:account);",nativeQuery = true)
    void create(@Param("address") String address, @Param("birthday") Date birthday, @Param("email")String email, @Param("fullname") String fullname,
                @Param("gender") boolean gender, @Param("idCard")String idCard, @Param("image")String image, @Param("phone")String phone,@Param("account") Account account);
}
