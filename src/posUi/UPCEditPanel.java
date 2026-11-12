package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import posPd.Item;
import posPd.Store;
import posPd.UPC;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UPCEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUPC;

	/**
	 * Create the panel.
	 * @param theStore 
	 */
	public UPCEditPanel(JFrame currentFrame, JPanel parentPanel, Store theStore, Item i, UPC u, boolean isAdd) {
		setLayout(null);
		
		JLabel lblUPCEdit = new JLabel("Edit UPC");
		lblUPCEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblUPCEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUPCEdit.setBounds(166, 58, 118, 43);
		add(lblUPCEdit);
		
		JLabel lblUPC = new JLabel("UPC Code:");
		lblUPC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUPC.setBounds(43, 116, 91, 14);
		add(lblUPC);
		
		txtUPC = new JTextField(u.getuPC());
		txtUPC.setBounds(155, 113, 140, 20);
		add(txtUPC);
		txtUPC.setColumns(10);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
				
				if(isAdd) {
					i.addUPC(u);
					u.setItem(i);
				}
				
				u.setuPC(txtUPC.getText());
				
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

	}
}
