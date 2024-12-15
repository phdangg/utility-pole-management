package com.evn.utilitypolemanagement.controller;

import com.evn.utilitypolemanagement.entities.Pole;
import com.evn.utilitypolemanagement.services.PoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poles")
public class PoleController {
    private final PoleService poleService;

    public PoleController(PoleService poleService) {
        this.poleService = poleService;
    }

    @GetMapping
    public ResponseEntity<List<Pole>> getAllPoles() {
        List<Pole> poles = poleService.getAll();
        return ResponseEntity.ok(poles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pole> getPoleById(@PathVariable Integer id) {
        return poleService.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pole> createPole(@RequestBody Pole pole) {
        Pole createdPole = poleService.create(pole);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pole> updatePole(@PathVariable Integer id, @RequestBody Pole poleDetails) {
        Pole updatedPole = poleService.update(id, poleDetails);
        return ResponseEntity.ok(updatedPole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePole(@PathVariable Integer id) {
        poleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
