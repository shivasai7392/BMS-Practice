package com.practice.bmspractice.controllers;

import com.practice.bmspractice.dtos.BookTicketRequestDto;
import com.practice.bmspractice.dtos.BookTicketResponseDto;
import com.practice.bmspractice.service.TicketService;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        this.ticketService.bookTicket(bookTicketRequestDto.getMovieShowId(), bookTicketRequestDto.getUserId(), bookTicketRequestDto.getSeatIds());

        return new BookTicketResponseDto();
    }
}
