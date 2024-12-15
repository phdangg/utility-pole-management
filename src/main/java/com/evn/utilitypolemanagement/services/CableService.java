package com.evn.utilitypolemanagement.services;

import com.evn.utilitypolemanagement.entities.Cable;

import java.util.List;

public interface CableService {
    List<Cable> getAll();
    Cable get(Integer cableId);
    Cable create(Cable cable);
    Cable update(Integer cableId, Cable cable);
    void delete(Integer cableId);
}
