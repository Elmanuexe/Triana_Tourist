package triana.salesianos.dam.TrianaTourist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.model.POI;
import triana.salesianos.dam.TrianaTourist.model.dto.CategoryDto;
import triana.salesianos.dam.TrianaTourist.model.dto.POIDto;
import triana.salesianos.dam.TrianaTourist.service.POIService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class PoiController {

    private final POIService service;

    @GetMapping("/")
    public ResponseEntity<List<POI>> todas (){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<POI> una(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id).get());
    }

    @PostMapping("/")
    public ResponseEntity<POI> nueva(@Valid @RequestBody POIDto poi){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(poi));
    }

    @PutMapping("/{id}")
    public ResponseEntity<POI> edit(@Valid @PathVariable UUID id, @RequestBody POIDto poi){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.edit(id, poi));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<POI> borrar(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
