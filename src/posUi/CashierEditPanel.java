package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import posPd.Cashier;
import posPd.Person;
import posPd.Store;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNumber;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtPhone;
	private JTextField txtSSN;
	private JTextField txtPassword;
	private JTextField txtState;
	private JTextField txtZip;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel(JFrame currentFrame, Store theStore, Cashier c, boolean isAdd) {
		setLayout(null);
		
		JLabel lblEditCashier = new JLabel("Edit Cashier");
		lblEditCashier.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditCashier.setBounds(176, 34, 97, 16);
		add(lblEditCashier);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumber.setBounds(27, 67, 61, 16);
		add(lblNumber);
		
		txtNumber = new JTextField();
		txtNumber.setColumns(10);
		txtNumber.setBounds(98, 62, 97, 26);
		add(txtNumber);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(27, 100, 61, 16);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(98, 95, 130, 26);
		add(txtName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(27, 133, 61, 16);
		add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(98, 128, 130, 26);
		add(txtAddress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(27, 166, 61, 16);
		add(lblCity);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(98, 161, 130, 26);
		add(txtCity);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(27, 199, 61, 16);
		add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(98, 194, 130, 26);
		add(txtPhone);
		
		JLabel lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSSN.setBounds(209, 67, 42, 16);
		add(lblSSN);
		
		txtSSN = new JTextField();
		txtSSN.setColumns(10);
		txtSSN.setBounds(263, 62, 156, 26);
		add(txtSSN);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(6, 232, 82, 16);
		add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(98, 227, 130, 26);
		add(txtPassword);
		
		JLabel lblNewLabel_1_7 = new JLabel("State:");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7.setBounds(240, 133, 38, 16);
		add(lblNewLabel_1_7);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(279, 128, 32, 26);
		add(txtState);
		
		JLabel lblZip = new JLabel("Zip:");
		lblZip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZip.setBounds(309, 133, 32, 16);
		add(lblZip);
		
		txtZip = new JTextField();
		txtZip.setColumns(10);
		txtZip.setBounds(351, 128, 82, 26);
		add(txtZip);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");

				if(isAdd) {
					Cashier newCashier = new Cashier();
					Person ncp = new Person();
					
					ncp.setCashier(newCashier);
					newCashier.setPerson(ncp);
					
					newCashier.setNumber(txtNumber.getText());
					newCashier.getPerson().setAddress(txtAddress.getText());
					newCashier.getPerson().setCity(txtCity.getText());
					newCashier.getPerson().setState(txtState.getText());
					newCashier.getPerson().setName(txtName.getText());
					newCashier.getPerson().setZip(txtZip.getText());
					newCashier.getPerson().setsSN(txtSSN.getText());
					newCashier.getPerson().setPhone(txtPhone.getText());
					
					theStore.addCashier(newCashier);
				}else {
					c.setNumber(txtNumber.getText());
					c.getPerson().setAddress(txtAddress.getText());
					c.getPerson().setCity(txtCity.getText());
					c.getPerson().setState(txtState.getText());
					c.getPerson().setName(txtName.getText());
					c.getPerson().setZip(txtZip.getText());
					c.getPerson().setsSN(txtSSN.getText());
					c.getPerson().setPhone(txtPhone.getText());
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame, theStore));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnSave.setBounds(54, 264, 114, 26);
		add(btnSave);
		
		JButton lblCancel = new JButton("Cancel");
		lblCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel Clicked");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame, theStore));
				currentFrame.getContentPane().revalidate();	
			}
		});
		lblCancel.setBounds(279, 264, 114, 26);
		add(lblCancel);

	}
}
