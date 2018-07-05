package springboot.springbootapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springboot.springbootapp.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Modifying
    @Query("update Image i set i.imageName = :name, i.fileData = :data where i.user.id = :id")
    void updateImage(@Param("name")String name,@Param("data") byte[] arr, @Param("id") int id);

    @Query("select i from Image i where i.user.id = :id")
    Image findByUserId(@Param("id") int id);
}
