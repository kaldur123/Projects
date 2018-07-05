package springboot.springbootapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
@NoArgsConstructor
@Getter @Setter
public class StudentDetails extends BaseEntity {

    private String email;


}
