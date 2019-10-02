package com.pp.Bonus;

import java.util.Scanner;

public class BonusInput {
	BonusDTO bdto=null;
	Scanner sc=new Scanner(System.in);
	
	public String bonDelete() {
		System.out.println("삭제할 이름 입력");
		String ename=sc.next();
		
		return ename;
	}
	
	public BonusDTO bonInsert() {
		bdto=new BonusDTO();
		System.out.println("ename : ");
		String ename=sc.next();
		System.out.println("job : ");
		String job=sc.next();
		System.out.println("sal : ");
		int sal=sc.nextInt();
		System.out.println("comm : ");
		int comm=sc.nextInt();
		
		bdto.setEname(ename);
		bdto.setJob(job);
		bdto.setSal(sal);
		bdto.setComm(comm);
		
		return bdto;
	}
	
	public String bonnoInput() {
		System.out.println("찾을 이름 입력");
		String ename=sc.next();
		return ename;
	}
}
