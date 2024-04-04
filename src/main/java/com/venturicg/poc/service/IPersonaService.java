package com.venturicg.poc.service;

import com.venturicg.poc.dto.PersonaDto;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    List<PersonaDto> listarPersonas();

    Optional<PersonaDto> obtenerPersonaPorId(Long id);

    PersonaDto guardarPersona(PersonaDto persona);

    void eliminarPersona(Long id);

    PersonaDto actualizarPersona(PersonaDto persona, Long id);
}
