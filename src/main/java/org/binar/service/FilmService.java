package org.binar.service;

import org.binar.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    public Film addFilm (Film film);
    public List<Film> addFilms(List<Film> films);
    public Optional<Film> getFilmById(Long id);
    public List<Film> getAllFilm();
    public List<Film> filmShowing();
    public void updateFilm(Film film, Long filmId);
    public void deleteFilm(Long filmId);
}
