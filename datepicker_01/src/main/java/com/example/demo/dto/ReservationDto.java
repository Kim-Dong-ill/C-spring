package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.Entity.Reservation;

import lombok.Data;

@Data
public class ReservationDto {
	private int id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public ReservationDto() {};
	
	public ReservationDto(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
	
	//entity화
	public Reservation toEntity() {
		return new Reservation(startDate,endDate);
	}
}
