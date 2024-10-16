package com.evn.utilitypolemanagement.repositories;

import com.evn.utilitypolemanagement.entities.PriceListPole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceListPoleRepository extends JpaRepository<PriceListPole, PriceListPole.Id> {
}
