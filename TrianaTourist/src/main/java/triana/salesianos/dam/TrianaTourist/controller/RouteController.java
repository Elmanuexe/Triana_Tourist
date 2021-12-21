package triana.salesianos.dam.TrianaTourist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import triana.salesianos.dam.TrianaTourist.model.Route;
import triana.salesianos.dam.TrianaTourist.service.RouteService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ruta")
public class RouteController {

    private final RouteService service;

    @GetMapping("/")
    public ResponseEntity<List<Route>> todas (){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> una(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id).get());
    }

    @PostMapping("/")
    public ResponseEntity<Route> nueva(@Valid @RequestBody Route route){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(route));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> edit(@Valid @PathVariable UUID id, @RequestBody Route route){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.edit(id, route));
    }

    @PutMapping("/{id}/agregar")
    public ResponseEntity<Route> agregarPoi(@PathVariable UUID id, @RequestBody String nombre){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.agregarParada(id, nombre));
    }

    @PutMapping("/{id}/borrar")
    public ResponseEntity<Route> borrarPoi(@PathVariable UUID id, @RequestBody String nombre){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.borrarParada(id, nombre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Route> borrar(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
