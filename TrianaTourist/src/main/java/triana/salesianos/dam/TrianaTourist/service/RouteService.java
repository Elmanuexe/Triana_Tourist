package triana.salesianos.dam.TrianaTourist.service;

import org.springframework.stereotype.Service;
import triana.salesianos.dam.TrianaTourist.model.Route;
import triana.salesianos.dam.TrianaTourist.repository.RouteRepository;
import triana.salesianos.dam.TrianaTourist.service.base.BaseService;

import java.util.UUID;

@Service
public class RouteService extends BaseService<Route, UUID, RouteRepository> {
}
