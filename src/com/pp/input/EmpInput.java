package com.pp.input;

import java.util.Scanner;

public class EmpInput {
	
	private Scanner sc;
	
	public EmpInput() {
		sc = new Scanner(System.in);
	}
	
	//empnoInput
	//사원번호를 입력하세요
	public int empnoInput() {
		
		System.out.println("사원 번호를 입력하세요.");
		int num = sc.nextInt();
		
		return num;
	}

}
