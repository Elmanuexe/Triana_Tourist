package triana.salesianos.dam.TrianaTourist.validacion.anotaciones;

import triana.salesianos.dam.TrianaTourist.validacion.validadores.PoiAlreadyInRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PoiAlreadyInRouteValidator.class)
@Documented
public @interface PoiAlreadyInRoute {

    String message() default "Un punto de interés no puede estar dos veces en una misma ruta";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
