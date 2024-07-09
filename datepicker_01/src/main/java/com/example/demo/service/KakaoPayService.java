package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoPayService {
	@Value("${kakao.admin.key}")
    private String adminKey;

    private static final String HOST = "https://kapi.kakao.com";

    public String kakaoPayReady() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + adminKey);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("item_name", "캠핑장 텐트");
        params.add("quantity", "1");
        params.add("total_amount", "450000");
        params.add("tax_free_amount", "100");
        params.add("approval_url", "http://localhost:3000/camp/pay/complete");
        params.add("cancel_url", "http://localhost:8082/kakaoPayCancel");
        params.add("fail_url", "http://localhost:8082/kakaoPaySuccessFail");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, headers);

        return restTemplate.postForObject(HOST + "/v1/payment/ready", body, String.class);
    }
    
    
    
//    public PaymentApprovalResponse approvePayment(String pgToken) {
//        
//    }
}
