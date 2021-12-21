package triana.salesianos.dam.TrianaTourist.validacion.validadores;

import org.springframework.beans.PropertyAccessorFactory;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.UbicacionFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UbicacionFormatValidator implements ConstraintValidator<UbicacionFormat, Object> {

    private String ubicacionField;
    Pattern patron = Pattern.compile("^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$");

    @Override
    public void initialize(UbicacionFormat constraintAnnotation) {
        ubicacionField = constraintAnnotation.ubicacionField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        String ubicacion = (String) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(ubicacionField);

        return patron.matcher(ubicacion).find();
    }
}
