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
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
			}
		});
		btnSaveButton.setBounds(65, 197, 89, 23);
		add(btnSaveButton);
		
		JButton btnEditButton = new JButton("Edit");
		btnEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
			}
		});
		btnEditButton.setBounds(180, 197, 89, 23);
		add(btnEditButton);
		
		JButton btnDeleteButton = new JButton("Delete");
		btnDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
			}
		});
		btnDeleteButton.setBounds(287, 197, 89, 23);
		add(btnDeleteButton);
		

	}
}