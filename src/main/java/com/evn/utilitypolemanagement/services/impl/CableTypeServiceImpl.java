package com.evn.utilitypolemanagement.services.impl;

import com.evn.utilitypolemanagement.entities.CableType;
import com.evn.utilitypolemanagement.exceptions.CapleType.CableTypeAlreadyExistsException;
import com.evn.utilitypolemanagement.exceptions.CapleType.CableTypeNotFoundException;
import com.evn.utilitypolemanagement.repositories.CableTypeRepository;
import com.evn.utilitypolemanagement.services.CableTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CableTypeServiceImpl implements CableTypeService {
    private final CableTypeRepository cableTypeRepository;

    public CableTypeServiceImpl(CableTypeRepository cableTypeRepository) {
        this.cableTypeRepository = cableTypeRepository;
    }

    @Override
    public CableType createCableType(CableType cableType) {
        if (cableTypeRepository.findByCableTypeName(cableType.getCableTypeName()).isPresent())
            throw new CableTypeAlreadyExistsException("Cable type with name already exist");
        return cableTypeRepository.save(cableType);
    }

    @Override
    public CableType updateCableType(Integer cableTypeId, CableType cableType) {
        CableType existingCableType = cableTypeRepository.findById(cableTypeId)
                .orElseThrow(() -> new CableTypeNotFoundException("Not found cable with id " + cableTypeId));

        // Check if the name is changing and if the new name already exists
        if (!existingCableType.getCableTypeName().equalsIgnoreCase(cableType.getCableTypeName()) &&
                cableTypeRepository.findByCableTypeName(cableType.getCableTypeName()).isPresent()) {
            throw new CableTypeAlreadyExistsException("Cable type with name already exists");
        }

        existingCableType.setCableTypeName(cableType.getCableTypeName());

        return cableTypeRepository.save(existingCableType);
    }

    @Override
    public List<CableType> getAllCableTypes() {
        return cableTypeRepository.findAll();
    }

    @Override
    public CableType getCableTypeById(Integer cableTypeId) {
        return cableTypeRepository.findById(cableTypeId)
                .orElseThrow(()->new CableTypeNotFoundException("Not found cable with id " + cableTypeId));
    }

    @Override
    public void deleteCableType(Integer cableTypeId) {
        CableType cableType = cableTypeRepository.findById(cableTypeId)
                .orElseThrow(()->new CableTypeNotFoundException("Not found cable with id " + cableTypeId));
        cableTypeRepository.delete(cableType);
    }
}
