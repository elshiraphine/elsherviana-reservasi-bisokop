package org.binar.service.impl;

import org.binar.model.Film;
import org.binar.repository.FilmRepository;
import org.binar.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;
    @Override
    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> addFilms(List<Film> films) {
        return filmRepository.saveAll(films);
    }

    @Override
    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    @Override
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    @Override
    public List<Film> filmShowing() {
        return filmRepository.findAllShowingFilm();
    }

    @Override
    public void updateFilm(Film film, Long filmId) {
        Film filmById = filmRepository.findById(filmId).orElseThrow();
        filmById.setFilm_name(film.getFilm_name());
        filmById.setStartDate(film.getStartDate());
        filmById.setEndDate(film.getEndDate());
        filmRepository.save(filmById);
    }

    @Override
    public void deleteFilm(Long filmId) {
        try {
            filmRepository.deleteById(filmId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
