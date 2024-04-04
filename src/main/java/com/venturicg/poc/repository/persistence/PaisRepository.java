package com.venturicg.poc.repository.persistence;

import com.venturicg.poc.repository.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, String> {

}
