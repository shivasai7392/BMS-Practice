package com.practice.bmspractice.service;

import com.practice.bmspractice.exceptions.InvalidArgumentException;
import com.practice.bmspractice.exceptions.SeatUnAvailableException;
import com.practice.bmspractice.models.*;
import com.practice.bmspractice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    public final ShowSeatRepository showSeatRepository;
    public final SeatRepository seatRepository;
    public final ShowRepository showRepository;
    public final TicketRepository ticketRepository;
    public final UserRepository userRepository;

    @Autowired
    public TicketService(ShowSeatRepository showSeatRepository,
                         SeatRepository seatRepository,
                         ShowRepository showRepository,
                         TicketRepository ticketRepository,
                         UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public Ticket bookTicket(Long showId, Long userId, List<Long> seatIds) throws InvalidArgumentException, SeatUnAvailableException {
        // Logic to book ticket
        // Get the showseats
        List<Seat> seats = seatRepository.findAllById(seatIds);
        Optional<MovieShow> movieShow = showRepository.findById(showId);
        if (movieShow.isEmpty()) {
            throw new InvalidArgumentException("Invalid show ID");
        }
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, movieShow.get());
        double totalPrice = 0.0;
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new InvalidArgumentException("Invalid user ID");
        }

        // check for availability
        //1. if available, mark them locked/reserved
        //1.1 create ticket object
        //2.if not available, throw exception
        for (ShowSeat showSeat : showSeats) {
            if (showSeat.getSeatStatus() != SeatStatus.AVAILABLE) {
                throw new SeatUnAvailableException("Some of the seats selected are not available");
            }

        }
        for (ShowSeat showSeat : showSeats) {
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
            showSeatRepository.save(showSeat);

        }
        Ticket ticket = new Ticket();
        ticket.setSeats(seats);
        ticket.setStatus(TicketStatus.PENDING);
        ticket.setMovieShow(movieShow.get());
        ticket.setBookingTime(Date.from(new Date().toInstant()));
        ticket.setPrice(totalPrice);
        ticket.setUser(optionalUser.get());

        return ticketRepository.save(ticket);
    }
}
