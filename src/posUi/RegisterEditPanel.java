package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import posPd.Register;
import posPd.Store;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtRegisterNumber;

	/**
	 * Create the panel.
	 * @param theStore 
	 */
	public RegisterEditPanel(JFrame currentFrame, Store theStore, Register r, boolean isAdd) {
		setLayout(null);
		
		JLabel lblRegisterEdit = new JLabel("Edit Register");
		lblRegisterEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegisterEdit.setBounds(166, 58, 118, 43);
		add(lblRegisterEdit);
		
		JLabel lblNewLabel = new JLabel("Register Number:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(43, 116, 91, 14);
		add(lblNewLabel);
		
		txtRegisterNumber = new JTextField(r.getNumber());
		txtRegisterNumber.setBounds(155, 113, 140, 20);
		add(txtRegisterNumber);
		txtRegisterNumber.setColumns(10);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
				
				if(isAdd) {
					theStore.addRegister(r);
				}
				
				r.setNumber(txtRegisterNumber.getText());
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame, theStore));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSaveButton.setBounds(90, 190, 89, 23);
		add(btnSaveButton);
		
		JButton btnCancelButton = new JButton("Cancel");
		btnCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancel Clicked");
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame, theStore));
				currentFrame.getContentPane().revalidate();		
			}
		});
		btnCancelButton.setBounds(269, 190, 89, 23);
		add(btnCancelButton);

	}
}
