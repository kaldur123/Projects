package hospital.service.impl;

import hospital.entity.DoctorsAppointment;
import hospital.repository.DoctorsAppointmentRepository;
import hospital.service.DoctorsAppointmentService;
import hospital.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsAppointmentServiceImpl implements DoctorsAppointmentService {

    @Autowired private DoctorsAppointmentRepository doctorsAppointmentRepository;

    @Autowired private PetService petService;

    @Override
    public void saveAppointment(DoctorsAppointment doctorsAppointment, Long id) {
        doctorsAppointment.setPet(petService.findPetById(id));
        doctorsAppointmentRepository.save(doctorsAppointment);
    }

    @Override
    public DoctorsAppointment findById(Long id) {
        return doctorsAppointmentRepository.getOne(id);
    }

    @Override
    public List<DoctorsAppointment> findAll() {
        return doctorsAppointmentRepository.findAll();
    }


    @Override
    public List<DoctorsAppointment> findByPetId(Long id1, Long id2) {
        return doctorsAppointmentRepository.findByPetId(id1, id2);
    }
}
