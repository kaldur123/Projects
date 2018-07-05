package ua.logos.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.spring.entity.Enum.Gender;

@Entity
@Table(name = "animal")
@NoArgsConstructor
@Getter @Setter
public class Animal extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "kind")
    private String kind;

    @Column(name = "gender")
    private Gender gender;

}
