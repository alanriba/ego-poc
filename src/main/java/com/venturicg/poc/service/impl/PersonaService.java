package com.venturicg.poc.service.impl;

import com.venturicg.poc.dto.PersonaDto;
import com.venturicg.poc.mapper.PersonaMapper;
import com.venturicg.poc.repository.entity.PersonaEntity;
import com.venturicg.poc.repository.persistence.PersonaRepository;
import com.venturicg.poc.service.IPersonaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<PersonaDto> listarPersonas() {
        return personaRepository.findAll().stream()
                .map(PersonaMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PersonaDto> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id)
                .map(PersonaMapper::toDto);
    }


    public PersonaDto guardarPersona(PersonaDto personaDto) {
        PersonaEntity personaEntity = PersonaMapper.toEntity(personaDto);
        PersonaEntity savedEntity = personaRepository.save(personaEntity);
        return PersonaMapper.toDto(savedEntity);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    public PersonaDto actualizarPersona(PersonaDto personaDto, Long id) {
        PersonaEntity personaEntity = PersonaMapper.toEntity(personaDto);
        personaEntity.setId(id);
        PersonaEntity updatedEntity = personaRepository.save(personaEntity);
        return PersonaMapper.toDto(updatedEntity);
    }
}
