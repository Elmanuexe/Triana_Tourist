package triana.salesianos.dam.TrianaTourist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.model.dto.CategoryDto;
import triana.salesianos.dam.TrianaTourist.model.dto.ConvertDto;
import triana.salesianos.dam.TrianaTourist.repository.CategoryRepository;
import triana.salesianos.dam.TrianaTourist.service.base.BaseService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService extends BaseService<Category, UUID, CategoryRepository> {

    public final ConvertDto convertDto;

    public Category save(CategoryDto dto) {
        return super.save(convertDto.convertDtoToCategory(dto));
    }

    @Override
    public Optional<Category> findById(UUID uuid) {
        return super.findById(uuid);
    }
}
