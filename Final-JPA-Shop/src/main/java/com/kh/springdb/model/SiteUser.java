package com.kh.springdb.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class SiteUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="u_seq")
	@SequenceGenerator(name = "u_seq", sequenceName="u_seq",allocationSize=1)
    private Long id;

	//isRole 가입할 때마다 이사람이 판매자인지 소비자인지 체크해서 가입하기
	
	@Enumerated(EnumType.STRING)
	private UserRole isRole;
	//private String isRole;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@Column(unique = true)
	private String emall;
	
	// 추천인을 넣고 싶다면 추천자를 생성해서 넣어도 됨
}