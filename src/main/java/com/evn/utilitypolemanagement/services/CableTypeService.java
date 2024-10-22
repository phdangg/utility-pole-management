package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.entities.CableType;

import java.util.List;
import java.util.Optional;

public interface CableTypeService {
    CableType createCableType(CableType cableType);
    CableType updateCableType(Integer cableTypeId, CableType cableType);
    List<CableType> getAllCableTypes();
    CableType getCableTypeById(Integer cableTypeId);
    void deleteCableType(Integer cableTypeId);
}
