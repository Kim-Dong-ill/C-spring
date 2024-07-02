package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Entity.Reservation;
import com.example.demo.Entity.TestEntity;
import com.example.demo.dao.ReservationRepository;
import com.example.demo.dao.TestRepository;
import com.example.demo.dto.ReservationDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
//@CrossOrigin(origins = "http://localhost:3000")
public class MyController {
	
	
	    @Autowired
	    private ReservationRepository reservationRepository;
	    
	    @Autowired
	    private TestRepository repo;
	    
	    @GetMapping("/test")
	    public String testview(@RequestParam("id") Long id, Model model) {
	    	
//	    	List<TestEntity> entity = repo.findAll();
	    	
	    	TestEntity entity = repo.findById(id).orElse(null);
	    	log.info("entity = "+entity);
	    	
	  
	    	
	    	model.addAttribute("list",entity);
	    	model.addAttribute("id",entity.getId());
	    	return "index";
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
	    @GetMapping("/api/reservations")
	    public String getAllReservations(Model model) {
	        List<Reservation> result = reservationRepository.findAll();
	        return "index";
	    }
	    
	    @PostMapping("/api/reservations")
	    public String createReservation(
	    		ReservationDto dto,
	    		@RequestBody Reservation reservation,
	    		Model model
	    		) {
	    	//dto를 entitiy화 시킴
	    	Reservation entity=dto.toEntity();
	    	
	    	//저장
	        Reservation saveDate = reservationRepository.save(entity);
	        model.addAttribute("saveDate",saveDate);
	        
	        log.info("데이터 저장"+saveDate);
	        return "index";
	    }
	
	
}
