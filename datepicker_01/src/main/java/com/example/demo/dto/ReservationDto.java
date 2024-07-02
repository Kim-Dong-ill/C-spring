package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.Entity.Reservation;

import lombok.Data;

@Data
public class ReservationDto {
	private int id;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public ReservationDto() {};
	
	public ReservationDto(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
	
	//entity화
	public Reservation toEntity() {
		return new Reservation(startDate,endDate);
	}
}
