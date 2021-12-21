package triana.salesianos.dam.TrianaTourist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import triana.salesianos.dam.TrianaTourist.model.Category;
import triana.salesianos.dam.TrianaTourist.model.dto.CategoryDto;
import triana.salesianos.dam.TrianaTourist.service.CategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/")
    public ResponseEntity<List<Category>> todas (){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> una(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id).get());
    }

    @PostMapping("/")
    public ResponseEntity<Category> nueva(@Valid @RequestBody CategoryDto category){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> edit(@Valid @PathVariable UUID id, @RequestBody CategoryDto category){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.edit(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> borrar(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
