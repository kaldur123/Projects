package hospital.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
@NoArgsConstructor
@Getter @Setter
public class Pet extends BaseEntity {

    @Column(name = "type")
    private String type;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "weight")
    private int weight;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    @Transient
    private MultipartFile file;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<DoctorsAppointment> doctorsAppointments;
}
