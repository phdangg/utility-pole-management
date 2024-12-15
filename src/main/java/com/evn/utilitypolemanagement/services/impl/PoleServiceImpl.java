package com.evn.utilitypolemanagement.services.impl;

import com.evn.utilitypolemanagement.entities.Pole;
import com.evn.utilitypolemanagement.exceptions.Pole.PoleAlreadyExistsException;
import com.evn.utilitypolemanagement.exceptions.Pole.PoleNotFoundException;
import com.evn.utilitypolemanagement.repositories.PoleRepository;
import com.evn.utilitypolemanagement.services.PoleService;
import org.springframework.dao.DataIntegrityViolationException;
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
    public Pole create(Pole pole) {
        try {
            return poleRepository.save(pole);
        }
        catch (DataIntegrityViolationException ex) {
            if (isUniqueNameInDatabase(pole)) {
                throw new PoleAlreadyExistsException("Already exist pole with the name " + pole.getPoleName());
            }
            if (isUniqueShortNameInDatabase(pole)) {
                throw new PoleAlreadyExistsException("Already exist pole with the short name " + pole.getPoleShortName());
            }
            throw ex;
        }
    }

    @Override
    public Pole update(Integer id, Pole poleDetails) {
        Pole existingPole = poleRepository.findById(id)
                .orElseThrow(() -> new PoleNotFoundException("Pole not found with id " + id));

        existingPole.setPoleName(poleDetails.getPoleName());
        existingPole.setPoleShortName(poleDetails.getPoleShortName());
        existingPole.setIsEnable(poleDetails.getIsEnable());
        try {
            return poleRepository.save(existingPole);
        }
        catch (DataIntegrityViolationException ex) {
            if (isUniqueNameInDatabase(existingPole)) {
                throw new PoleAlreadyExistsException("Already exist pole with the name " + existingPole.getPoleName());
            }
            if (isUniqueShortNameInDatabase(existingPole)) {
                throw new PoleAlreadyExistsException("Already exist pole with the short name " + existingPole.getPoleShortName());
            }
            throw ex;
        }

    }

    @Override
    public Optional<Pole> get(Integer id) {
        return poleRepository.findById(id);
    }

    @Override
    public List<Pole> getAll() {
        return poleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Pole pole = poleRepository.findById(id)
                .orElseThrow(() -> new PoleNotFoundException("Pole not found with id " + id));
        poleRepository.delete(pole);
    }
    private boolean isUniqueNameInDatabase(Pole pole) {
        return poleRepository.findByPoleName(pole.getPoleName()).isPresent();
    }
    private boolean isUniqueShortNameInDatabase(Pole pole) {
        return poleRepository.findByPoleShortName(pole.getPoleShortName()).isPresent();
    }
}
