package com.practice.bmspractice.repositories;

import com.practice.bmspractice.models.MovieShow;
import com.practice.bmspractice.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<MovieShow,Long> {
    @Override
    Optional<MovieShow> findById(Long aLong);
}
