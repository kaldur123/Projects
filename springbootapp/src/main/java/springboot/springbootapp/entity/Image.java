package springboot.springbootapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "user_image")
@NoArgsConstructor
@Getter @Setter
public class Image extends BaseEntity{

    @Column(name = "image_name")
    private String imageName;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] fileData;

    @Transient
    private MultipartFile file;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
