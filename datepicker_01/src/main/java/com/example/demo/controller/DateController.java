package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Reservation;
import com.example.demo.dao.ReservationRepository;
import com.example.demo.dto.ReservationDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:3000")
public class DateController {
	

	@Autowired
	private ReservationRepository reservationRepository;

	//데이터 리스트 보기
	@GetMapping("/reservations")
	   public ResponseEntity<List<Reservation>> getAllReservations(Model model) {
	       List<Reservation> result = reservationRepository.findAll();
	       return ResponseEntity.ok(result);
		}
	    
	//데이터 저장
	@PostMapping("/reservation")
	public ResponseEntity<Reservation> createReservation(
	 		@RequestBody ReservationDto dto,
	   		Model model
	   		) {
	   	
	   	log.info("요청 값 : "+dto);
	    	

	   	
	   	//dto를 entitiy로 변환
	   	Reservation entity=dto.toEntity();
	    	
	   	//저장
	    Reservation saveDate = reservationRepository.save(entity);
	        
	    return ResponseEntity.ok(saveDate);
	}
}
