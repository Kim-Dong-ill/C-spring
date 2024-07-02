package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	// 특정 날짜 범위 내의 예약을 찾는 메서드
//    List<Reservation> findByStartDateLessThanEqualAndEndDateGreaterThanEqual1(LocalDate endDate, LocalDate startDate);
    
    // 특정 날짜에 겹치는 예약을 찾는 메서드
//    List<Reservation> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate date, LocalDate sameDate);
}
