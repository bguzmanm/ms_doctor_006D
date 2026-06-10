package cl.duoc.medicos.dto;

import cl.duoc.medicos.model.Specialty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Schema(name = "Doctor", description = "DTO para la creación o actualización de un médico")
public class DoctorRequestDto {
    @Schema(description = "El nombre del médico", example = "Palurdo", required = true)
    @NotBlank(message = "El nombre no puede estar vacío")
    String name;
    @Schema(description = "El apellido del médico", example = "Fernandez", required = true)
    @NotBlank(message = "El apellido no puede estar vacío")
    String lastName;
    @Email(message = "El correo electrónico no es válido")
    @Schema(description = "El correo electrónico del médico", example = "palurdo.fernandez@medico.cl", required = true)
    String email;
    @NotBlank(message = "El teléfono no puede estar vacío")
    @Schema(description = "El teléfono del médico", example = "999999999", required = true)
    String phone;
}
