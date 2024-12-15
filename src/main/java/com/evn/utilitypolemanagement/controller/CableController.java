package com.evn.utilitypolemanagement.controller;

import com.evn.utilitypolemanagement.entities.Cable;
import com.evn.utilitypolemanagement.services.CableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cables")
public class CableController {
    private final CableService cableService;

    public CableController(CableService cableService) {
        this.cableService = cableService;
    }

    @GetMapping
    public ResponseEntity<List<Cable>> getAllCableTypes() {
        List<Cable> CableTypes = cableService.getAll();
        return ResponseEntity.ok(CableTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cable> getCableTypeById(@PathVariable Integer id) {
        return ResponseEntity.ok(cableService.get(id));
    }

    @PostMapping
    public ResponseEntity<Cable> createCableType(@RequestBody Cable CableType) {
        Cable createdCableType = cableService.create(CableType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCableType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cable> updateCableType(@PathVariable Integer id, @RequestBody Cable CableTypeDetails) {
        Cable updatedCableType = cableService.update(id, CableTypeDetails);
        return ResponseEntity.ok(updatedCableType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCableType(@PathVariable Integer id) {
        cableService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
