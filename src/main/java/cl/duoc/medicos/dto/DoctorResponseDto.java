package cl.duoc.medicos.dto;

import cl.duoc.medicos.model.Doctor;
import cl.duoc.medicos.model.Specialty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DoctorResponseDto {

    @NotNull
    Long id;
    @NotEmpty
    String name;
    @NotEmpty
    String lastName;
    @Email
    String email;
    @NotEmpty
    String phone;

    Specialty specialty;

}
