package posUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import posPd.Store;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame currentFrame;

	/**
	 * Launch the application.
	 */
	public static void run(Store theStore) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PosFrame frame = new PosFrame(theStore);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param theStore 
	 */
	public PosFrame(Store theStore) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		
		currentFrame = this;
		
		setTitle("Point of Sale");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMaintenance = new JMenu("Maintenance");
		menuBar.add(mnMaintenance);
		
		JMenuItem mntmStore = new JMenuItem("Store");
		mntmStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().removeAll();
				getContentPane().add(new StoreEditPanel(currentFrame, theStore));
				getContentPane().revalidate();
				System.out.println("Store Menu Clicked");
			}
		});
		mnMaintenance.add(mntmStore);
		
		JMenuItem mntmCashiers = new JMenuItem("Cashiers");
		mntmCashiers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cashier Menu Clicked");
				
				getContentPane().removeAll();
				getContentPane().add(new CashierListPanel(currentFrame, theStore));
				getContentPane().revalidate();
				
			}
		});
		mnMaintenance.add(mntmCashiers);
		
		JMenuItem mntmRegisters = new JMenuItem("Registers");
		mntmRegisters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Register Menu Clicked");
				
				getContentPane().removeAll();
				getContentPane().add(new RegisterListPanel(currentFrame, theStore));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmRegisters);
		
		JMenuItem mntmItem = new JMenuItem("Items");
		mntmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Item Menu Clicked");
				
				getContentPane().removeAll();
				getContentPane().add(new ItemListPanel(currentFrame, theStore));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmItem);
		
		JMenuItem mntmTaxCategories = new JMenuItem("Tax Categories");
		mntmTaxCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Tax Category Menu Clicked");
				
				getContentPane().removeAll();
				getContentPane().add(new TaxCategoryListPanel(currentFrame, theStore));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmTaxCategories);
	
		JMenu mnPOS = new JMenu("POS");
		menuBar.add(mnPOS);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Login Clicked");
			}
		});
		mnPOS.add(mntmLogin);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmDailySalesReport = new JMenuItem("Daily Sales");
		mntmDailySalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Daily Sales Clicked");
			}
		});
		mnReports.add(mntmDailySalesReport);
		
		JMenuItem mntmItemSalesReport = new JMenuItem("Item Sales");
		mntmItemSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Item Sales Clicked");
			}
		});
		mnReports.add(mntmItemSalesReport);
		
		JMenuItem mntmCashierSalesReport = new JMenuItem("Cashier Sales");
		mntmCashierSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cashier Sales Clicked");
			}
		});
		mnReports.add(mntmCashierSalesReport);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		getContentPane().removeAll();
		getContentPane().add(new PosHomePanel(currentFrame, theStore));
		getContentPane().revalidate();
	}

}
