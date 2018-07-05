package springboot.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springboot.springbootapp.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("select c from Country c where lower(c.name) = :name")
    Country findCountryByName(@Param("name") String name);
}
