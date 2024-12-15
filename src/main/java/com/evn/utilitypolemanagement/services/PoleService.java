package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.entities.Pole;

import java.util.List;
import java.util.Optional;

public interface PoleService {
    Pole create(Pole pole);
    Pole update(Integer id, Pole poleDetails);
    Optional<Pole> get(Integer id);
    List<Pole> getAll();
    void delete(Integer id);
}
