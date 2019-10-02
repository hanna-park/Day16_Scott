package com.pp.salgrade;

import java.util.Scanner;

public class SalgradeInput {
	
	private Scanner sc;
	
	public SalgradeInput() {
		sc = new Scanner(System.in);
		
	}
	
	public int salDelete() {
			
		System.out.println("삭제할 등급을 입력하세요.");
		int grade = sc.nextInt();
		
		return grade;
	}
	
	public SalDTO salInsert() {
		SalDTO sdto = new SalDTO();
		
		System.out.println("등급을 입력하세요.");
		int grade = sc.nextInt();
		sdto.setGrade(grade);
		System.out.println("낮은 금액을 입력하세요.");
		int losal = sc.nextInt();
		sdto.setLosal(losal);
		System.out.println("높은 금액을 입력하세요.");
		int hisal = sc.nextInt();
		sdto.setHisal(hisal);
		
		return sdto;
	}
	
	public int salnoInput() {
		
		System.out.println("찾고 싶은 등급을 입력하세요.");
		int num = sc.nextInt();
		
		return num;
	}

}


