package com.pp.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pp.util.DBConnector;

public class EmpDAO {
	
	//getSelectList
		//전체사원정보 - 최신입사일순
		public ArrayList<EmpDTO> getSelectList(){
			Connection con = null;
			PreparedStatement st= null;
			ResultSet rs = null;
			EmpDTO empDTO = null;
			ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
			
			try {
				con = DBConnector.getConnect();
				
				String sql = "select empno, ename, job, mgr, hiredate, sal, nvl(comm, 0) comm, deptno "
						+ "from emp order by hiredate desc";
				
				st = con.prepareStatement(sql);
				
				rs = st.executeQuery();
				
				while(rs.next()) {
					empDTO = new EmpDTO();
					empDTO.setEmpno(rs.getInt("empno"));
					empDTO.setEname(rs.getString("ename"));
					empDTO.setJob(rs.getString("job"));
					empDTO.setMgr(rs.getInt("mgr"));
					empDTO.setHiredate(rs.getDate("hiredate"));
					empDTO.setSal(rs.getInt("sal"));
					empDTO.setComm(rs.getInt("comm"));
					empDTO.setDeptno(rs.getInt("deptno"));
					ar.add(empDTO);
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
	
	//getselectOne
	//매개변수 사원번호
	public EmpDTO getselectOne(int empno) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		EmpDTO e = null;
		
		try {
			con =DBConnector.getConnect();
			String sql = "select * from emp where empno=?";
			st= con.prepareStatement(sql);
			
			st.setInt(1, empno);
			rs =st.executeQuery();
			
			if(rs.next()) {
				e= new EmpDTO();
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setMgr(rs.getInt(4));
				e.setHiredate(rs.getDate(5));
				e.setSal(rs.getInt(6));
				e.setComm(rs.getInt(7));
				e.setDeptno(rs.getInt(8));
				
			}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			
		}
		
		
		
		
		return e;
	}

}
