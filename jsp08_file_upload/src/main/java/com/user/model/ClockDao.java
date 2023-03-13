package com.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClockDao {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "TIS001";
	private String pw = "1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertClock(ClockDto clockDto) {
		int result = 0;

		try {
			getConnection();
			String sql = "INSERT INTO CLOCK VALUES (CLOCK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clockDto.getTitle());
			pstmt.setString(2, clockDto.getCategory());
			pstmt.setInt(3, clockDto.getDepth());
			pstmt.setInt(4, clockDto.getPrice());
			pstmt.setString(5, clockDto.getClockImg());
			pstmt.setString(6, clockDto.getClockRealImg());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	
	public ArrayList<ClockDto> getAllClock() {
		ArrayList<ClockDto> clockList = new ArrayList<>();
		
		try {
			getConnection();
			String sql = "SELECT * FROM CLOCK";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ClockDto clockDto = new ClockDto();
				clockDto.setNo(rs.getInt("no"));
				clockDto.setTitle(rs.getString("title"));
				clockDto.setCategory(rs.getString("category"));
				clockDto.setDepth(rs.getInt("depth"));
				clockDto.setPrice(rs.getInt("price"));
				clockDto.setClockImg(rs.getString("clockImg"));
				clockDto.setClockRealImg(rs.getString("clockRealImg"));
				clockList.add(clockDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return clockList;
	}
}
