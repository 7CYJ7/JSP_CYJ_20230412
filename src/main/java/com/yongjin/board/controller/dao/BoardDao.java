package com.yongjin.board.controller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yongjin.board.controller.dto.BoardDto;

public class BoardDao {
	
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jspdb";
	private String username = "root";
	private String password = "1234";
	
	public void write(String writer, String subject, String content) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO board(writer, subject, content) VALUES(?,?,?)";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public ArrayList<BoardDto> list() {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM board ORDER BY bnum DESC";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bnum= rs.getInt("bnum");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String wdate = rs.getString("wdate");
				
				BoardDto dto = new BoardDto(bnum, writer, subject, content, wdate);
				
				dtos.add(dto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return dtos;
		
	
		
	}
	public BoardDto content_view(String bnum) {
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM board WHERE bnum=?";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int cnum= rs.getInt("bnum");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String wdate = rs.getString("wdate");
				
				dto = new BoardDto(cnum, writer, subject, content, wdate);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return dto;
		
	}


}
