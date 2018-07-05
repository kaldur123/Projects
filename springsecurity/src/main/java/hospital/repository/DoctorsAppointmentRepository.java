package hospital.repository;

import hospital.entity.DoctorsAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsAppointmentRepository extends JpaRepository<DoctorsAppointment, Long> {

    @Query("select d from DoctorsAppointment d join d.pet where d.pet.id = :id1 and d.pet.user.id = :id2")
    List<DoctorsAppointment> findByPetId(@Param("id1")Long id1, @Param("id2") Long id2);
}
