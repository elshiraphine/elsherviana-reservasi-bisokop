package org.binar.repository;

import org.binar.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    @Query("SELECT s FROM Film f, Showtime s WHERE s.showtime >= f.startDate AND s.showtime <= f.endDate")
    List<Showtime> findAllShowing();

    @Query("SELECT s FROM Showtime s WHERE s.showtime = CURRENT_DATE")
    List<Showtime> findAllShowingToday();

    @Query("SELECT s FROM Showtime s WHERE s.showtime = ?1")
    List<Showtime> findAllShowingAt(Date dateInput);
}
