package triana.salesianos.dam.TrianaTourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import triana.salesianos.dam.TrianaTourist.model.POI;
import triana.salesianos.dam.TrianaTourist.model.Route;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {

    boolean existsByName(String nombre);

    boolean StepsContains(POI poi);
}
