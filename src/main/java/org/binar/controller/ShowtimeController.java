package org.binar.controller;

import org.binar.model.Showtime;
import org.binar.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/showtime", produces = {"application/json"})
public class ShowtimeController {
    @Autowired
    ShowtimeService showtimeService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Showtime addShowtime(@RequestBody Showtime showtime) {
        return showtimeService.addShowtime(showtime);
    }

    @PostMapping("/createbulk")
    public List<Showtime> addManyShowtime(@RequestBody List<Showtime> manyShowtime) {
        return showtimeService.addManyShowtime(manyShowtime);
    }

    @GetMapping("/showtoday")
    public List<Showtime> getFilmShowingToday() {
        return showtimeService.getFilmShowingToday();
    }

    @GetMapping("/getall")
    public List<Showtime> getShowtime() {
        return showtimeService.getAllShowtime();
    }

    @PutMapping("/update/{id}")
    public String updateShowtime(@PathVariable Long id, @RequestBody Showtime showtime) {
        showtimeService.updateShowtime(id, showtime);
        return "Showtime with id " + id + " updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return "Showtime with id " + id + " deleted";
    }
}
