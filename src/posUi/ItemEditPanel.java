package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import posPd.Item;
import posPd.Price;
import posPd.Store;
import posPd.TaxRate;
import posPd.UPC;

import javax.swing.JList;
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
	
	private DefaultListModel<Price> priceListModel;
	private DefaultListModel<UPC> UPCListModel;
	
	private JList<Price> PriceList;
	private JList<UPC> UPCList;

	/**
	 * Create the panel.
	 */
	public ItemEditPanel(JFrame currentFrame, Store aStore, Item i, boolean isAdd) {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				priceListModel = new DefaultListModel<Price>();
				UPCListModel = new DefaultListModel<UPC>();
			
				priceListModel.addAll(i.getPrices());
				UPCListModel.addAll(i.getuPCs());
				
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
		lblEditItem.setBounds(179, 34, 46, 14);
		add(lblEditItem);
		
		JLabel ItemNumberlbl = new JLabel("Item Number:");
		ItemNumberlbl.setBounds(44, 79, 72, 14);
		add(ItemNumberlbl);
		
		UPCListModel = new DefaultListModel<UPC>();
		UPCListModel.addAll(i.getuPCs());
		UPCList = new JList(UPCListModel);
		UPCList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		UPCList.setBounds(277, 33, 122, 72);
		add(UPCList);
		
		priceListModel = new DefaultListModel<Price>();
		priceListModel.addAll(i.getPrices());
		PriceList = new JList(priceListModel);
		PriceList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		PriceList.setBounds(277, 177, 122, 53);
		add(PriceList);
		
		JButton UPCEditButton = new JButton("Edit");
		UPCEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UPCEditButton.setBounds(344, 116, 55, 23);
		add(UPCEditButton);
		
		JButton UPCAddButton = new JButton("Add");
		UPCAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UPCAddButton.setBounds(277, 116, 55, 23);
		add(UPCAddButton);
		
		JButton PriceAddButton = new JButton("Add");
		PriceAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PriceAddButton.setBounds(277, 241, 55, 23);
		add(PriceAddButton);
		
		JButton PriceEditButton = new JButton("Edit");
		PriceEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PriceEditButton.setBounds(344, 241, 55, 23);
		add(PriceEditButton);
		
		JButton PriceDeleteButton = new JButton("Delete");
		PriceDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PriceDeleteButton.setBounds(301, 266, 72, 23);
		add(PriceDeleteButton);
		
		JButton UPCDeleteButton = new JButton("Delete");
		UPCDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UPCDeleteButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		UPCDeleteButton.setBounds(301, 143, 72, 23);
		add(UPCDeleteButton);
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SaveButton.setBounds(39, 227, 89, 23);
		add(SaveButton);
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CancelButton.setBounds(150, 227, 89, 23);
		add(CancelButton);
		
		ItemNumberField = new JTextField();
		ItemNumberField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ItemNumberField.setBounds(121, 76, 86, 20);
		add(ItemNumberField);
		ItemNumberField.setColumns(10);
		
		JLabel Descriptionlbl = new JLabel("Description:");
		Descriptionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Descriptionlbl.setBounds(39, 120, 65, 14);
		add(Descriptionlbl);
		
		JLabel TaxCategorylbl = new JLabel("Tax Category:");
		TaxCategorylbl.setBounds(39, 151, 72, 14);
		add(TaxCategorylbl);
		
		DescriptionField = new JTextField();
		DescriptionField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		DescriptionField.setBounds(108, 117, 149, 20);
		add(DescriptionField);
		DescriptionField.setColumns(10);
		
		JComboBox TaxCategoryBox = new JComboBox();
		TaxCategoryBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		TaxCategoryBox.setBounds(121, 147, 86, 22);
		add(TaxCategoryBox);

	}
}
