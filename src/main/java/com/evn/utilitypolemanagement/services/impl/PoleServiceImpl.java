package com.evn.utilitypolemanagement.services.impl;

import com.evn.utilitypolemanagement.entities.Pole;
import com.evn.utilitypolemanagement.exceptions.Pole.PoleNotFoundException;
import com.evn.utilitypolemanagement.repositories.PoleRepository;
import com.evn.utilitypolemanagement.services.PoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoleServiceImpl implements PoleService {
    private final PoleRepository poleRepository;

    public PoleServiceImpl(PoleRepository poleRepository) {
        this.poleRepository = poleRepository;
    }

    @Override
    public Pole createPole(Pole pole) {
        return poleRepository.save(pole);
    }

    @Override
    public Pole updatePole(Integer id, Pole poleDetails) {
        Pole pole = poleRepository.findById(id)
                .orElseThrow(() -> new PoleNotFoundException("Pole not found with id " + id));
        pole.setPoleName(poleDetails.getPoleName());
        pole.setStatus(poleDetails.getStatus());
        // No need to set created timestamp, as it is managed by Hibernate
        return poleRepository.save(pole);

    }

    @Override
    public Optional<Pole> getPoleById(Integer id) {
        return poleRepository.findById(id);
    }

    @Override
    public List<Pole> getAllPoles() {
        return poleRepository.findAll();
    }

    @Override
    public void deletePole(Integer id) {
        Pole pole = poleRepository.findById(id)
                .orElseThrow(() -> new PoleNotFoundException("Pole not found with id " + id));
        poleRepository.delete(pole);
    }
}
