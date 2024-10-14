package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.entities.Pole;

import java.util.List;
import java.util.Optional;

public interface PoleService {
    Pole createPole(Pole pole);
    Pole updatePole(Integer id, Pole poleDetails);
    Optional<Pole> getPoleById(Integer id);
    List<Pole> getAllPoles();
    void deletePole(Integer id);
}
