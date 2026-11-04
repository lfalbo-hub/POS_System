package posUi;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import posPd.Cashier;
import posPd.Store;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnDelete;
	
	/**
	 * Create the panel.
	 * @param currentFrame 
	 */
	public CashierListPanel(JFrame currentFrame, Store theStore) {
		setLayout(null);
		
		JLabel lblCashierListLabel = new JLabel("Cashier List");
		lblCashierListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashierListLabel.setBounds(172, 31, 106, 14);
		add(lblCashierListLabel);
		
		DefaultListModel<Cashier> listModel = new DefaultListModel<Cashier>();
		
		listModel.addAll(theStore.getCashiers().values());
		
		JList<Cashier> cashierList = new JList(listModel);
		cashierList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("List Value Changed");
				
				Cashier c = cashierList.getSelectedValue();
				if(c != null) {
					btnAdd.setEnabled(true);			
					btnDelete.setEnabled(true);
				}	
				else {
					btnAdd.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		cashierList.setBounds(167, 56, 115, 130);
		add(cashierList);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Clicked");
			}
		});
		btnAdd.setBounds(65, 197, 89, 23);
		add(btnAdd);
		
		btnAdd = new JButton("Edit");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
			}
		});
		btnAdd.setBounds(180, 197, 89, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
			}
		});
		btnDelete.setBounds(287, 197, 89, 23);
		add(btnDelete);
		
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
	}
}
