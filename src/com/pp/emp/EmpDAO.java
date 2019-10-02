package com.pp.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pp.util.DBConnector;

public class EmpDAO {
	
	//delete
	public void delete(EmpDTO empDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con =DBConnector.getConnect();
			String sql = "delete emp where empno=?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, empDTO.getEmpno());
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	//insert
	public int insert(EmpDTO empDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = DBConnector.getConnect();
			
			String sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, empDTO.getEmpno());
			st.setString(2, empDTO.getEname());
			st.setString(3, empDTO.getJob());
			st.setInt(4, empDTO.getMgr());
			st.setInt(5, empDTO.getSal());
			st.setInt(6, empDTO.getComm());
			st.setInt(7,empDTO.getDeptno());
			
			result = st.executeUpdate();
			if(result > 0) {
				System.out.println("성공");
			}else {
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
		
		return result;
	}
	
	
	
	public List<EmpDTO> getSelectList2(String str){
		Connection con = null;
		PreparedStatement st= null;
		ResultSet rs = null;
		EmpDTO empDTO = null;
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		
		try {
			con = DBConnector.getConnect();
			
			String sql = "select * from emp where ename like '%"+str+"%'";
			
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
	
	//getSelectList
		//전체사원정보 - 최신입사일순
		public List<EmpDTO> getSelectList(){
			Connection con = null;
			PreparedStatement st= null;
			ResultSet rs = null;
			EmpDTO empDTO = null;
			ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
			
			try {
				con = DBConnector.getConnect();
				//String sql = "select * from dept order by asc";
				String sql = "select * from emp order by hiredate desc";
				
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
