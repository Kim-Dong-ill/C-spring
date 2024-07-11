package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PaymentApprovalResponse;
import com.example.demo.service.KakaoPayService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class PayController {
	
	  private final KakaoPayService kakaoPayService;

	    @PostMapping("/kakaoPay")
	    public String kakaoPay() {
	    	log.info("결제시도");
	        return kakaoPayService.kakaoPayReady();
	    }
	    
//	    @GetMapping("/kakaoPaySuccess/{pg_token}")
//	    public ResponseEntity<PaymentApprovalResponse> kakaoPaySuccess(@PathVariable("pg_token") String pgToken) {
//	    	log.info("승인 시도");
//	        // 1. 카카오페이 API로 결제 승인 요청
//	        PaymentApprovalResponse approvalResponse = kakaoPayService.approvePayment(pgToken);
//	        
//	        // 2. 승인 응답을 바탕으로 DB에 결제 정보 저장
////	        Payment payment = paymentRepository.save(new Payment(approvalResponse));
//	        
//	        // 3. 클라이언트에 필요한 정보 반환
//	        return ResponseEntity.ok(approvalResponse);
//	    }
}
