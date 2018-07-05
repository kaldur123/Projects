package ua.logos.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.logos.spring.entity.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("select a from Animal a where a.name = :name")
    Animal findAnimalByName(@Param("name") String name);

    @Query("select a from Animal a where a.kind = :kind")
    List<Animal> findAnimalsByKind(@Param("kind") String kind);

    @Query("select a from Animal a where a.gender = :gender")
    List<Animal> findAnimalsByGender(@Param("gender") String gender);
}
