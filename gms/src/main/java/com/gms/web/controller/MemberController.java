package com.gms.web.controller;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.domain.MemberDTO;
import com.gms.web.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired MemberService memberService;
	@RequestMapping("/add")
	public String add() {
		logger.info("MemberController ::: add(){}");
		return "redirect:/move/member/login";
	}
	@RequestMapping("/list")
	public void list() {}
	@RequestMapping("/search")
	public void search() {}
	@RequestMapping("/retrieve")
	public void retrieve() {}
	@RequestMapping("/count")
	public void count() {}
	@RequestMapping("/modify")
	public void modify() {}
	@RequestMapping("/remove")
	public void remove() {}
	
	
	@RequestMapping("/login")
	public String login() {
		logger.info("MemberController ::: login(){}");
		Map<String, String> p = new HashMap<>();
		p.put("userid", "a01");
		MemberDTO m = memberService.retrieve(p);
		System.out.println("------------------");
		System.out.println(m.getName());
		System.out.println("------------------");
		return "login_success";
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("MemberController ::: logout(){}");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
