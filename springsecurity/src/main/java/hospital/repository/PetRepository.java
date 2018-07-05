package hospital.repository;

import hospital.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("select p from Pet p where p.user.id = :id")
    List<Pet> findPetsByUserId(@Param("id") Long id);

    @Query("update Pet p set p.type = :type, p.age = :age, p.name = :name, p.color = :color, p.weight = :weight where p.id = :id")
    void updatePet(@Param("type") String type, @Param("age") int age, @Param("name") String name, @Param("color") String color, @Param("weight") int weight, @Param("id") Long id);

    @Query("update Pet p set p.image = :image where p.id = :id")
    void updateImg(@Param("image") byte[] image, @Param("id") Long id);

}
