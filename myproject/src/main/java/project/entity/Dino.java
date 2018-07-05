package project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "dinosaur")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Dino extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "kind")
    private String kind;

    @OneToMany(mappedBy = "dino", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "dino", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();
}
