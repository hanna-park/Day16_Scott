package com.pp.Bonus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pp.util.DBConnector;

public class BonusDAO {
	
	//보너스 추가하기
	public void bonInsert(BonusDTO bonusDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			
			String sql = "insert into bonus values(?,?,?,?)";
			
			st = con.prepareStatement(sql);
			
			st.setString(1, bonusDTO.getEname());
			st.setString(2, bonusDTO.getJob());
			st.setInt(3, bonusDTO.getSal());
			st.setInt(4, bonusDTO.getComm());
			
			result = st.executeUpdate();
			if(result > 0) {
				System.out.println("성공");
			}else{
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//보너스 전체 정보
	public ArrayList<BonusDTO> getSelectList(){
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BonusDTO bonusDTO = null;
		ArrayList<BonusDTO> ar = new ArrayList<BonusDTO>();
		
		try {
			con =DBConnector.getConnect();
			
			String sql = "select * from bonus";
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));
				
				ar.add(bonusDTO);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ar;
	}
	
	//매개변수 보너스
	public BonusDTO getselectOne(String ename) {
		
		BonusDTO bonusDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * form emp where ename=?";
			st = con.prepareStatement(sql);
			
			st.setString(1, ename);
			rs = st.executeQuery();
			
			if(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString(1));
				bonusDTO.setJob(rs.getString(2));
				bonusDTO.setSal(rs.getInt(3));
				bonusDTO.setComm(rs.getInt(4));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return bonusDTO;
	}

	//삭제
	
	public void bonDelete(BonusDTO bonusDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = DBConnector.getConnect();
			String sql = "delete bonus where ename=?";
			
			st = con.prepareStatement(sql);
			
			st.setString(1, bonusDTO.getEname());
			
			result = st.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공");	
			}else {
				System.out.println("삭제 실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
}
