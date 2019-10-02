package com.pp.salgrade;

import java.util.ArrayList;
import java.util.Scanner;

public class SalController {
	public void start() {

		Scanner sc=new Scanner(System.in);
		SalDAO sdao=new SalDAO();
		SalgradeView sv =new SalgradeView();
		SalgradeInput si = new SalgradeInput();

		boolean check=true;

		while(check) {
			System.out.println("1.전체조회 2.검색조회 3.추가 4.삭제");
			int select=sc.nextInt();
			int result=0;
			switch(select) {
			case 1:
				
				ArrayList<SalDTO> sdtoList=null;
				sdtoList=sdao.selectAll();
				sv.view(sdtoList);
				break;
			case 2:
				
				int num =si.salnoInput();
				SalDTO sdto=new SalDTO();
				sdto=sdao.selectOne(num);
				sv.view(sdto);
				break;
			case 3:
				
				System.out.println("grade : ");
				int grade=sc.nextInt();
				
				System.out.println("losal : ");
				int losal=sc.nextInt();
				System.out.println("hisal : ");
				int hisal=sc.nextInt();
				SalDTO sdto2=new SalDTO();
				result=sdao.insert(sdto2);
				if(result>0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				break;
			case 4:
				System.out.println("삭제할 grade 입력");
				int num2=sc.nextInt();
				result=sdao.delete(num2);
				if(result>0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}

			case 5:
				System.out.println("종료");
				check=!check;
				break;
			default:
				System.out.println("다시 입력");
			}
		}


	}
}
