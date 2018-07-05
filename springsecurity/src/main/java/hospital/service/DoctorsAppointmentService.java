package hospital.service;

import hospital.entity.DoctorsAppointment;

import java.util.List;

public interface DoctorsAppointmentService {

    void saveAppointment(DoctorsAppointment doctorsAppointment, Long id);

    DoctorsAppointment findById(Long id);

    List<DoctorsAppointment> findAll();

    List<DoctorsAppointment> findByPetId(Long id1, Long id2);
}
