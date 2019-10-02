package com.pp.control;

import java.util.ArrayList;
import java.util.List;
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
		
		
		while(check) {
			System.out.println("1. 사원 전체 정보");
			System.out.println("2. 사원 검색 출력");
			System.out.println("3. 사원 정보 추가");
			System.out.println("4. 종료");
			
			int num = sc.nextInt();

			
			switch(num) {
				case 1: 
					List<EmpDTO> ar = emp.getSelectList();
					if(ar.size()>0) {
						ev.view(ar);
						}else {
							ev.view("데이터가 없습니다.");
						}
					
					break;
					
				case 2:
					
					int num2 = in.empnoInput();
					EmpDTO e = emp.getselectOne(num2);
					if(e !=null) {
						ev.view(e);
					}else {
						ev.view("없는 사원 번호입니다.");
					}
					break;
				case 3:
					EmpDTO empDTO = in.insert();
					num = emp.insert(empDTO);
					
					break;
				default:				
					check= !check;
					
			}
			
			
			
		}
		
		
	}
	
	
}
