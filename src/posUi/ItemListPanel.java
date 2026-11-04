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
import posPd.Item;
import posPd.Store;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param currentFrame 
	 */
	public ItemListPanel(JFrame currentFrame, Store theStore) {
		setLayout(null);
		
		JLabel lblItemListLabel = new JLabel("Item List");
		lblItemListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemListLabel.setBounds(172, 31, 106, 14);
		add(lblItemListLabel);
		
		DefaultListModel<Item> listModel = new DefaultListModel<Item>();
		
		listModel.addAll(theStore.getItems().values());
		
		JList itemList = new JList(listModel);
		itemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("List Value Changed");
				
				
			}
		});
		itemList.setBounds(167, 56, 115, 130);
		add(itemList);
		
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