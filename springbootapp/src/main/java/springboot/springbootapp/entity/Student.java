package springboot.springbootapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student", indexes = @Index(columnList = "first_name, last_name"))
@Getter
@Setter
@NoArgsConstructor
public class Student extends BaseEntity {


    @Column(name = "first_name", nullable = false)
    private String firstName;



    @Column(name = "last_name")
    private String lastName;


    private int age;

    //@NotNull(message = "Country should be selected")
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_details_id")
    private StudentDetails studentDetails;
}
