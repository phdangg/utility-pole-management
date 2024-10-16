package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.dto.PriceListPoleDTO;
import com.evn.utilitypolemanagement.entities.PriceListPole;

import java.util.List;

public interface PriceListPoleService {
    List<PriceListPole> findAll();
    PriceListPole findById(PriceListPole.Id id);
    PriceListPole create(PriceListPoleDTO priceListPoleDTO);
    PriceListPole update(PriceListPoleDTO priceListPoleDTO);
    void deleteById(PriceListPole.Id id);
}
