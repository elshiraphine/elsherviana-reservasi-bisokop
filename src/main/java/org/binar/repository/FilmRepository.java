package org.binar.repository;

import org.binar.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT f FROM Film f WHERE CURRENT_DATE >= f.startDate AND CURRENT_DATE <= f.endDate")
    List<Film> findAllShowingFilm();
}
