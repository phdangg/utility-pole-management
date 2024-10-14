package com.evn.utilitypolemanagement.repositories;

import com.evn.utilitypolemanagement.entities.Pole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PoleRepository extends JpaRepository<Pole,Integer> {
    Optional<Pole> findByPoleNameOrPoleShortName(String poleName, String poleShortName);
}
