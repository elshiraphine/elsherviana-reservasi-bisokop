package org.binar.service.impl;

import org.binar.model.Studio;
import org.binar.repository.StudioRepository;
import org.binar.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    StudioRepository studioRepository;
    @Override
    public Studio addStudio(Studio studio) {
        return studioRepository.save(studio);
    }

    @Override
    public List<Studio> addStudios(List<Studio> studios) {
        return studioRepository.saveAll(studios);
    }

    @Override
    public List<Studio> getAllStudio() {
        return studioRepository.findAll();
    }

    @Override
    public void updateStudio(Studio studio, Long studioId) {
        Studio studioById = studioRepository.findById(studioId).orElseThrow();
        studioById.setStudio_name(studio.getStudio_name());
        studioRepository.save(studioById);
    }

    @Override
    public void deleteStudio(Long studioId) {
        try {
            studioRepository.deleteById(studioId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
