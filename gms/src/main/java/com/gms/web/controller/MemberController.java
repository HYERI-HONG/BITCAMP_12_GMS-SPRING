package com.gms.web.controller;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "redirect:/move/member/login/off";
	}
	@RequestMapping("/list")
	public void list() {}
	@RequestMapping("/search")
	public void search() {}
	
	@RequestMapping("/retrieve")
	public String retrieve(@ModelAttribute MemberDTO member, Model model) {
		model.addAttribute("user", memberService.retrieve(member.getUserid()));
		return "";
	}
	@RequestMapping("/count")
	public void count() {}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(@RequestParam Map<String,String> map , Model model) {
		logger.info("MemberController ::: modify(){}");
		map.put("userid", "a01");
		memberService.modify(map);
		model.addAttribute("user", memberService.retrieve(map.get("userid")));
		return "mypage";
	}
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public void remove(@ModelAttribute MemberDTO member) {
		logger.info("MemberController ::: remove(){}");
		member.setUserid("t1");
		memberService.remove(member);
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public String login(@ModelAttribute("member") MemberDTO member, Model model) {
		logger.info("MemberController ::: login(){}");
		String rs ="mypage";
		if(memberService.login(member)) {
			model.addAttribute("user", memberService.retrieve(member.getUserid()));
		}else {
			rs="redirect:/move/member/login/off";
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
