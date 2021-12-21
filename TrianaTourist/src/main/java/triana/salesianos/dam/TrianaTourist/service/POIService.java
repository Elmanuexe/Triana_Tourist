package triana.salesianos.dam.TrianaTourist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import triana.salesianos.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import triana.salesianos.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.model.POI;
import triana.salesianos.dam.TrianaTourist.model.dto.ConvertDto;
import triana.salesianos.dam.TrianaTourist.model.dto.POIDto;
import triana.salesianos.dam.TrianaTourist.repository.POIRepository;
import triana.salesianos.dam.TrianaTourist.service.base.BaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class POIService extends BaseService<POI, UUID, POIRepository> {

    public final ConvertDto convertDto;

    public POI save(POIDto dto){return super.save(convertDto.convertDtoToPOI(dto));}

    public POI edit(UUID id, POIDto dto){
        return findById(id).map(c -> {
            c.setName(dto.getName());
            super.save(c);
            return c;
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }

    @Override
    public Optional<POI> findById(UUID id) {
        return Optional.ofNullable(super.findById(id).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class)));
    }

    @Override
    public List<POI> findAll() {
        List<POI> result = super.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            return result;
        }
    }

    @Override
    public void deleteById(UUID id) {Optional<POI> result = findById(id);super.deleteById(id);}

}
