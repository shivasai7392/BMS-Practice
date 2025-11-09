package com.practice.bmspractice.repositories;

import com.practice.bmspractice.models.MovieShow;
import com.practice.bmspractice.models.Seat;
import com.practice.bmspractice.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllBySeatInAndMovieShow(List<Seat> seats, MovieShow movieShow);

    @Override
    <S extends ShowSeat> S save(S entity);
}
