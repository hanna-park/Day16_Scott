package com.pp.input;

import java.util.Scanner;

import com.pp.emp.EmpDTO;

public class EmpInput {
	
	private Scanner sc;
	
	public EmpInput() {
		sc = new Scanner(System.in);
	}
	
	public EmpDTO insert() {
		EmpDTO empDTO = new EmpDTO();
		
		System.out.println("사원 번호를 입력하세요.");
		int empno = sc.nextInt();
		empDTO.setDeptno(empno);
		System.out.println("사원 이름을 입력하세요.");
		String ename = sc.next();
		empDTO.setEname(ename);
		System.out.println("직업을 입력하세요.");
		String job = sc.next();
		empDTO.setJob(job);
		System.out.println("상사 번호를 입력하세요");
		int mgr = sc.nextInt();
		empDTO.setMgr(mgr);
		System.out.println("월급을 입력하세요.");
		int sal = sc.nextInt();
		empDTO.setSal(sal);
		System.out.println("보너스를 입력하세요.");
		int comm = sc.nextInt();
		empDTO.setComm(comm);
		System.out.println("부서번호를 입력하세요.");
		int deptno =sc.nextInt();
		empDTO.setDeptno(deptno);
		
		
		return empDTO;
	}
	
	//empnoInput
	//사원번호를 입력하세요
	public int empnoInput() {
		
		System.out.println("사원 번호를 입력하세요.");
		int num = sc.nextInt();
		
		return num;
	}

}
