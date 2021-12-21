package triana.salesianos.dam.TrianaTourist.validacion.anotaciones;

import triana.salesianos.dam.TrianaTourist.validacion.validadores.CategoryExsistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CategoryExsistsValidator.class)
@Documented
public @interface CategoryExists {

    String message() default "La categoría de un punto de interés debe de existir";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
