package com.evn.utilitypolemanagement.controller;

import com.evn.utilitypolemanagement.dto.PriceListPoleDTO;
import com.evn.utilitypolemanagement.entities.PriceListPole;
import com.evn.utilitypolemanagement.services.PriceListPoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricelist-poles")
public class PriceListPoleController {

    private final PriceListPoleService priceListPoleService;

    public PriceListPoleController(PriceListPoleService priceListPoleService) {
        this.priceListPoleService = priceListPoleService;
    }

    @GetMapping
    public List<PriceListPole> getAllPriceListPoles() {
        return priceListPoleService.getAll();
    }

    @GetMapping("/{priceListId}/{poleId}")
    public ResponseEntity<PriceListPole> getPriceListPoleById(@PathVariable Integer priceListId, @PathVariable Integer poleId) {
        PriceListPole.Id id = new PriceListPole.Id(priceListId, poleId);
        PriceListPole priceListPole = priceListPoleService.get(id);
        return ResponseEntity.ok(priceListPole);
    }

    @PostMapping
    public ResponseEntity<PriceListPole> createPriceListPole(@RequestBody PriceListPoleDTO priceListPoleDTO) {
        PriceListPole createdPriceListPole = priceListPoleService.create(priceListPoleDTO);
        return ResponseEntity.ok(createdPriceListPole);
    }

    @PutMapping
    public ResponseEntity<PriceListPole> updatePriceListPole(@RequestBody PriceListPoleDTO priceListPoleDTO) {
        PriceListPole updatedPriceListPole = priceListPoleService.update(priceListPoleDTO);
        return ResponseEntity.ok(updatedPriceListPole);
    }

    @DeleteMapping("/{priceListId}/{poleId}")
    public ResponseEntity<Void> deletePriceListPole(@PathVariable Integer priceListId, @PathVariable Integer poleId) {
        PriceListPole.Id id = new PriceListPole.Id(priceListId, poleId);
        priceListPoleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
