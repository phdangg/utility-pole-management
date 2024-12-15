package com.evn.utilitypolemanagement.services.impl;

import com.evn.utilitypolemanagement.entities.Cable;
import com.evn.utilitypolemanagement.exceptions.Cable.CableNotFoundException;
import com.evn.utilitypolemanagement.repositories.CableRepository;
import com.evn.utilitypolemanagement.services.CableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CableServiceImpl implements CableService {

    private final CableRepository cableRepository;

    @Autowired
    public CableServiceImpl(CableRepository cableRepository) {
        this.cableRepository = cableRepository;
    }

    @Override
    public List<Cable> getAll() {
        return cableRepository.findAll();
    }

    @Override
    public Cable getById(Integer cableId) {
        return cableRepository.findById(cableId)
                .orElseThrow(()-> new CableNotFoundException("Cable not found with id " + cableId));
    }


    @Override
    public Cable create(Cable cable) {
        return cableRepository.save(cable);
    }

    @Override
    public Cable update(Integer cableId, Cable cableDetails) {
        return cableRepository.findById(cableId).map(cable -> {
            cable.setCableName(cableDetails.getCableName());
            cable.setQuantity(cableDetails.getQuantity());
            cable.setCableType(cableDetails.getCableType());
            cable.setIsCalculatedInBill(cableDetails.getIsCalculatedInBill());
            cable.setIsEnable(cableDetails.getIsEnable());
            return cableRepository.save(cable);
        }).orElseThrow(() -> new RuntimeException("Cable not found"));
    }

    @Override
    public void delete(Integer cableId) {
        cableRepository.deleteById(cableId);
    }
}
