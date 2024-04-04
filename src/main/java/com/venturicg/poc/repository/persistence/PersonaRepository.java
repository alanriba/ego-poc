package com.venturicg.poc.repository.persistence;

import com.venturicg.poc.repository.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
