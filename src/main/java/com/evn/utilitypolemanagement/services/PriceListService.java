package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.entities.PriceList;

import java.util.List;

public interface PriceListService {
    PriceList create(PriceList priceList);
    PriceList update(Integer priceListId, PriceList priceList);
    List<PriceList> getAll();
    PriceList get(Integer priceListId);
    void delete(Integer priceListId);
}