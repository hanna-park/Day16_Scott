package com.pp.Bonus;

import java.util.ArrayList;
import java.util.Scanner;

public class BonusController {
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		BonusDAO bonDAO = new BonusDAO();
		BonusView bonv = new BonusView();
		BonusInput bonin = new BonusInput();
		
		while(check) {
			
			System.out.println("1. 보너스 전체 정보");
			System.out.println("2. 보너스 검색 출력");
			System.out.println("3. 보너스 정보 추가");
			System.out.println("4. 보너스 정보 삭제");
			System.out.println("5. 종료");
			
			int num = sc.nextInt();
			
			switch(num) {
			
			case 1 :
				ArrayList<BonusDTO> ar = bonDAO.getSelectList();
				
				break;
			
			case 2 :
		
				
				break;
			
			case 3:
				 break;
			
			case 4:
				break;
				
			default:
				check = !check;	
			}//switch 끝
		
		}//while 끝
		
	}

}
