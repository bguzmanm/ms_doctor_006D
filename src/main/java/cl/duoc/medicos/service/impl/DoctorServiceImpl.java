package cl.duoc.medicos.service.impl;

import cl.duoc.medicos.dto.DoctorRequestDto;
import cl.duoc.medicos.dto.DoctorResponseDto;
import cl.duoc.medicos.model.Doctor;
import cl.duoc.medicos.model.Specialty;
import cl.duoc.medicos.repository.DoctorRepository;
import cl.duoc.medicos.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    private DoctorResponseDto toDto(Doctor doctor) {
        return new DoctorResponseDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getSpecialty()
        );
    }

    private DoctorRequestDto toDtoReq(Doctor doctor) {
        return new DoctorRequestDto(
                doctor.getName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getPhone()
        );
    }

    private Doctor toEntity(DoctorRequestDto dto) {
        return new Doctor(
                0L,
                dto.getName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhone(),
                new Specialty(999L, "en configuración")
        );
    }



    @Override
    public List<Doctor> findAll() {
        return repository.findAll();
    }

    @Override
    public List<DoctorResponseDto> findBySpecialtyId(Long id) {
        return List.of();
    }

    @Override
    public Doctor findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public DoctorResponseDto save(DoctorRequestDto dto) {
        return this.toDto(repository.save(this.toEntity(dto)));
    }

    @Override
    public Boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
