package com.practice.bmspractice.repositories;

import com.practice.bmspractice.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Override
    List<Seat> findAllById(Iterable<Long> longs);
}
