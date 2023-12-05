package com.kh.springdb.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	//유저 조회
	User findByUserName(String userName);
	//유저 아이디 찾기
	User findById(int id);
	
}
