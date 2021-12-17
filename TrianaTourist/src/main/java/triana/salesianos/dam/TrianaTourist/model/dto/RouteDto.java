package triana.salesianos.dam.TrianaTourist.model.dto;

import lombok.*;
import triana.salesianos.dam.TrianaTourist.model.POI;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class RouteDto {

    private List<POI> steps;
}
