package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import posPd.Item;
import posPd.Price;
import posPd.Store;
import posPd.TaxCategory;
import posPd.TaxRate;
import posPd.UPC;

import javax.swing.JList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField ItemNumberField;
	private JTextField DescriptionField;
	
	private JPanel currentPanel;
	
	private DefaultComboBoxModel<TaxCategory> TaxCategoryListModel;
	private DefaultListModel<Price> priceListModel;
	private DefaultListModel<UPC> UPCListModel;
	
	
	private JComboBox<TaxCategory> TaxCategoryBox;
	private JList<Price> PriceList;
	private JList<UPC> UPCList;

	
	private JButton UPCEditButton;
	private JButton UPCAddButton;
	private JButton UPCDeleteButton;
	private JButton PriceEditButton;
	private JButton PriceAddButton;
	private JButton PriceDeleteButton;
	
	/**
	 * Create the panel.
	 */
	public ItemEditPanel(JFrame currentFrame, Store aStore, Item i, boolean isAdd) {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				TaxCategoryListModel = new DefaultComboBoxModel<TaxCategory>();
				priceListModel = new DefaultListModel<Price>();
				UPCListModel = new DefaultListModel<UPC>();
				
				TaxCategoryListModel.addAll(aStore.getTaxCategories().values());
				priceListModel.addAll(i.getPrices());
				UPCListModel.addAll(i.getuPCs());
				
				TaxCategoryBox.setModel(TaxCategoryListModel);
				PriceList.setModel(priceListModel);
				UPCList.setModel(UPCListModel);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setLayout(null);
		
		currentPanel = this;
		
		JLabel lblEditItem = new JLabel("Edit Item");
		lblEditItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditItem.setBounds(179, 34, 58, 14);
		add(lblEditItem);
		
		JLabel ItemNumberlbl = new JLabel("Item Number:");
		ItemNumberlbl.setBounds(36, 79, 89, 14);
		add(ItemNumberlbl);
		
		JLabel Descriptionlbl = new JLabel("Description:");
		Descriptionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Descriptionlbl.setBounds(24, 121, 101, 14);
		add(Descriptionlbl);
		
		JLabel TaxCategorylbl = new JLabel("Tax Category:");
		TaxCategorylbl.setBounds(36, 153, 89, 14);
		add(TaxCategorylbl);
		
		/*
		 *  LIST MODELS
		 */
		
		UPCListModel = new DefaultListModel<UPC>();
		UPCListModel.addAll(i.getuPCs());
		UPCList = new JList<UPC>(UPCListModel);
		UPCList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("List Value Changed");
				
				UPC u = UPCList.getSelectedValue();
				
				if(u != null) {
					UPCEditButton.setEnabled(true);
					UPCDeleteButton.setEnabled(true);
				}
				else {
					UPCEditButton.setEnabled(true);
					UPCDeleteButton.setEnabled(true);
				}
				
			}
		});
		UPCList.setBounds(372, 34, 122, 72);
		add(UPCList);
		
		priceListModel = new DefaultListModel<Price>();
		priceListModel.addAll(i.getPrices());
		PriceList = new JList<Price>(priceListModel);
		PriceList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("List Value Changed");
				
				Price p = PriceList.getSelectedValue();
				
				if(p != null) {
					PriceEditButton.setEnabled(true);
					PriceDeleteButton.setEnabled(true);
				}
				else {
					PriceEditButton.setEnabled(true);
					PriceDeleteButton.setEnabled(true);
				}
			}
		});
		PriceList.setBounds(372, 178, 122, 53);
		add(PriceList);
		
		/*
		 *  UPC BUTTONS
		 */
		
		UPCEditButton = new JButton("Edit");
		UPCEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
				
				UPC u = UPCList.getSelectedValue();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, aStore, i, u, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		UPCEditButton.setBounds(439, 117, 72, 23);
		add(UPCEditButton);
		
		UPCAddButton = new JButton("Add");
		UPCAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Clicked");
				
				UPC u = new UPC();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, aStore, i, u, true));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		UPCAddButton.setBounds(357, 117, 72, 23);
		add(UPCAddButton);
		
		UPCDeleteButton = new JButton("Delete");
		UPCDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
				
				aStore.removeUPC(UPCList.getSelectedValue());
				UPCList
			}
		});
		UPCDeleteButton.setBounds(396, 144, 72, 23);
		add(UPCDeleteButton);
		
		/*
		 *  PRICE BUTTONS
		 */
		
		PriceAddButton = new JButton("Add");
		PriceAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Clicked");
				
				Price p = new Price();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, aStore, i, p, true));
				currentFrame.getContentPane().revalidate();
			
			}
		});
		PriceAddButton.setBounds(357, 242, 72, 23);
		add(PriceAddButton);
		
		PriceEditButton = new JButton("Edit");
		PriceEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
				
				Price p = PriceList.getSelectedValue();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, aStore, i, p, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		PriceEditButton.setBounds(439, 242, 72, 23);
		add(PriceEditButton);
		
		PriceDeleteButton = new JButton("Delete");
		PriceDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
				
			}
		});
		PriceDeleteButton.setBounds(396, 267, 72, 23);
		add(PriceDeleteButton);
		
		/*
		 *  SAVE & CANCEL BUTTONS
		 */
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
				
				TaxCategory tc = new TaxCategory();
				tc.setCategory(TaxCategoryBox.getSelectedItem().toString());
				
				i.setDescription(DescriptionField.getText());
				i.setNumber(ItemNumberField.getText());
				i.setTaxCategory(tc);
				
				if(isAdd) {
					aStore.addItem(i);	
				}
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame, aStore));
				currentFrame.getContentPane().revalidate();
			}
		});
		SaveButton.setBounds(68, 227, 89, 23);
		add(SaveButton);
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel Clicked");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame, aStore));
				currentFrame.getContentPane().revalidate();
			}
		});
		CancelButton.setBounds(235, 227, 89, 23);
		add(CancelButton);
		
		/*
		 *  FIELDS
		 */
		Price p = new Price();
		
		currentFrame.getContentPane().removeAll();
		currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, aStore, i, p, true));
		currentFrame.getContentPane().revalidate(); 		
		ItemNumberField = new JTextField(i.getNumber());
		ItemNumberField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ItemNumberField.setBounds(135, 76, 114, 20);
		add(ItemNumberField);
		ItemNumberField.setColumns(10);
		
		DescriptionField = new JTextField(i.getDescription());
		DescriptionField.setBounds(135, 118, 134, 20);
		add(DescriptionField);
		DescriptionField.setColumns(10);
		
		/*
		 *  MISC
		 */
		
		TaxCategoryListModel = new DefaultComboBoxModel<TaxCategory>();
		TaxCategoryListModel.addAll(aStore.getTaxCategories().values());
		TaxCategoryBox = new JComboBox<TaxCategory>();
		TaxCategoryBox.setBounds(135, 149, 148, 22);
		add(TaxCategoryBox);

		UPCEditButton.setEnabled(false);
		PriceEditButton.setEnabled(false);
		PriceDeleteButton.setEnabled(false);
		UPCDeleteButton.setEnabled(false);
	}
}
