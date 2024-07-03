package com.example.demo.controller;


import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
	    
	   	LocalDateTime startDate = dto.getStartDate();
        LocalDateTime endDate = dto.getEndDate();
        
        //예약 불가능한 날짜일때 ↓↓↓↓↓
        // 예약 가능 여부 확인(예약 불가시 Reservation형으로 메세지 포함해서 반환 필요)
        if (isReservation(startDate, endDate)) {
        	log.error("예약불가");
        	Reservation faleReservation = new Reservation();
        	faleReservation.setStartDate(startDate);
        	faleReservation.setEndDate(endDate);
        	faleReservation.setMessage("선택한 날짜 범위에 이미 예약된 날짜가 포함되어 있습니다.");
        	return ResponseEntity.ok().body(faleReservation);
        }
        
	   	//예약 가능한 날짜일때 ↓↓↓↓
	   	//dto를 entitiy로 변환
	   	Reservation entity=dto.toEntity();
	    	
	   	//저장
	    Reservation saveDate = reservationRepository.save(entity);
	        
	    return ResponseEntity.ok(saveDate);
	}
	
	//예약 가능일 확인
	private boolean isReservation(LocalDateTime start, LocalDateTime end) {
        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(start, end);
        return !overlappingReservations.isEmpty();
    }
}
