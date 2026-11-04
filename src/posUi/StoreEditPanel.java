package posUi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import posPd.Store;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtStoreName;

	/**
	 * Create the panel.
	 * @param theStore 
	 */
	public StoreEditPanel(JFrame currentFrame, Store theStore) {
		setLayout(null);
		
		JLabel lblStoreEdit = new JLabel("Store Edit");
		lblStoreEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStoreEdit.setBounds(166, 58, 118, 43);
		add(lblStoreEdit);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(43, 116, 91, 14);
		add(lblNewLabel);
		
		txtStoreName = new JTextField();
		txtStoreName.setBounds(155, 113, 140, 20);
		add(txtStoreName);
		txtStoreName.setColumns(10);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Clicked");
				
				theStore.setName(txtStoreName.getText());
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PosHomePanel(currentFrame, theStore));
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
				currentFrame.getContentPane().add(new PosHomePanel(currentFrame, theStore));
				currentFrame.getContentPane().revalidate();		
			}
		});
		btnCancelButton.setBounds(269, 190, 89, 23);
		add(btnCancelButton);

	}
}
