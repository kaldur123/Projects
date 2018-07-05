package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.entity.Enums.UserRole;
import project.entity.Writer;

import java.util.List;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {

    @Query("select w from Writer w where w.email = :email")
    Writer findByEmail(@Param("email") String email);

    @Query("select w from Writer w where w.role = :role")
    List<Writer> findUsersByRole(@Param("role")UserRole role);

    @Transactional
    @Modifying
    @Query("update Writer w set w.fullName = :fullName, w.age = :age, w.country = :country where w.id = :id")
    void updateUser(@Param("fullName") String fullName, @Param("age") int age, @Param("country") String country, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("update Writer w set w.imageUrl = :imageUrl where w.id = :id")
    void updateImage(@Param("imageUrl")String url, @Param("id")Long id);

}
