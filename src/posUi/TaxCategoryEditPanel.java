package posUi;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPd.Store;
import posPd.TaxCategory;
import posPd.TaxRate;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class TaxCategoryEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JPanel currentPanel;
	private DefaultListModel<TaxRate> listModel;
	private JList<TaxRate> list;
	/**
	 * Create the panel.
	 * @param b 
	 * @param atc 
	 */
	public TaxCategoryEditPanel(JFrame currentFrame, Store aStore, TaxCategory atc, boolean isAdd) {
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				
				listModel = new DefaultListModel<TaxRate>();
				
				listModel.addAll(atc.getTaxRates());
				
				list.setModel(listModel);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		setLayout(null);
		
		currentPanel = this;
		
		JLabel lblTaxCategoryEdit = new JLabel("Tax Category Edit");
		lblTaxCategoryEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxCategoryEdit.setBounds(157, 33, 135, 14);
		add(lblTaxCategoryEdit);
		
		JLabel lblCategoryName = new JLabel("Category Name:");
		lblCategoryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoryName.setBounds(10, 61, 96, 14);
		add(lblCategoryName);
		
		listModel = new DefaultListModel<TaxRate>();
		listModel.addAll(atc.getTaxRates());
		list = new JList<TaxRate>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				System.out.println("TaxRate list selection changed");
				
				TaxRate tr = list.getSelectedValue();
				
				if(tr != null) {
					btnEdit.setEnabled(true);
				}
				else {
					btnEdit.setEnabled(false);	
				}
			}
		});
		list.setBounds(212, 58, 135, 144);
		add(list);
		
		textField = new JTextField(atc.getCategory());
		textField.setBounds(104, 58, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
				
				atc.setCategory(textField.getText());
				
				if(isAdd) {
					aStore.addTaxCategory(atc);
				}
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryListPanel(currentFrame, aStore));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(24, 250, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel Clicked");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryListPanel(currentFrame, aStore));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(134, 250, 89, 23);
		add(btnCancel);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add Clicked");
				
				TaxRate tr = new TaxRate();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, aStore, currentPanel , atc, tr, true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(157, 213, 75, 23);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Clicked");
				
				TaxRate tr = list.getSelectedValue();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, aStore, currentPanel, atc, tr, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(242, 213, 75, 23);
		add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Delete Clicked");
				
				atc.removeTaxRate(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnDelete.setBounds(323, 213, 75, 23);
		add(btnDelete);

		btnEdit.setEnabled(false);
//		btnAdd.setEnabled(true);
		btnDelete.setEnabled(true);
		
	}

}
