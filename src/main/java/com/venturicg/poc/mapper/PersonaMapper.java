package com.venturicg.poc.mapper;

import com.venturicg.poc.repository.entity.PersonaEntity;
import com.venturicg.poc.dto.PersonaDto;

public class PersonaMapper {

    public static PersonaDto toDto(PersonaEntity personaEntity) {
        if (personaEntity == null) {
            return null;
        }
        PersonaDto personaDto = new PersonaDto();
        personaDto.setNombre(personaEntity.getNombre());
        personaDto.setApellido(personaEntity.getApellido());
        // Utiliza PaisMapper para convertir PaisEntity a PaisDTO
        personaDto.setPais(PaisMapper.toDto(personaEntity.getPais()));
        return personaDto;
    }

    public static PersonaEntity toEntity(PersonaDto personaDto) {
        if (personaDto == null) {
            return null;
        }
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setNombre(personaDto.getNombre());
        personaEntity.setApellido(personaDto.getApellido());
        // Utiliza PaisMapper para convertir PaisDTO a PaisEntity
        personaEntity.setPais(PaisMapper.toEntity(personaDto.getPais()));
        return personaEntity;
    }
}
