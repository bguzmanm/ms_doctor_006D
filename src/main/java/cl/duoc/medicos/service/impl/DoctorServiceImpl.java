package cl.duoc.medicos.service.impl;

import cl.duoc.medicos.dto.DoctorResponseDto;
import cl.duoc.medicos.model.Doctor;
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

    private Doctor toEntity(DoctorResponseDto dto) {
        return new Doctor(
                dto.getId(),
                dto.getName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getSpecialty()
        );
    }

    @Override
    public List<DoctorResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public List<DoctorResponseDto> findBySpecialtyId(Long id) {
        return List.of();
    }

    @Override
    public DoctorResponseDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public DoctorResponseDto save(DoctorResponseDto dto) {
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
