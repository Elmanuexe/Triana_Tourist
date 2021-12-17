package triana.salesianos.dam.TrianaTourist.service;

import org.springframework.stereotype.Service;
import triana.salesianos.dam.TrianaTourist.model.POI;
import triana.salesianos.dam.TrianaTourist.repository.POIRepository;
import triana.salesianos.dam.TrianaTourist.service.base.BaseService;

import java.util.UUID;

@Service
public class POIService extends BaseService<POI, UUID, POIRepository> {
}
