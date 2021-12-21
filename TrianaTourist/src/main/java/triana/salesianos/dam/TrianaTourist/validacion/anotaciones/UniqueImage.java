package triana.salesianos.dam.TrianaTourist.validacion.anotaciones;

import triana.salesianos.dam.TrianaTourist.validacion.validadores.UniqueImageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueImageValidator.class)
@Documented
public @interface UniqueImage {

    String message() default "Cada imagen de el punto de interés debe de ser única";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
