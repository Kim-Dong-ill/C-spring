package com.example.demo.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/insert") //insert?username=han
	public String insert(
			@RequestParam("username") String username,
			Model model
			) {
		
		//builder를 사용해서 만들때
		Member user = Member.builder()
				.username(username)
				.createDate(LocalDate.now())
				.build();
		
		Member result = mService.insert(user);
		model.addAttribute("result",result);
		
		return "insert";
	}
	
	@RequestMapping("/selectAll")
	public String selectall(Model model) {
		List<Member> result = mService.selectAll();
		model.addAttribute("members",result);
		
		return "selectAll";
	}
	
	@RequestMapping("select")
	public String select(
			@RequestParam("id") Long id,
			Model model) {
		Optional<Member> result = mService.select(id);
		if(result.isPresent()) {
			model.addAttribute("member",result.get());
		}else {
			model.addAttribute("member",null);
		}
		return "select";
	}
	
	@RequestMapping("/delete")
	public String delete(
			@RequestParam("id") Long id
			) {
		mService.delete(id);
		return "delete";
	}
	
	@RequestMapping("/update")
	public String update(
			Member member,
			Model model
			) {
		Member result = mService.update(member);
		model.addAttribute(result);
		return "update";
	}
	
}
