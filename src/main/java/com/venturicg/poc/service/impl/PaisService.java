package com.venturicg.poc.service.impl;


import com.venturicg.poc.dto.PaisDTO;
import com.venturicg.poc.mapper.PaisMapper;
import com.venturicg.poc.repository.persistence.PaisRepository;
import com.venturicg.poc.service.IPaisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisService implements IPaisService {


    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public List<PaisDTO> obtenerPaises() {
        return paisRepository.findAll().stream()
                .map(PaisMapper::toDto)
                .collect(Collectors.toList());
    }
}
