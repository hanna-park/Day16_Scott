package com.pp.salgrade;

import java.util.ArrayList;

public class SalgradeView {

	//모든 등급 출력
	public void view(ArrayList<SalDTO> ar) {
		for(SalDTO sdto: ar) {
			System.out.println("==================");
			this.view(sdto);
		}
	}
	
	public void view(String str) {
		System.out.println(str);
	}
	
	public void view(SalDTO sdto) {
		
		System.out.println("Grade: " + sdto.getGrade());
		System.out.println("Losal: " + sdto.getLosal());
		System.out.println("Hisal: " + sdto.getHisal());
		
	}
	
}
