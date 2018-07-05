package hospital.entity;

import hospital.entity.enumer.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "doctors_appointment")
@NoArgsConstructor
@Getter @Setter
public class DoctorsAppointment extends BaseEntity {

    @Column(name = "complaint")
    private String complaint;

    @Column(name = "date_input")
    private LocalDate dateInp;

    @Column(name = "date_visit")
    private LocalDate dateVisit;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
