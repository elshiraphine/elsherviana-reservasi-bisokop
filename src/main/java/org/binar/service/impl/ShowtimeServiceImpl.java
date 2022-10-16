package org.binar.service.impl;

import org.binar.model.Showtime;
import org.binar.repository.ShowtimeRepository;
import org.binar.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    @Autowired
    ShowtimeRepository showtimeRepository;

    @Override
    public Showtime addShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public List<Showtime> addManyShowtime(List<Showtime> manyShowtime) {
        return showtimeRepository.saveAll(manyShowtime);
    }

    @Override
    public List<Showtime> getFilmShowingToday() {
        return showtimeRepository.findAllShowingToday();
    }

    @Override
    public List<Showtime> getAllShowtime() {
        return showtimeRepository.findAllShowing();
    }

    @Override
    public List<Showtime> getFilmShowingAt(Date dateInput) {
        return showtimeRepository.findAllShowingAt(dateInput);
    }

    @Override
    public void updateShowtime(Long showtimeId, Showtime showtime) {
        Showtime showtimeById = showtimeRepository.findById(showtimeId).orElseThrow();
        showtimeById.setShowtime(showtime.getShowtime());
        showtimeById.setPrice(showtime.getPrice());
        showtimeById.setFilm(showtime.getFilm());
        showtimeById.setSchedule(showtime.getSchedule());
        showtimeById.setStudio(showtime.getStudio());
        showtimeRepository.save(showtimeById);
    }

    @Override
    public void deleteShowtime(Long showtimeId) {
        try {
            showtimeRepository.deleteById(showtimeId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
