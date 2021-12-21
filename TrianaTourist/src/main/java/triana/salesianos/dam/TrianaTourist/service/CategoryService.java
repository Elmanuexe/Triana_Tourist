package triana.salesianos.dam.TrianaTourist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triana.salesianos.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import triana.salesianos.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.model.dto.CategoryDto;
import triana.salesianos.dam.TrianaTourist.model.dto.ConvertDto;
import triana.salesianos.dam.TrianaTourist.repository.CategoryRepository;
import triana.salesianos.dam.TrianaTourist.service.base.BaseService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService<Category, UUID, CategoryRepository> {

    public final ConvertDto convertDto;

    public Category save(CategoryDto dto) {
        return super.save(convertDto.convertDtoToCategory(dto));
    }

    public Category edit(UUID id, CategoryDto category){
        return findById(id).map(c -> {
            c.setName(category.getName());
            super.save(c);
            return c;
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class));
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return Optional.ofNullable(super.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Category.class)));
    }

    @Override
    public List<Category> findAll() {
        List<Category> result = super.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {
            return result;
        }
    }

    @Override
    public void deleteById(UUID id) {Optional<Category> result = findById(id);super.deleteById(id);}
}
