package triana.salesianos.dam.TrianaTourist.model.dto;

import lombok.*;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.UniqueName;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CategoryDto {

    @NotBlank(message = "{categoria.nombre.blank}")
    @UniqueName(message = "{categoria.nombre.unico}")
    private String name;
}
