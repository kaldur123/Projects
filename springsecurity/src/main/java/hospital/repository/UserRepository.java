package hospital.repository;

import hospital.entity.User;
import hospital.entity.enumer.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("select u from User u where u.login = :login")
    User findUserByLogin(@Param("login") String login);

    @Query("update User u set u.login = :login, u.password = :password, u.phoneNumber = :phoneNumber, u.date = :date, u.address = :address where u.id = :id")
    void updateClient(@Param("login") String login,@Param("password") String password,@Param("phoneNumber") int phoneNumber,@Param("date") LocalDate date,@Param("address") String address, @Param("id") Long id);

    @Query("update User u set u.image = :image where u.id = :id")
    void updateImage(@Param("image") byte[] image, @Param("id") Long id);

//    @Query("select u from User u where u.role = :role")
//    List<User> findByRole(@Param("role") UserRole role);
}
