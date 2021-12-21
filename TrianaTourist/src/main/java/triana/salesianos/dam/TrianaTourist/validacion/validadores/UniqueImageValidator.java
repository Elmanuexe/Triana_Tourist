package triana.salesianos.dam.TrianaTourist.validacion.validadores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import triana.salesianos.dam.TrianaTourist.repository.POIRepository;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.UniqueImage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueImageValidator implements ConstraintValidator<UniqueImage, String> {

    @Autowired
    private POIRepository repositorio;

    @Override
    public void initialize(UniqueImage constraintAnnotation) { }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        return StringUtils.hasText(url) && !repositorio.existsByName(url);
    }
}
