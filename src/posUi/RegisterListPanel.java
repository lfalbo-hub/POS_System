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
import posPd.Register;
import posPd.Store;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	/**
	 * Create the panel.
	 * @param currentFrame 
	 */
	public RegisterListPanel(JFrame currentFrame, Store theStore) {
		setLayout(null);
		
		JLabel lblRegisterListLabel = new JLabel("Register List");
		lblRegisterListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterListLabel.setBounds(172, 31, 106, 14);
		add(lblRegisterListLabel);
		
		DefaultListModel<Register> listModel = new DefaultListModel<Register>();
		
		listModel.addAll(theStore.getRegisters().values());
		
		JList registerList = new JList(listModel);
		registerList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("List Value Changed");
			}
		});
		registerList.setBounds(167, 56, 115, 130);
		add(registerList);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Clicked");
			}
		});
		btnAdd.setBounds(65, 197, 89, 23);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
			}
		});
		btnEdit.setBounds(180, 197, 89, 23);
		add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
			}
		});
		btnDelete.setBounds(287, 197, 89, 23);
		add(btnDelete);
		
		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);
	}
}