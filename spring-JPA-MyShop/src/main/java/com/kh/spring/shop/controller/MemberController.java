package com.kh.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.shop.service.MemberService;
import com.kh.spring.shop.vo.Member;

@Controller
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//회원가입, 회원가입 결과 @GetMapping @PostMapping
	@GetMapping("/new")
	public String joinMember(Model model) {
		model.addAttribute("member", new Member());
		return "/member/joinForm";
	}
	
	@PostMapping("/new")
	public String addMember(@ModelAttribute Member member) {
		//기존 가입 아이디 중복 여부
		memberService.saveMember(member);
		return "redirect:/";
	}
	
	@PostMapping("/save")
	public String saveMember(@ModelAttribute Member member) {
		memberService.saveMember(member);
		return "redirect:/members";
	}
	
	//로그인, 로그인 실패 @GetMapping @GetMapping
	@GetMapping("/login")
	public String loginMember() {
		return "/member/memberLoginForm";
	}
	
	@GetMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", true);
		//model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인하세요.");
		return "/member/memberLoginForm";
	}
}
