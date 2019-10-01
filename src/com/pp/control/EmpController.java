package com.pp.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.pp.emp.EmpDAO;
import com.pp.emp.EmpDTO;
import com.pp.input.EmpInput;
import com.pp.view.EmpView;

public class EmpController {


	//1. 사원 전체 정보
	//2. 사원 검색 출력
	//3. 종료
	public void start() {
		
		Scanner sc =new Scanner(System.in);
		boolean check =true;
		EmpDAO emp = new EmpDAO();
		EmpView ev = new EmpView();
		EmpInput in = new EmpInput();
		ArrayList<EmpDTO> ar = null;
		
		while(check) {
			System.out.println("1.사원 전체 정보");
			System.out.println("2.사원 검색 출력");
			System.out.println("3. 종료");
			
			int num = sc.nextInt();

			
			switch(num) {
				case 1: 
					ar = emp.getSelectList();
					ev.view(ar);
					break;
					
				case 2:
					
					int num2 = in.empnoInput();
					EmpDTO e = emp.getselectOne(num2);
					if(e !=null) {
						ev.view(e);
					}else {
						ev.view("없는 번호");
					}
					break;
				case 3:
					check=false;
					break;
			}
			
			
			
		}
		
		
	}
	
	
}
