package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Reservation;
import com.example.demo.Entity.TestEntity;
import com.example.demo.dao.ReservationRepository;
import com.example.demo.dao.TestRepository;
import com.example.demo.dto.ReservationDto;
import com.example.demo.dto.TestDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:3000")
public class MyController {
	
	
	    @Autowired
	    private ReservationRepository reservationRepository;
	    
	    @Autowired
	    private TestRepository repo;
	    
	    @GetMapping("/test")
	    public ResponseEntity<Object> testview(@RequestParam("id") Long id, Model model) {
	    	
//	    	List<TestEntity> entity = repo.findAll();
	    	
	    	TestEntity entity = repo.findById(id).orElse(null);
	   
	    	 if (entity == null) {
	             return ResponseEntity.notFound().build();
	         }
	   
	    	log.info("entity = "+entity);
	    	log.info("id : "+entity.getId());
	    	log.info("title : "+entity.getTitle());
	    	log.info("content : "+entity.getContent());
	    	
	    	return ResponseEntity.ok(entity);
	    }
	    
	    //
	    //
	    //
	    //
	    //
	    //
	    //
	    //
	    //
	    //
	    //
//	    @GetMapping("/api/reservations")
//	    public String getAllReservations(Model model) {
//	        List<Reservation> result = reservationRepository.findAll();
//	        return "index";
//	    }
//	    
//	    @PostMapping("/api/reservations")
//	    public String createReservation(
//	    		ReservationDto dto,
//	    		@RequestBody Reservation reservation,
//	    		Model model
//	    		) {
//	    	//dto를 entitiy화 시킴
//	    	Reservation entity=dto.toEntity();
//	    	
//	    	//저장
//	        Reservation saveDate = reservationRepository.save(entity);
//	        model.addAttribute("saveDate",saveDate);
//	        
//	        log.info("데이터 저장"+saveDate);
//	        return "index";
//	    }
	
	
}
