package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.entities.CableType;

import java.util.List;

public interface CableTypeService {
    CableType create(CableType cableType);
    CableType update(Integer cableTypeId, CableType cableType);
    List<CableType> getAll();
    CableType get(Integer cableTypeId);
    void delete(Integer cableTypeId);
}
