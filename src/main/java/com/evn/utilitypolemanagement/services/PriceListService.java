package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.entities.PriceList;

import java.util.List;

public interface PriceListService {
    PriceList createPriceList(PriceList priceList);
    PriceList updatePriceList(Integer priceListId, PriceList priceList);
    List<PriceList> getAllPriceLists();
    PriceList getPriceListById(Integer priceListId);
    void deletePriceList(Integer priceListId);
}