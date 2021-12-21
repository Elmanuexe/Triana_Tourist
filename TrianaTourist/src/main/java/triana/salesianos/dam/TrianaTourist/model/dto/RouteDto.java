package triana.salesianos.dam.TrianaTourist.model.dto;

import lombok.*;
import triana.salesianos.dam.TrianaTourist.model.POI;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.PoiAlreadyInRoute;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.UniqueName;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class RouteDto {

    @UniqueName(message = "{route.nombre.unique}")
    private String name;
    @PoiAlreadyInRoute(message = "{route.steps.already}")
    private List<POI> steps;
}
