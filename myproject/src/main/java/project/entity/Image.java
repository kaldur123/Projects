package project.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dino_image")
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseEntity{

    @Column(name = "image_url")
    private String image;

    @ManyToOne
    @JoinColumn(name = "dino_id")
    private Dino dino;
}
