package triana.salesianos.dam.TrianaTourist.validacion.validadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import triana.salesianos.dam.TrianaTourist.model.POI;
import triana.salesianos.dam.TrianaTourist.repository.RouteRepository;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.PoiAlreadyInRoute;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PoiAlreadyInRouteValidator implements ConstraintValidator<PoiAlreadyInRoute, POI> {

    @Autowired
    private RouteRepository repositorio;

    @Override
    public void initialize(PoiAlreadyInRoute constraintAnnotation) { }

    @Override
    public boolean isValid(POI poi, ConstraintValidatorContext context) {
        return !repositorio.StepsContains(poi);
    }
}
