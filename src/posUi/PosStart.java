package posUi;

import posPd.Store;
import posTest.StoreTest;

public class PosStart {

	public static void main(String args[]) {
		
		//doPosPd_2_1();
		doPosPd_2_2();
		//doPosPd_2_34();
	}
	
	private static void doPosPd_2_1() {
		Store myStore = new Store("Luke's Store", "1234");
		
		StoreTest.doAcTest_pd_21_3(myStore);
	}
	
	private static void doPosPd_2_2() {
		System.out.println("Project 2.2 - POS - DM");
		System.out.println();
		
		Store myStore = new Store();
		
		System.out.println("Ready to open Store");
	
		myStore.openStore();
	}
	
	private static void doPosPd_2_34() {
		
	}
	
}
