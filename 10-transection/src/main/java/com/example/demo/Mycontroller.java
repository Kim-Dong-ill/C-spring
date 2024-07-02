package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.IBuyTicketService;

@Controller
public class Mycontroller {

	@Autowired
	IBuyTicketService buyTicket;
	
	@RequestMapping("/")
	@ResponseBody
	public String root() {
		return "transaction";
	}
	
	@RequestMapping("/buyticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buyticketcard")
	public String buy_ticket_card(
				@RequestParam("consumerId") String consumerId,
				@RequestParam("amount") String amount,
				@RequestParam("error") String error,
				Model model
			) {
		int nResult = buyTicket.buy(consumerId, Integer.parseInt(amount), error);	//0 or 1 이 나옴
		
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("amount", amount);
		
		if(Integer.parseInt(error) == 1) {
			return "buy_ticket_end";
		}else {
			return "buy_ticket_error";
		}
	}
}
