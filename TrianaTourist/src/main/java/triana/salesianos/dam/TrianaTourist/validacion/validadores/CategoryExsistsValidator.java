package triana.salesianos.dam.TrianaTourist.validacion.validadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.repository.CategoryRepository;
import triana.salesianos.dam.TrianaTourist.validacion.anotaciones.CategoryExists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryExsistsValidator implements ConstraintValidator<CategoryExists, String> {

    @Autowired
    private CategoryRepository repositorio;

    @Override
    public void initialize(CategoryExists constraintAnnotation) { }

    @Override
    public boolean isValid(String category, ConstraintValidatorContext context) {
        return StringUtils.hasText(category) && repositorio.existsByName(category);
    }
}
