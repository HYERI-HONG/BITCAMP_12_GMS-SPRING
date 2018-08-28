package com.gms.web.controller;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gms.web.domain.MemberDTO;
import com.gms.web.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired MemberService memberService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST) //post방식
	public String add(@ModelAttribute("member") MemberDTO member) {
		logger.info("MemberController ::: add(){}");
		memberService.add(member);
		return "redirect:/move/member/login";
	}
	@RequestMapping("/list")
	public void list() {}
	@RequestMapping("/search")
	public void search() {}
	
	@RequestMapping("/retrieve")
	public void retrieve(@ModelAttribute MemberDTO member) {
		MemberDTO mem =memberService.retrieve(member.getUserid());
	}
	@RequestMapping("/count")
	public void count() {}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute MemberDTO member) {
		logger.info("MemberController ::: remove(){}");
		member.setPassword("test");
		memberService.modify(member);
		
		return "";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public void remove(@ModelAttribute MemberDTO member) {
		logger.info("MemberController ::: remove(){}");
		member.setUserid("t1");
		memberService.remove(member);
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public String login(@ModelAttribute("member") MemberDTO member, Model model) {
		String rs ="login_success";
		logger.info("MemberController ::: login(){}");
		if(memberService.login(member)) {
			model.addAttribute("user", memberService.retrieve(member.getUserid()));
		}else {
			rs="redirect:/move/member/login";
		}	
		return rs;
	}
	@RequestMapping("/logout")
	public String logout() {
		logger.info("MemberController ::: logout(){}");
		return "redirect:/";
	}
	@RequestMapping("/fileupload")
	public void fileupload() {}
}
