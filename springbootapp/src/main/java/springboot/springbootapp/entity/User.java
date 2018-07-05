package springboot.springbootapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.springbootapp.Validator.PassConfirm;
import springboot.springbootapp.Validator.UniqueUser;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user", indexes = @Index(columnList = "email, login, first_name, last_name, last_name"))
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "password")
    private String pass;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Image image;

}
