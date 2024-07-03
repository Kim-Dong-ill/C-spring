package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	
	 @Query("SELECT r FROM Reservation r WHERE " +
	           "(r.startDate <= :endDate AND r.endDate >= :startDate)")
	    List<Reservation> findOverlappingReservations(
	        @Param("startDate") LocalDateTime startDate,
	        @Param("endDate") LocalDateTime endDate
	    );
}
