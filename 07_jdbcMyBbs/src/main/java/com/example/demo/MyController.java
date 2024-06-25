package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.IMyBbsDAO;
import com.example.demo.dto.MyBbsDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class MyController {
	
	@Autowired
	IMyBbsDAO dao;	//부모격인 인터페이스dao만 가져와도 오버라이딩된게 들어온다.
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list"; //url값에 "list"로 방향을 틀어준다.
	}
	
	//리스트 보여줄때
	@RequestMapping("/list")
	public String listPage(Model model) {
		
		model.addAttribute("lists",dao.listDao());
		
		return "list";
	}
	
	//단일 항목 보여줄때 (id값 필요함)
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		
		String sId = request.getParameter("id");
		model.addAttribute("dto",dao.viewDao(sId));
		return "view";
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		dao.deleteDao(request.getParameter("id"));
		
		return "redirect:list";
	}
	
	//글쓰기
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		dao.writeDao(
				request.getParameter("writer"),
				request.getParameter("title"),
				request.getParameter("content")
				);
		
		return "redirect:list";
	}
	
	@RequestMapping("/writerForm")
	public String wirterForm() {
		return "writerForm";
	}
}
