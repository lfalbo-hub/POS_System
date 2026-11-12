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

	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	
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
		
		JList<Item> itemList = new JList(listModel);
		itemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("List Value Changed");
				
				Item i = itemList.getSelectedValue();
				
				if(i != null) {
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
				}
				else {
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
				}
				
			}
		});
		itemList.setBounds(100, 56, 249, 130);
		add(itemList);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Clicked");
				
				Item i = new Item();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, theStore, i, true));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnAdd.setBounds(65, 197, 89, 23);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
				
				Item i = itemList.getSelectedValue();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, theStore, i, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(180, 197, 89, 23);
		add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
				
// TODO Create Check to see if Item is in use if not allow it to be deleted
//				if() {}
				theStore.removeItem(itemList.getSelectedValue());
				
				listModel.removeElement(itemList.getSelectedValue());
				
			}
		});
		btnDelete.setBounds(287, 197, 89, 23);
		add(btnDelete);

		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);
	}
}