package org.binar.controller;

import org.binar.model.Studio;
import org.binar.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/studio", produces = {"application/json"})
public class StudioController {
    @Autowired
    StudioService studioService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Studio createStudio (@RequestBody Studio studio) {
        return studioService.addStudio(studio);
    }

    @PostMapping("/createbulk")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Studio> createStudios (@RequestBody List<Studio> studios) {
        return studioService.addStudios(studios);
    }

    @GetMapping("/getall")
    public List<Studio> getAll() {
        return studioService.getAllStudio();
    }

    @PutMapping("/update/{id}")
    public String updateStudio(@PathVariable Long id, @RequestBody Studio studio) {
        studioService.updateStudio(studio, id);
        return "Studio with id " + id + " updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        studioService.deleteStudio(id);
        return "Studio with id " + id + " deleted";
    }
}
