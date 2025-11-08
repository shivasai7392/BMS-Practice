package com.practice.bmspractice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private List<Long> seatIds;
    private Long movieShowId;
    private Long userId;
}
