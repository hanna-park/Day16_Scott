package com.pp.salgrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pp.util.DBConnector;

public class SalDAO {
	
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	SalDTO sdto=null;
	ArrayList<SalDTO> sdtoList=null;
	//전체,검색, insert, delete

	public ArrayList<SalDTO> selectAll() {
	//전체검색
		try {
			con=DBConnector.getConnect();
			String sql="select * from SALGRADE";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			sdtoList=new ArrayList<SalDTO>();
			while(rs.next()) {
				sdto=new SalDTO();
				sdto.setGrade(rs.getInt("grade"));
				sdto.setLosal(rs.getInt("losal"));
				sdto.setHisal(rs.getInt("hisal"));

				sdtoList.add(sdto);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sdtoList;
	}

	public SalDTO selectOne(int grade) {
		try {
			con=DBConnector.getConnect();

			String sql="select grade, losal, hisal from SALGRADE where grade=?";
			st=con.prepareStatement(sql);
			st.setInt(1, grade);
			rs=st.executeQuery();

			if(rs.next()) {	//값 있을때 기준으로 작동
				sdto=new SalDTO();
				sdto.setGrade(rs.getInt("grade"));
				sdto.setLosal(rs.getInt("losal"));
				sdto.setHisal(rs.getInt("hisal"));
			}
			else{
				System.out.println("찾을 수 없습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sdto;
	}

	public int insert(SalDTO sdto) {
		int result=0;
		try {
			con=DBConnector.getConnect();
			String sql="insert into SALGRADE (grade, losal, hisal) values(?,?,?)";

			st=con.prepareStatement(sql);

			st.setInt(1, sdto.getGrade());
			st.setInt(2, sdto.getLosal());
			st.setInt(3, sdto.getHisal());

			result=st.executeUpdate();
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

		return result;
	}

	public int delete(int grade) {
		int result=0;
		try {
			con=DBConnector.getConnect();
			String sql="delete SALGRADE where grade="+grade;
			st=con.prepareStatement(sql);
			result=st.executeUpdate();

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

		return result;
	}
}
