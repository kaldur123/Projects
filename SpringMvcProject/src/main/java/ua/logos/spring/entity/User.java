package ua.logos.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.spring.entity.Enum.Degree;
import ua.logos.spring.entity.Enum.Gender;
import ua.logos.spring.entity.Enum.Rank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "email")
    private String email;

    @Column(name = "degree")
    private Degree degree;

    @Column(name = "social_network")
    private String[] socNet;

    @Column(name = "favorite_programming_language")
    private String favoriteProgrammingLanguage;

    @Column(name = "operation_system")
    private String[] os;

    @Column(name = "programming_experience")
    private String programmingExperience;

    @Column(name = "rank")
    private Rank rank;

    @Column(name = "technologies")
    private String[] technologies;

    @Column(name = "information_source")
    private String informationSource;
}
