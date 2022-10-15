package org.binar.service;

import org.binar.model.Studio;

import java.util.List;

public interface StudioService {
    public Studio addStudio(Studio studio);
    public List<Studio> addStudios(List<Studio> studios);
    public List<Studio> getAllStudio ();
    public void updateStudio(Studio studio, Long studioId);
    public void deleteStudio(Long studioId);
}
