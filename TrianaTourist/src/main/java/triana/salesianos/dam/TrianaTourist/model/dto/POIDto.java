package triana.salesianos.dam.TrianaTourist.model.dto;

import lombok.*;
import triana.salesianos.dam.TrianaTourist.model.Category;

import javax.persistence.Lob;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class POIDto {

    private String location;
    @Lob
    private String description;
    private LocalDate date;
    private Category category;
    private String coverPhoto;
    private String photo2;
    private String photo3;
}
