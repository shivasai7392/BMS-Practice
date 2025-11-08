package com.practice.bmspractice.dtos;

import java.util.List;

public class BookTicketResponseDto {
    private Long ticketId;
    private int amount;
    private List<Integer> seatNumbers;
    private double totalAmount;
    private String ticketStatus;
    private String message;

}
