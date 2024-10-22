package com.evn.utilitypolemanagement.controller;

import com.evn.utilitypolemanagement.entities.CableType;
import com.evn.utilitypolemanagement.services.CableTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cable-types")
public class CableTypeController {
    private final CableTypeService cableTypeService;

    public CableTypeController(CableTypeService cableTypeService) {
        this.cableTypeService = cableTypeService;
    }

    @GetMapping
    public ResponseEntity<List<CableType>> getAllCableTypes() {
        List<CableType> CableTypes = cableTypeService.getAllCableTypes();
        return ResponseEntity.ok(CableTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CableType> getCableTypeById(@PathVariable Integer id) {
        return ResponseEntity.ok(cableTypeService.getCableTypeById(id));
    }

    @PostMapping
    public ResponseEntity<CableType> createCableType(@RequestBody CableType CableType) {
        CableType createdCableType = cableTypeService.createCableType(CableType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCableType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CableType> updateCableType(@PathVariable Integer id, @RequestBody CableType CableTypeDetails) {
        CableType updatedCableType = cableTypeService.updateCableType(id, CableTypeDetails);
        return ResponseEntity.ok(updatedCableType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCableType(@PathVariable Integer id) {
        cableTypeService.deleteCableType(id);
        return ResponseEntity.noContent().build();
    }
}
