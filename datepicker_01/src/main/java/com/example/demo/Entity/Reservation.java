package com.example.demo.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Setter
@Getter
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;

	@Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;
	
	@Transient
	private String message;  // 예약 실패 시 메시지를 저장할 필드
	
	
	public Reservation(LocalDateTime startDate, LocalDateTime endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
