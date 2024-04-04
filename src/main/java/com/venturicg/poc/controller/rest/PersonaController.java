package com.venturicg.poc.controller.rest;

import com.venturicg.poc.dto.PersonaDto;
import com.venturicg.poc.service.impl.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<PersonaDto>> listarPersonas() {
        List<PersonaDto> personas = personaService.listarPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> obtenerPersonaPorId(@PathVariable Long id) {
        Optional<PersonaDto> personaDto = personaService.obtenerPersonaPorId(id);
        return personaDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<PersonaDto> guardarPersona(@RequestBody PersonaDto personaDto) {
        PersonaDto personaGuardada = personaService.guardarPersona(personaDto);
        return new ResponseEntity<>(personaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDto> actualizarPersona(@PathVariable Long id, @RequestBody PersonaDto personaDto) {
        PersonaDto personaActualizada = personaService.actualizarPersona(personaDto, id);
        return ResponseEntity.ok(personaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}

