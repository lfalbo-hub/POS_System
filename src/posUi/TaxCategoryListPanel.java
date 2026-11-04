package posUi;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import posPd.Store;
import posPd.TaxCategory;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class  TaxCategoryListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	
	/**
	 * Create the panel.
	 * @param currentFrame 
	 */
	public TaxCategoryListPanel(JFrame currentFrame, Store theStore) {
		setLayout(null);
		
		JLabel lblTaxCategoryListLabel = new JLabel("Tax Category List");
		lblTaxCategoryListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxCategoryListLabel.setBounds(154, 30, 141, 14);
		add(lblTaxCategoryListLabel);
		
		DefaultListModel<TaxCategory> listModel = new DefaultListModel<TaxCategory>();
		
		listModel.addAll(theStore.getTaxCategories().values());
		
		JList<TaxCategory> TaxCategoryList = new JList(listModel);
		TaxCategoryList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("List Value Changed");
				
				TaxCategory tc = TaxCategoryList.getSelectedValue();
				
				if(tc != null) {
					btnEdit.setEnabled(true);
					
					if(theStore.isTaxCategoryUsed(tc)) {
						btnDelete.setEnabled(false);
					} else {
						btnEdit.setEnabled(true);
						btnDelete.setEnabled(false);
					}
				} else {
					btnEdit.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		TaxCategoryList.setBounds(167, 56, 115, 130);
		add(TaxCategoryList);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
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
