package hospital.dto;

import hospital.entity.enumer.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DoctorsAppointmentDto {

    private String complaint;

    private LocalDate dateInp;

    private LocalDate dateVisit;

    private Status status;
}
