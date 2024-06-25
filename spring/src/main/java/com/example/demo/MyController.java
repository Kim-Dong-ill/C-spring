package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/")
	public @ResponseBody String root() {
		return "jsp";
	}
	
	@RequestMapping("/test1")
	public @ResponseBody String index() {
		return "index";
	}
	
	@RequestMapping("/test2")
	public String test2(Model model) {
		
		//model 객체에 데이터 담아서 뷰에 전달
		model.addAttribute("name","홍길동");
		return "test/test2";
	}
	
	@RequestMapping("/mv")
	public ModelAndView test3() {
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		
		list.add("이순신");
		list.add("홍길동");
		list.add("철수");
		list.add("임창정");
		
		mv.addObject("lists",list);
		mv.setViewName("view/myview");
		
		return mv;
	}
}
