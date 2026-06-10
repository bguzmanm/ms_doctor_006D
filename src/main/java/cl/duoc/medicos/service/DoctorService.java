package cl.duoc.medicos.service;

import cl.duoc.medicos.dto.DoctorRequestDto;
import cl.duoc.medicos.dto.DoctorResponseDto;
import cl.duoc.medicos.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAll();
    List<DoctorResponseDto> findBySpecialtyId(Long id);
    Doctor findById(Long id);
    DoctorResponseDto save(DoctorRequestDto dto);
    Boolean deleteById(Long id);
}
