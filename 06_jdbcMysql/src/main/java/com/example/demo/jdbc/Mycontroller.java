package com.example.demo.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mycontroller {

	@Autowired
	private MyDAO listDao;
	
	@ResponseBody
	@RequestMapping("/")
	public String root() {
		return "jdbc";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("lists",listDao.list());
		
		return "index";
	}
}
