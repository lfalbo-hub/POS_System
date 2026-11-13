package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import posPd.Item;
import posPd.Price;
import posPd.PromoPrice;
import posPd.Store;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

public class PriceEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPrice;
	private JTextField txtEffectiveDate;

	JCheckBox chckbxPromoPrice;
	/**
	 * Create the panel.
	 * @param theStore 
	 */
	public PriceEditPanel(JFrame currentFrame, JPanel parentPanel, Store theStore, Item i, Price p, boolean isAdd) {
		setLayout(null);
		
		JLabel lblPriceEdit = new JLabel("Edit Price");
		lblPriceEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceEdit.setBounds(155, 27, 118, 43);
		add(lblPriceEdit);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setBounds(43, 116, 91, 14);
		add(lblPrice);
		
		JLabel lblEffectiveDate = new JLabel("Effective Date:");
		lblEffectiveDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEffectiveDate.setBounds(43, 153, 91, 14);
		add(lblEffectiveDate);
		
		txtPrice = new JTextField(p.getPrice().toString());
		txtPrice.setBounds(155, 113, 140, 20);
		add(txtPrice);
		txtPrice.setColumns(10);
		
		txtEffectiveDate = new JTextField(p.getEffectiveDate().toString());
		txtEffectiveDate.setBounds(155, 150, 140, 20);
		add(txtEffectiveDate);
		txtEffectiveDate.setColumns(10);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
				
				if(isAdd) {
					if(chckbxPromoPrice.isSelected())  {
						PromoPrice pp = new PromoPrice(); 
					
						LocalDate newDate = LocalDate.parse(txtEffectiveDate.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					
						pp.setEffectiveDate(newDate);
						pp.setPrice(new BigDecimal(txtPrice.getText()));
						pp.setItem(i);
					
						i.addPrice(pp);
					}
					else {
						p.setPrice(new BigDecimal(txtPrice.getText()));
						i.addPrice(p);
					}	
				}	
							
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(parentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			
			}
		});
		btnSaveButton.setBounds(90, 190, 89, 23);
		add(btnSaveButton);
		
		JButton btnCancelButton = new JButton("Cancel");
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel Clicked");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(parentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();	
			}
		});
		btnCancelButton.setBounds(269, 190, 89, 23);
		add(btnCancelButton);
		
		chckbxPromoPrice = new JCheckBox("Promo Price");
		chckbxPromoPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chckbxPromoPrice.setBounds(155, 70, 130, 23);
		add(chckbxPromoPrice);

		
	}
}
