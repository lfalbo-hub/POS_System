package posTest;

import java.math.BigDecimal;
import java.time.*;
import posPd.*;

public class StoreTest {
	public static void doAcTest_pd_21_1(Store aStore) {
		System.out.println("AC #2.1.1");
		System.out.println(aStore.toString());
	}
	
	public static void doAcTest_pd_21_2(Store aStore) {
		System.out.println("AC #2.1.2");
		System.out.println(aStore.toString());
	}
	
	public static void doAcTest_pd_21_3(Store aStore) {
		
		/*
		 * =========================================
		 * 
		 * 					AC # 1
		 * 
		 * =========================================
		 */
		
		System.out.println("AC #2.1.3.1\n");
		
		// Creating a TaxCategory Object
		TaxCategory snackTax = new TaxCategory("Food Tax");
		snackTax.addTaxRate(new TaxRate("2026-01-01", "0.07"));
        aStore.addTaxCategory(snackTax);

		// Creating a Item Object
		Item chocolate = new Item("0001", "A Normal Chocolate Bar");
		chocolate.setTaxCategory(snackTax);
		chocolate.addPrice(new Price("2.00", "2026-10-15"));
		
		// Creating a UPC Object
		UPC choccyUPC = new UPC("10010101");
		choccyUPC.setItem(chocolate);
		chocolate.addUPC(choccyUPC);
		
		aStore.addItem(chocolate);
		aStore.addUPC(choccyUPC);
		
		// Creating a Item Object
		Item skittles = new Item("0002", "Original Skittles");
		skittles.setTaxCategory(snackTax);
		skittles.addPrice(new Price("1.50", "2026-10-15"));
		
		// Creating a UPC Object
		UPC skitUPC = new UPC("10010110");
		skitUPC.setItem(skittles);
		skittles.addUPC(skitUPC);
		
		aStore.addItem(skittles);
		aStore.addUPC(skitUPC);
		
		// Creating a Item Object
		Item pretzels = new Item("0003", "Snyder's Pretzels");
		pretzels.setTaxCategory(snackTax);
		pretzels.addPrice(new Price("2.25", "2026-10-15"));
		
		// Creating a UPC Object
		UPC pretUPC = new UPC("10010111");
		pretUPC.setItem(pretzels);
		pretzels.addUPC(pretUPC);
		
		aStore.addItem(pretzels);
		aStore.addUPC(pretUPC);
		
		// Creating a LocalDate Object
		LocalDate today = LocalDate.now();
		
		// Formatted Output
		System.out.println("Store: " + aStore.getName() + " (#" + aStore.getNumber() + ")");
		System.out.println("Date: " + today + "\n");
		System.out.println("Items");
		System.out.println("=========================================");
	
		for (Item item : aStore.getItems().values()) {
			Price currentPrice = item.getPriceForDate(today);
			String priceStr = (currentPrice != null) ? currentPrice.getPrice().toString() : "0.00";
			
			System.out.println(item.getNumber() + " " + item.getDescription() + " " 
					+ priceStr + ", Tax Rate: " + item.getTaxRateForDate(today));
		}
		
		/*
		 * =========================================
		 * 
		 * 					AC # 2
		 * 
		 * =========================================
		 */
		
		System.out.println("\nAC #2.1.3.2\n");
		
		// Creating a Person Object & Cashier Object
		Person Luke = new Person("Luke", "1234 St.", "867-5309","Lubbock","Texas","12345","123-45-6789");
		Cashier LukeCashier = new Cashier("0001", Luke, "TheBestEmployee");
		
		aStore.addCashier(LukeCashier);
		
		// Creating a Person Object & Cashier Object		
		Person Caleb = new Person("Caleb", "1234 Ave.", "123-2390","Florida","Florida","12345","000-00-0001");
		Cashier CalebCashier = new Cashier("0002", Caleb, "The2ndEmployee");
		
		aStore.addCashier(CalebCashier);
		
		// Creating a Person Object & Cashier Object
		Person Nolan = new Person("Nolan", "0494 St.", "098-2349","Knoxville","Tennessee","02933","098-32-2309");
		Cashier NolanCashier = new Cashier("0003", Nolan, "Employee3");
		
		aStore.addCashier(NolanCashier);
		
		// Formatted Output
		System.out.println("Store: " + aStore.getName() + " (#" + aStore.getNumber() + ")");
		System.out.println("Date: " + today + "\n");
		System.out.println("Cashiers");
		System.out.println("=========================================");
	
		for (Cashier cashier : aStore.getCashiers().values()) {
	        // Displays cashier number and person name
	        if (cashier.getPerson() != null) {
	            System.out.println("Cashier: " + cashier.getPerson() + ", Employee ID #" + cashier.getNumber());
	        } else {
	            System.out.println(cashier.getNumber());
	        }
		}
		
		/*
		 * =========================================
		 * 
		 * 					AC # 3
		 * 
		 * =========================================
		 */
		
		System.out.println("\nAC #2.1.3.3\n");
		
		// Creating a Register Object & CashDrawer Object
		Register register1 = new Register("0001");
		CashDrawer drawer1 = new CashDrawer();
		drawer1.setCashAmount(new BigDecimal(300));
		register1.setCashDrawer(drawer1);
		register1.getCashDrawer();
		
		// Creating a Session Object
		Session LukeSession = new Session(LukeCashier, register1);
		aStore.addSession(LukeSession);
		aStore.addRegister(register1);
		
		// Creating a Register Object & CashDrawer Object
		Register register2 = new Register("0002");
		CashDrawer drawer2 = new CashDrawer();
		drawer2.setCashAmount(new BigDecimal(200));
		register2.setCashDrawer(drawer2);
		register2.getCashDrawer();
		
		// Creating a Session Object		
		Session CalebSession = new Session(CalebCashier, register2);
		aStore.addSession(CalebSession);
		aStore.addRegister(register2);
		
		// Creating a Register Object & CashDrawer Object
		Register register3 = new Register("0003");
		CashDrawer drawer3 = new CashDrawer();
		drawer3.setCashAmount(new BigDecimal(300));
		register3.setCashDrawer(drawer3);
		register3.getCashDrawer();
		
		// Creating a Session Object
		Session NolanSession = new Session(NolanCashier, register3);
		aStore.addSession(NolanSession);
		aStore.addRegister(register3);
		
		// Formatted Output
		System.out.println("Registers");
		System.out.println("=========================================");
		for (Register register : aStore.getRegisters().values()) {
		    System.out.println("Register #" + register.getNumber() + " | " + register.getCashDrawer());
		}
		
		/*
		 * =========================================
		 * 
		 * 					AC # 4
		 * 
		 * =========================================
		 */
		
		System.out.println("\nAC #2.1.3.4\n");

		// Creating a Sale Object
		Sale lukeSale = new Sale();
		lukeSale.setDateTime(LocalDateTime.now());
		LukeSession.addSale(lukeSale);

		// Creating a SaleLineItem Object
		SaleLineItem itemSale1 = new SaleLineItem(lukeSale, chocolate, "1");
		lukeSale.addSaleLineItem(itemSale1);

		// Creating a SaleLineItem Object
		SaleLineItem itemSale2 = new SaleLineItem(lukeSale, skittles, "2");
		lukeSale.addSaleLineItem(itemSale2);

		//Formatted Output
		System.out.println("Sessions");
		System.out.println("=========================================");
		System.out.println("Session: " + LukeSession + "\nCashier: " + LukeSession.getCashier().getPerson() 
				+ "\nRegister: " + LukeSession.getRegister().getNumber());

		for (SaleLineItem sale : lukeSale.getSaleLineItems()) {
			System.out.println(sale.getItem().getNumber() + " " + sale.getItem().getDescription() + " " 
					+ sale.getQuantity() + " " + sale.calcSubTotal() + " " + sale.calcTax());
		}
		System.out.println("Subtotal = $" + lukeSale.calcSubTotal() 
		+ "\nTax = $" + lukeSale.calcTax() 
		+ "\nTotal = $" + lukeSale.calcTotal());
	}
	
	public static void doAcTest_pd_21_4(Store aStore) {
		System.out.println("AC #2.1.4");
		System.out.println(aStore.toString());
	}
	
}
