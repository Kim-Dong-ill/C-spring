package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class KakaoPayReadyResponse {
	private String tid;
    private String next_redirect_pc_url;
    private String created_at;
}
