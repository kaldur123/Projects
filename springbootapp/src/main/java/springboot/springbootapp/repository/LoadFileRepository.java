package springboot.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.springbootapp.entity.LoadFile;

@Repository
public interface LoadFileRepository extends JpaRepository<LoadFile, Integer> {

}
