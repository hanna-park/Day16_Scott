package com.pp.Bonus;

import java.util.ArrayList;
import java.util.Scanner;

public class BonusController {
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		BonusDAO bonDAO = new BonusDAO();
		BonusView bv = new BonusView();
		BonusInput bi = new BonusInput();
		
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
				if(ar.size()>0) {
					bv.view(ar);
				}else {
					System.out.println("데이터가 없습니다.");
				}
				break;
			
			case 2 :
				
				String ename = bi.bonnoInput();
				BonusDTO bonDTO = bonDAO.getselectOne(ename);
				if(bonDTO != null) {
					bv.view(bonDTO);
				}else {
					System.out.println("없는 보너스입니다");
				}
				
				break;
			
			case 3:
				
				BonusDTO bonDTO2 = bi.bonInsert();
				num = bonDAO.bonInsert(bonDTO2);
				
				 break;
			
			case 4:
				String str =bi.bonDelete();
				BonusDTO bonDTO3 = bonDAO.getselectOne(str);
						bonDTO3 = bonDAO.bonDelete(bonDTO3);
				
				break;
				
			default:
				check = !check;	
			}//switch 끝
		
		}//while 끝
		
	}

}
