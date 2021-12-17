package triana.salesianos.dam.TrianaTourist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import triana.salesianos.dam.TrianaTourist.model.POI;

import java.util.UUID;

public interface POIRepository extends JpaRepository<POI, UUID> {
}
