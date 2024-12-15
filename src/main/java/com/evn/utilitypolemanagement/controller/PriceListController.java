package com.evn.utilitypolemanagement.controller;

import com.evn.utilitypolemanagement.entities.PriceList;
import com.evn.utilitypolemanagement.services.PriceListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricelists")
public class PriceListController {

    private final PriceListService priceListService;

    public PriceListController(PriceListService priceListService) {
        this.priceListService = priceListService;
    }

    @PostMapping
    public ResponseEntity<PriceList> createPriceList(@RequestBody PriceList priceList) {
        PriceList newPriceList = priceListService.create(priceList);
        return new ResponseEntity<>(newPriceList, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceList> updatePriceList(
            @PathVariable("id") Integer priceListId,
            @RequestBody PriceList priceList) {
        PriceList updatedPriceList = priceListService.update(priceListId, priceList);
        return new ResponseEntity<>(updatedPriceList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PriceList>> getAllPriceLists() {
        List<PriceList> priceLists = priceListService.getAll();
        return new ResponseEntity<>(priceLists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceList> getPriceListById(@PathVariable("id") Integer priceListId) {
        PriceList priceList = priceListService.get(priceListId);
        return ResponseEntity.ok(priceList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriceList(@PathVariable("id") Integer priceListId) {
        priceListService.delete(priceListId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
