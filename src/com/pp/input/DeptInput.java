package com.pp.input;

import java.util.Scanner;


import com.pp.dept.DeptDTO;

public class DeptInput {
	
private Scanner sc;
	
	public DeptInput() {
		
		sc = new Scanner(System.in);
	}
	
	public DeptDTO insert() {
		DeptDTO deptDTO = new DeptDTO();
		
		System.out.println("부서 번호를 입력하세요.");
		int deptno = sc.nextInt();
		deptDTO.setDeptno(deptno);
		System.out.println("부서 이름을 입력하세요.");
		String dname =sc.next();
		deptDTO.setDname(dname);
		System.out.println("부서 지역명 입력하세요.");
		String loc= sc.next();
		deptDTO.setLoc(loc);
		
		
		return deptDTO;
	}
	
	public int deptnoInput() {
		System.out.println("부서번호를 입력하세요.");
		int dentno = sc.nextInt();
		
		return dentno;
		
	}

}