package com.pp.view;

import java.util.ArrayList;
import java.util.List;

import com.pp.emp.EmpDTO;

public class EmpView {
	
	
		//모든 사원의 정보 출력
		public void view(List<EmpDTO> ar) {
			for(EmpDTO empDTO : ar) {
				System.out.println("==========");
				this.view(empDTO);
			}
		}
	
	
		public void view(String str) {
			
			System.out.println(str);
		}

		public void view(EmpDTO e) {
			System.out.println(e.getEmpno());
			System.out.println(e.getEname());
			System.out.println(e.getJob());
			System.out.println(e.getMgr());
			System.out.println(e.getHiredate());
			System.out.println(e.getSal());
			System.out.println(e.getComm());
			System.out.println(e.getDeptno());
			
		}
}
