package springboot.springbootapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "load_file")
@NoArgsConstructor
@Getter @Setter
public class LoadFile extends BaseEntity {

    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] fileData;

    @Transient
    private MultipartFile file;
}
