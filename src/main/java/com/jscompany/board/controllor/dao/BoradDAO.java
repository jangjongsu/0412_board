package com.jscompany.board.controllor.dao;

import java.sql.*;
import java.util.ArrayList;

import com.jscompany.board.controllor.dto.BoardDTO;


public class BoradDAO {
	private String driverName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jspdb";
	private String username = "root";
	private String password = "1234";
	
	public void write(String writer, String subject, String content) {
		
      	Connection conn = null;
     	PreparedStatement pstmt = null;
     	String sql = "INSERT INTO board (writer, subject, content) VALUES (?,?,?)";
     	
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
			
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, writer);
		pstmt.setString(2, subject);
		pstmt.setString(3, content);	
         
		pstmt.executeUpdate();
      
         
      } catch(ClassNotFoundException e) {
    	  e.printStackTrace();   
      } catch(SQLException e) {
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
	public ArrayList<BoardDTO> list() {
		
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		
		Connection conn = null;
     	PreparedStatement pstmt = null;
     	ResultSet rs = null;
     	
     	String sql = "SELECT * FROM board order by bnum desc " ;
     	
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
			
		pstmt = conn.prepareStatement(sql);
         
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int bnum = rs.getInt("bnum");
			String writer =rs.getString("writer");
			String subject =rs.getString("subject");
			String content =rs.getString("content");
			String wdate =rs.getString("wdate");
			
			BoardDTO dto = new BoardDTO(bnum, writer, subject, content, wdate);
			
			dtos.add(dto);
		}

         
      } catch(ClassNotFoundException e) {
    	  e.printStackTrace();   
      } catch(SQLException e) {
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
	public BoardDTO content_View(String bnum) {
		
		Connection conn = null;
     	PreparedStatement pstmt = null;
     	ResultSet rs = null;
     	BoardDTO dto = null;
     	
     	String sql = "SELECT * FROM board WHERE bnum=?" ;
     	
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
			
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, bnum);
         
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			int cnum = rs.getInt("bnum");
			String writer =rs.getString("writer");
			String subject =rs.getString("subject");
			String content =rs.getString("content");
			String wdate =rs.getString("wdate");
			
			dto = new BoardDTO(cnum, writer, subject, content, wdate);
		
		}

         
      } catch(ClassNotFoundException e) {
    	  e.printStackTrace();   
      } catch(SQLException e) {
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
	public void content_Delete(String bnum) {
		Connection conn = null;
     	PreparedStatement pstmt = null;
     	
     	
     	String sql = "DELETE FROM board WHERE bnum=?";
     	
      try {
    	Class.forName(driverName);
		conn = DriverManager.getConnection(url, username, password);
		
		int bnumInt = Integer.parseInt(bnum);  //문자열을 정수로 전환
			
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,bnumInt);
         
		int dbFlag = pstmt.executeUpdate();
		
		if (dbFlag == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		

         
      } catch(ClassNotFoundException e) {
    	  e.printStackTrace();   
      } catch(SQLException e) {
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

}
