package hospital.mapper;

import hospital.dto.DoctorsAppointmentDto;
import hospital.entity.DoctorsAppointment;
import hospital.entity.enumer.Status;

public class AppointmentMapper {

    public static DoctorsAppointment convert(DoctorsAppointmentDto doctorsAppointmentDto) {
        DoctorsAppointment doctorsAppointment = new DoctorsAppointment();
        doctorsAppointment.setComplaint(doctorsAppointmentDto.getComplaint());
        doctorsAppointment.setDateInp(doctorsAppointmentDto.getDateInp());
        doctorsAppointment.setDateVisit(doctorsAppointmentDto.getDateVisit());
        doctorsAppointment.setStatus(Status.WAITING);
        return doctorsAppointment;
    }
}
