package com.kh.spring.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.shop.repository.MemberRepository;
import com.kh.spring.shop.vo.Member;

@Service
public class MemberService{
	@Autowired
	private MemberRepository memberRepository;
	
	//1. 회원가입 메서드
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}
	
	//아이디 중복체크 메서드.
	public void validateDuplicateMember(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		//아이디 중복 시 > Exception 활용하여 기존 회원 표시.
		
		/*
		DB에서 기존 회원의 이메일은 예외 발생시키는 if문
		if(findMember != null) {
			throw new IllegalException("이미 사용하고 있는 아이디입니다.");
		}
		*/
	}
}

/*
UserDetailsService
사용자 정보를 갖고 오거나 인증할 때 사용하는 서비스.
사용자의 아이디나 이메일을 받아 와서 받아 온 정보를 객체로 반환할 때 사용.
*/