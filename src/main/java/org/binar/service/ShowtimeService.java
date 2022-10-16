package org.binar.service;

import org.binar.model.Showtime;

import java.util.Date;
import java.util.List;

public interface ShowtimeService {
    public Showtime addShowtime (Showtime showtime);
    public List<Showtime> addManyShowtime (List<Showtime> manyShowtime);
    public List<Showtime> getFilmShowingToday();
    public List<Showtime> getAllShowtime();
    public List<Showtime> getFilmShowingAt(Date dateInput);
    public void updateShowtime(Long showtimeId, Showtime showtime);
    public void deleteShowtime(Long showtimeId);
}
