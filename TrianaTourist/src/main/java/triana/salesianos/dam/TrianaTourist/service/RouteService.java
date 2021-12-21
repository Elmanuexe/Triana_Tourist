package triana.salesianos.dam.TrianaTourist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import triana.salesianos.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import triana.salesianos.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import triana.salesianos.dam.TrianaTourist.model.POI;
import triana.salesianos.dam.TrianaTourist.model.Route;
import triana.salesianos.dam.TrianaTourist.repository.POIRepository;
import triana.salesianos.dam.TrianaTourist.repository.RouteRepository;
import triana.salesianos.dam.TrianaTourist.service.base.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteService extends BaseService<Route, UUID, RouteRepository> {

    public final POIRepository poiRepository;

    public Route edit(UUID id, Route route){
        return findById(id).map(c -> {
            c.setName(route.getName());
            c.setSteps(route.getSteps());
            super.save(c);
            return c;
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class));
    }

    public Route agregarParada(UUID id, String nombre){
        Route ruta = findById(id).get();
        POI nuevo = poiRepository.findByName(nombre);
        ruta.getSteps().add(nuevo);
        return edit(ruta);
    }

    public Route borrarParada(UUID id, String nombre){
        Route ruta = findById(id).get();
        POI nuevo = poiRepository.findByName(nombre);
        ruta.getSteps().remove(nuevo);
        return edit(ruta);
    }

    @Override
    public Optional<Route> findById(UUID id){
        return Optional.ofNullable(super.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), Route.class)));
    }

    @Override
    public List<Route> findAll() {
        List<Route> result = super.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            return result;
        }
    }

    @Override
    public void deleteById(UUID id) {Optional<Route> result = findById(id);super.deleteById(id);}
}
