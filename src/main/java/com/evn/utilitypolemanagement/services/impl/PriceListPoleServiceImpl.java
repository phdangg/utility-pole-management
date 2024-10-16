package com.evn.utilitypolemanagement.services.impl;

import com.evn.utilitypolemanagement.dto.PriceListPoleDTO;
import com.evn.utilitypolemanagement.entities.Pole;
import com.evn.utilitypolemanagement.entities.PriceList;
import com.evn.utilitypolemanagement.entities.PriceListPole;
import com.evn.utilitypolemanagement.exceptions.Pole.PoleNotFoundException;
import com.evn.utilitypolemanagement.exceptions.PriceList.PriceListNotFoundException;
import com.evn.utilitypolemanagement.exceptions.PriceListPole.PriceListPoleNotFound;
import com.evn.utilitypolemanagement.repositories.PoleRepository;
import com.evn.utilitypolemanagement.repositories.PriceListPoleRepository;
import com.evn.utilitypolemanagement.repositories.PriceListRepository;
import com.evn.utilitypolemanagement.services.PriceListPoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceListPoleServiceImpl implements PriceListPoleService {

    private final PriceListPoleRepository priceListPoleRepository;
    private final PriceListRepository priceListRepository;
    private final PoleRepository poleRepository;

    @Autowired
    public PriceListPoleServiceImpl(PriceListPoleRepository priceListPoleRepository,
                                PriceListRepository priceListRepository,
                                PoleRepository poleRepository) {
        this.priceListPoleRepository = priceListPoleRepository;
        this.priceListRepository = priceListRepository;
        this.poleRepository = poleRepository;
    }

    public PriceListPole create(PriceListPoleDTO priceListPoleDTO) {
        PriceList priceList = priceListRepository.findById(priceListPoleDTO.getPriceListId())
                .orElseThrow(()-> new PriceListNotFoundException("PriceList not found with id " + priceListPoleDTO.getPriceListId()));
        Pole pole = poleRepository.findById(priceListPoleDTO.getPoleId())
                .orElseThrow(() -> new PoleNotFoundException("Pole not found with id " + priceListPoleDTO.getPoleId()));

        PriceListPole priceListPole = new PriceListPole(priceList, pole, priceListPoleDTO.getUnitPrice());
        return priceListPoleRepository.save(priceListPole);
    }

    @Override
    public PriceListPole update(PriceListPoleDTO priceListPoleDTO) {
        PriceListPole.Id id = new PriceListPole.Id(priceListPoleDTO.getPriceListId(), priceListPoleDTO.getPoleId());
        PriceListPole existingPriceListPole = priceListPoleRepository.findById(id)
                .orElseThrow(() -> new PriceListPoleNotFound("PriceListPole not found"));

        existingPriceListPole.setUnitPrice(priceListPoleDTO.getUnitPrice());

        return priceListPoleRepository.save(existingPriceListPole);
    }

    @Override
    public List<PriceListPole> findAll() {
        return priceListPoleRepository.findAll();
    }

    @Override
    public PriceListPole findById(PriceListPole.Id id) {
        return priceListPoleRepository.findById(id)
                .orElseThrow(() -> new PriceListPoleNotFound("PriceListPole not found"));
    }


    @Override
    public void deleteById(PriceListPole.Id id) {
        PriceListPole existingPriceListPole = priceListPoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("PriceListPole not found"));

        priceListPoleRepository.delete(existingPriceListPole);
    }
}
