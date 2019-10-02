package com.pp.control;

import java.util.Scanner;

import com.pp.Bonus.BonusController;
import com.pp.salgrade.SalController;

public class FrontController {
	
	private Scanner sc;
	private EmpController empController;
	private DeptController deptController;
	private SalController sal;
	private BonusController bon;
	
	public FrontController() {
		sc = new Scanner(System.in);
		empController = new EmpController();
		deptController = new DeptController();
		sal = new SalController();
		bon = new BonusController();
	}
	
	
	public void start() {
		
		boolean check = true;
		int select  = 0;
		
		while(check) {
			System.out.println("1. 사원관리");
			System.out.println("2. 부서관리");
			System.out.println("3. sal");
			System.out.println("4. bonus");
			System.out.println("4. 종료");
			select =sc.nextInt();
			
			switch(select) {
			
			case 1:
				empController.start();
				
				break;
				
			case 2:
				deptController.start();			
				break;
				
			case 3:
				sal.start();
				break;
			case 4:
				bon.start();
				break;
			default:
				check = !check;
			}
			
			
		}
		
		
		
	}

}
