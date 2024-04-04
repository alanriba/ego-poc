package com.venturicg.poc.controller.rest;

import com.venturicg.poc.dto.PaisDTO;

import com.venturicg.poc.service.impl.PaisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
    private final PaisService paisesService;
    public PaisController(PaisService paisesService) {
        this.paisesService = paisesService;
    }


  /*  @Operation(summary= "Obtiene la lista de países",
            description = "Retorna una lista de todos los países")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Lista recuperada exitosamente",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PaisDTO.class))),
            @ApiResponse(responseCode = "500",
                    description = "Error interno del servidor")
    })*/
    @GetMapping("")
    public ResponseEntity<List<PaisDTO>> obtenerPaises() {
        return new ResponseEntity<>(paisesService.obtenerPaises().stream()
                .map(pais -> new PaisDTO(pais.getId(), pais.getNombre()))
                .collect(Collectors.toList()), HttpStatus.OK);
    }



}
