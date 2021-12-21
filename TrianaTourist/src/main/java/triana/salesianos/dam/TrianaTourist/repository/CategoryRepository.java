package triana.salesianos.dam.TrianaTourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import triana.salesianos.dam.TrianaTourist.model.Category;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    boolean existsByName(String nombre);

    Category findByName(String nombre);
}
