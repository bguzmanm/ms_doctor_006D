package cl.duoc.medicos.assemblers;

import cl.duoc.medicos.controller.DoctorControllerV2;
import cl.duoc.medicos.model.Doctor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DoctorModelAssembler implements RepresentationModelAssembler<Doctor, EntityModel<Doctor>> {
    @Override
    public EntityModel<Doctor> toModel(Doctor entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(DoctorControllerV2.class).getDoctorById(entity.getId())).withSelfRel(),
                linkTo(methodOn(DoctorControllerV2.class).getAllDoctors()).withRel("doctors"));
    }
}
