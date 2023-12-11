package com.kh.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.user.dto.UserDTO;

//DB 연결 및 SQL 수행.
public class UserDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "userID";
	String password = "userPassword";
	
	//메서드 생성해서 작동할 수 있도록 해주어야 함.
	public UserDAO() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//유저 정보 갖고 오는 Select DB 생성하기
	public UserDTO selectUser(int userNo) {
		UserDTO dat = new UserDTO();
		sql = "SELECT*FROM TB_USER WHERE USER_NO=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, userNo);
		rs = pstmt.executeQuery();
	}
	
	//if문을 작성해서 아이디 1개 조회
	if(rs.next()) {
		dto.serUserNo(rs.getInt(userNo));
		dto.serUserId(rs.getString("USER_ID"));
		dto.serUserName(rs.getString("USER_NAME"));
		dto.serUserAge(rs.getInt("USER_AGE"));
	}
	rs. close();
	pstmt.close();
}
