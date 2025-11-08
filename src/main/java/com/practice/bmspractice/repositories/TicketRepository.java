package com.practice.bmspractice.repositories;

import com.practice.bmspractice.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Override
    <S extends Ticket> S save(S entity);
}
