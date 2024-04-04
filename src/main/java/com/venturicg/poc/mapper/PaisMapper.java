package com.venturicg.poc.mapper;


import com.venturicg.poc.dto.PaisDTO;
import com.venturicg.poc.repository.entity.PaisEntity;

public class PaisMapper {

    public static PaisDTO toDto(PaisEntity paisEntity) {
        if (paisEntity == null) {
            return null;
        }
        return new PaisDTO(paisEntity.getId(), paisEntity.getNombre());
    }

    public static PaisEntity toEntity(PaisDTO paisDTO) {
        if (paisDTO == null) {
            return null;
        }
        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setId(paisDTO.getId());
        paisEntity.setNombre(paisDTO.getNombre());
        return paisEntity;
    }
}
