package com.evn.utilitypolemanagement.repositories;

import com.evn.utilitypolemanagement.entities.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceListRepository extends JpaRepository<PriceList,Integer> {
}
