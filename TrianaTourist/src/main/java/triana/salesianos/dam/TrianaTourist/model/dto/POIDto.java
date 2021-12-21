package triana.salesianos.dam.TrianaTourist.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.URL;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.CategoryExists;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.UbicacionFormat;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.UniqueImage;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@UbicacionFormat(ubicacionField = "location", message = "{poi.localizacion.pattern}")
public class POIDto {

    @NotEmpty(message = "{poi.nombre.blank}")
    private String name;

    private String location;
    @Lob
    private String description;
    private LocalDate date;

    @CategoryExists(message = "{poi.categoria.exists}")
    private String category;

    @URL(message = "{poi.image.url}")
    @NotEmpty(message = "{poi.image.cover}")
    @UniqueImage(message = "{poi.image.unique}")
    private String coverPhoto;

    @URL(message = "{poi.image.url}")
    @UniqueImage(message = "{poi.image.unique}")
    private String photo2;

    @URL(message = "{poi.image.url}")
    @UniqueImage(message = "{poi.image.unique}")
    private String photo3;
}
