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
	private JButton btnEdit;
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
					btnEdit.setEnabled(true);			
					btnDelete.setEnabled(true);
				}	
				else {
					btnEdit.setEnabled(false);
					btnDelete.setEnabled(true);
				}
			}
		});
		cashierList.setBounds(167, 56, 115, 130);
		add(cashierList);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Clicked");
				
				Cashier c = new Cashier();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, theStore, c,true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(65, 197, 89, 23);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
				
				Cashier c = cashierList.getSelectedValue();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, theStore, c, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(180, 197, 89, 23);
		add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
				
				theStore.removeCashier(cashierList.getSelectedValue());
				listModel.removeElement(cashierList.getSelectedValue());
			}
		});
		btnDelete.setBounds(287, 197, 89, 23);
		add(btnDelete);
		
		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);
	}
}
