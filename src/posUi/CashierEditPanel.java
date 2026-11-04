package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CashierEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel() {
		setLayout(null);
		
		JLabel lblEditCashier = new JLabel("Edit Cashier");
		lblEditCashier.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditCashier.setBounds(176, 34, 97, 16);
		add(lblEditCashier);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumber.setBounds(27, 67, 61, 16);
		add(lblNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(98, 62, 97, 26);
		add(textField);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(27, 100, 61, 16);
		add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 95, 130, 26);
		add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setBounds(27, 133, 61, 16);
		add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(98, 128, 130, 26);
		add(textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setBounds(27, 166, 61, 16);
		add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(98, 161, 130, 26);
		add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setBounds(27, 199, 61, 16);
		add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(98, 194, 130, 26);
		add(textField_4);
		
		JLabel lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSSN.setBounds(209, 67, 42, 16);
		add(lblSSN);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(263, 62, 156, 26);
		add(textField_5);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(6, 232, 82, 16);
		add(lblPassword);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(98, 227, 130, 26);
		add(textField_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("State:");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7.setBounds(240, 133, 38, 16);
		add(lblNewLabel_1_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(279, 128, 32, 26);
		add(textField_7);
		
		JLabel lblZip = new JLabel("Zip:");
		lblZip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZip.setBounds(325, 133, 32, 16);
		add(lblZip);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(369, 128, 82, 26);
		add(textField_8);

	}
}
