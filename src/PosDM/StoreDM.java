package PosDM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import posPd.*;

public class StoreDM {

	public static void loadStore(Store store) {
		String fileName = "StoreData.csv";
		String lineIn = null;
		String[] tokens;
		String dataType;
		Session currentSession = null;
		Sale currentSale = null;
		
		try {
			FileReader fileReader = new FileReader(fileName);
			
			BufferedReader theBufferedReader = new BufferedReader(fileReader);
			
			currentSession = new Session();
			
			while((lineIn = theBufferedReader.readLine()) != null) {
				tokens = lineIn.split(",");
				
				dataType = tokens[0];
				
				switch(dataType) {
					case "Store":
						store.setNumber(tokens[2]);
						store.setName(tokens[1]);
						break;
					
					case "TaxCategory":
						TaxCategory tc = new TaxCategory();
						TaxRate tr = new TaxRate();
						
						tc.setCategory(tokens[1]);
						tr.setTaxRate(new BigDecimal(tokens[2]));
						tr.setEffectiveDate(tokens[3]);
						tc.addTaxRate(tr);
					
						store.addTaxCategory(tc);
						break;
					
					case "Cashier":
						Cashier c = new Cashier();
						Person personC = new Person();
						
						c.setNumber(tokens[1]);
						personC.setName(tokens[2]);
						personC.setsSN(tokens[3]);
						personC.setAddress(tokens[4]);
						personC.setCity(tokens[5]);
						personC.setState(tokens[6]);
						personC.setZip(tokens[7]);
						personC.setPhone(tokens[8]);
						c.setPassword(tokens[9]);
						c.setPerson(personC);
						personC.setCashier(c);
					
						currentSession.setCashier(c);
						store.addCashier(c);
						break;
					
					case "Item":
						Item i = new Item();
						UPC ui = new UPC();
						Price pi = new Price();
						//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
					
						i.setNumber(tokens[1]);
						ui.setuPC(tokens[2]);
						ui.setItem(i);
						i.addUPC(ui);
						i.setDescription(tokens[3]);
						i.setTaxCategory(store.findTaxCategoryByName(tokens[4]));
						pi.setPrice(new BigDecimal(tokens[5]));
						pi.setEffectiveDate(parseDate(tokens[6]));
						i.addPrice(pi);
						
						if(tokens.length >= 10) {
							PromoPrice ppi = new PromoPrice();
							ppi.setPrice(new BigDecimal(tokens[7]));
							ppi.setEffectiveDate(parseDate(tokens[8]));
							ppi.setEndDate(parseDate(tokens[9]));
							i.addPrice(ppi);
						}
					
						store.addItem(i);
						break;
					
					case "Register":
						Register r = new Register();
						CashDrawer cdr = new CashDrawer();
					
						r.setNumber(tokens[1]);
						cdr.setCashAmount(new BigDecimal(tokens[2]));
						r.setCashDrawer(cdr);
						store.addRegister(r);
					
						break;
					
					case "Session":
						Session session = new Session();
						Cashier cs = store.findCashierForNumber(tokens[1]);
						Register rs = store.findRegisterByNumber(tokens[2]);
					
						session.setCashier(cs);
						session.setRegister(rs);
						
						rs.setSession(session);
						cs.addSession(session);
						
						currentSession = session;
						store.addSession(currentSession);
						break;
						
					case "Sale":
						Sale sale = new Sale();
					
						sale.setTaxFree(Boolean.valueOf(tokens[1]));
						currentSale = sale;
						currentSession.addSale(currentSale);
						
						break;
					
					case "SaleLineItem":
						SaleLineItem sli = new SaleLineItem();
					
						sli.setItem(store.findItemForNumber(tokens[1]));
						sli.setQuantity(tokens[2]);
						currentSale.addSaleLineItem(sli);
					
						break;
						
					case "Payment":
						if(tokens[1].equals("Cash")) {
							Cash pc = new Cash(tokens[2], tokens[3]);
							currentSale.addPayment(pc);
						}
						else if(tokens[1].equals("Credit")) {
							Credit payC = new Credit(tokens[2], tokens[3], tokens[4], tokens[5]);
							currentSale.addPayment(payC);
						}
						else if(tokens[1].equals("Check")) {
							Check checkP = new Check(tokens[2], tokens[4], tokens[3], tokens[5]);
							currentSale.addPayment(checkP);
						}
						
						break;
				}
			}
			System.out.println("\nStore: " + store.getName() + " (#" 
					+ store.getNumber() + ")\n===============");
			System.out.println("Cashiers\n===============");
			for(Cashier c : store.getCashiers().values()) {
				System.out.println("Cashier #:" + c.getNumber() + " " + c.getPerson().getName());
			}
			System.out.println("===============\nRegisters\n===============");
			for(Register r : store.getRegisters().values()) {
				System.out.println("Register #:" + r.getNumber() + ", Cash Amount: $" + r.getCashDrawer().getCashAmount());
			}
			System.out.println("===============\nItems\n===============");
			for (Item i : store.getItems().values()) {
			    System.out.println(i.getNumber() + ", " + i.getDescription() + ", Price: $" + i.getPriceForDate(LocalDate.now())
			    
			    + ", Tax Rate: " + i.getTaxRateForDate(LocalDate.now()) + ", " + i.getuPCs().toString());    
			}
			System.out.println("===============\nSessions\n===============");
//			for(Session s : store.getSessions()) {
////				System.out.println("Session: Cashier: " + s.getCashier() + ", Register #" + 
////						s.getRegister().getNumber() + ", Date: " + s.getStartDateTime() + ", \nTotal: $" + s.calcTotal());
////				for(Sale sale : s.getSales())
////				System.out.println("\tSale : SubTotal: " + sale.calcSubTotal() + ", Tax: $" 
////				+ store.getItems().get().getTaxRateForDate(LocalDate.now()));
//				
//				System.out.println(s.toString());
//			}
			for (Session s : store.getSessions()) {
			    System.out.println(s.toString());
			    
			    for (Sale sale : s.getSales()) {
			        System.out.println("\t" + sale.toString());
			        
			        for (SaleLineItem sli : sale.getSaleLineItems()) {
			            System.out.println("\t\t" + sli.toString());
			        }
			    }
			    System.out.println();
			}			
			theBufferedReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Cannot open file: " + fileName);
		} catch (IOException e) {
			System.out.println("Error while reading file: " + fileName);
		}
	}

	private static LocalDate parseDate(String dateStr) {
	    if (dateStr == null || dateStr.trim().isEmpty()) {
	        return null;
	    }
	    
	    // First format: "M/d/yyyy" (e.g. "9/30/2026", "10/31/2026")
	    DateTimeFormatter mdYFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	    
	    try {
	        return LocalDate.parse(dateStr.trim(), mdYFormatter);
	    } catch (Exception e) {
	        // Fallback format: standard ISO "yyyy-MM-dd" (e.g. "2026-01-01")
	        return LocalDate.parse(dateStr.trim());
	    }
	}
}
