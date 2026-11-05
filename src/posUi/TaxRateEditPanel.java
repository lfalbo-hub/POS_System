package posUi;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import posPd.Store;
import posPd.TaxCategory;
import posPd.TaxRate;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TaxRateEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTaxRateField;
	private JTextField txtEffectiveDateField;

	/**
	 * Create the panel.
	 * @param actionListener 
	 */
	public TaxRateEditPanel(JFrame currentFrame, Store theStore, JPanel parentPanel, TaxCategory tc, TaxRate tr, boolean isAdd) {
		setLayout(null);
		
		JLabel lblTaxRateEdit = new JLabel("Tax Rate Edit");
		lblTaxRateEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxRateEdit.setBounds(150, 27, 95, 14);
		add(lblTaxRateEdit);
		
		
		
		JLabel lblTaxRate = new JLabel("Tax Rate:");
		lblTaxRate.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxRate.setBounds(51, 70, 91, 14);
		add(lblTaxRate);
		
		JLabel lblEffectiveDate = new JLabel("Effective Date:");
		lblEffectiveDate.setBounds(51, 109, 91, 14);
		add(lblEffectiveDate);
		
		txtTaxRateField = new JTextField(tr.getTaxRate().toString());
		txtTaxRateField.setBounds(139, 67, 86, 20);
		add(txtTaxRateField);
		txtTaxRateField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
				
				tr.setTaxRate(new BigDecimal(txtTaxRateField.getText()));
				tr.setEffectiveDate(txtEffectiveDateField.getText());
				
				if(isAdd) {
					tc.addTaxRate(tr);
				}
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(parentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
				
			}
		});
		btnSave.setBounds(90, 234, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel Clicked");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(parentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnCancel.setBounds(269, 234, 89, 23);
		add(btnCancel);
		
		txtEffectiveDateField = new JTextField(tr.getEffectiveDate().toString());
		txtEffectiveDateField.setBounds(139, 106, 86, 20);
		add(txtEffectiveDateField);
		txtEffectiveDateField.setColumns(10);

		if(!isAdd) {
			txtTaxRateField.setText(tr.getTaxRate().toString());
			txtEffectiveDateField.setText(tr.getEffectiveDate().format(DateTimeFormatter.ofPattern("M/d/yyyy")));
			//txtEffectiveDateField.setText(tr.getEffectiveDate().toString());
		}
		
	}

}
