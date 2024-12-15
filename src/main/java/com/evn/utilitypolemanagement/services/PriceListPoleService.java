package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.dto.PriceListPoleDTO;
import com.evn.utilitypolemanagement.entities.PriceListPole;

import java.util.List;

public interface PriceListPoleService {
    List<PriceListPole> getAll();
    PriceListPole get(PriceListPole.Id id);
    PriceListPole create(PriceListPoleDTO priceListPoleDTO);
    PriceListPole update(PriceListPoleDTO priceListPoleDTO);
    void delete(PriceListPole.Id id);
}
