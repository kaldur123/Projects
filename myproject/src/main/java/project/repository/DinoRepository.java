package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.entity.Dino;

import java.util.List;

@Repository
public interface DinoRepository extends JpaRepository<Dino, Long> {

    @Query("select d from Dino d where d.name = :name")
    Dino findDinoByName(@Param("name") String name);

    @Query("select d.name from Dino d where d.kind = :kind")
    List<String> findDinoByKind(@Param("kind")String kind);

    @Query("select distinct (d.kind) from Dino d")
    List<String> findDinoKind();
}
