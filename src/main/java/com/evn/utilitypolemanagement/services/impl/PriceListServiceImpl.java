package com.evn.utilitypolemanagement.services.impl;

import com.evn.utilitypolemanagement.entities.PriceList;
import com.evn.utilitypolemanagement.exceptions.PriceList.PriceListNotFoundException;
import com.evn.utilitypolemanagement.repositories.PriceListRepository;
import com.evn.utilitypolemanagement.services.PriceListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListServiceImpl implements PriceListService {

    private final PriceListRepository priceListRepository;

    public PriceListServiceImpl(PriceListRepository priceListRepository) {
        this.priceListRepository = priceListRepository;
    }


    @Override
    public PriceList createPriceList(PriceList priceList) {
        return priceListRepository.save(priceList);
    }

    @Override
    public PriceList updatePriceList(Integer priceListId, PriceList priceList) {
        PriceList existingPriceList =
                priceListRepository.findById(priceListId)
                        .orElseThrow(()-> new PriceListNotFoundException("PriceList with ID " + priceListId + " not found"));
        existingPriceList.setDescription(priceList.getDescription());
        existingPriceList.setStatus(priceList.getStatus());
        return priceListRepository.save(existingPriceList);
    }

    @Override
    public List<PriceList> getAllPriceLists() {
        return priceListRepository.findAll();
    }

    @Override
    public PriceList getPriceListById(Integer priceListId) {
        return priceListRepository.findById(priceListId)
                        .orElseThrow(()-> new PriceListNotFoundException("PriceList with ID " + priceListId + " not found"));
    }

    @Override
    public void deletePriceList(Integer priceListId) {
        priceListRepository.findById(priceListId)
                .orElseThrow(()-> new PriceListNotFoundException("PriceList with ID " + priceListId + " not found"));
        priceListRepository.deleteById(priceListId);
    }
}
