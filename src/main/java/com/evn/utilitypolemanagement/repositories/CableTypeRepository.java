package com.evn.utilitypolemanagement.repositories;

import com.evn.utilitypolemanagement.entities.CableType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CableTypeRepository extends JpaRepository<CableType,Integer> {
    Optional<CableType> findByCableTypeName(String cableTypeName);
}
