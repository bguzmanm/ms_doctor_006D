package cl.duoc.medicos.service;

import cl.duoc.medicos.dto.DoctorResponseDto;

import java.util.List;

public interface DoctorService {
    List<DoctorResponseDto> findAll();
    List<DoctorResponseDto> findBySpecialtyId(Long id);
    DoctorResponseDto findById(Long id);
    DoctorResponseDto save(DoctorResponseDto dto);
    Boolean deleteById(Long id);
}
