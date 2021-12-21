package triana.salesianos.dam.TrianaTourist.validacion.anotaciones;

import triana.salesianos.dam.TrianaTourist.validacion.validadores.UbicacionFormatValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UbicacionFormatValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UbicacionFormat {

    String message() default "La ubiccación debe seguir un patrón como este '(-)numero.decimales, (-)numero.decimales'";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String ubicacionField();
}

