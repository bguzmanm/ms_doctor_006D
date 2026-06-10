package cl.duoc.medicos.controller;

import cl.duoc.medicos.assemblers.DoctorModelAssembler;
import cl.duoc.medicos.dto.DoctorRequestDto;
import cl.duoc.medicos.dto.DoctorResponseDto;
import cl.duoc.medicos.model.Doctor;
import cl.duoc.medicos.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/doctors")
@Tag(name = "Doctor", description = "Endpoints para gestionar médicos")
public class DoctorControllerV2 {

    final private DoctorService service;
    final private DoctorModelAssembler assembler;

    @GetMapping("/{id}")
    @Operation(summary = "Obtener médico por ID", description = "Devuelve los detalles de un médico específico por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Médico encontrado"),
            @ApiResponse(responseCode = "404", description = "Médico no encontrado")
    })
    @Parameter(name = "id", description = "ID del médico a buscar", required = true)
    public ResponseEntity<EntityModel<Doctor>> getDoctorById(@PathVariable Long id) {
        Doctor doctor = service.findById(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assembler.toModel(doctor));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los médicos", description = "Devuelve una lista de todos los médicos registrados.")
    public CollectionModel<EntityModel<Doctor>> getAllDoctors() {
        List<EntityModel<Doctor>> doctors = service.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(doctors,
                linkTo(methodOn(DoctorControllerV2.class).getAllDoctors()).withSelfRel());

        // return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo médico", description = "Permite crear un nuevo médico con los datos proporcionados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Médico creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<DoctorResponseDto> save(@RequestBody(required = true) DoctorRequestDto doctor){
        return ResponseEntity.ok(service.save(doctor));
    }
}
