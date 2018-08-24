package com.gms.web.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.domain.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
