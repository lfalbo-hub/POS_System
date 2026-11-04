package posUi;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import posPd.Store;

import java.awt.Font;

public class PosHomePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param currentFrame 
	 */
	public PosHomePanel(JFrame currentFrame, Store theStore) {
		setLayout(null);
		
		JLabel lblStoreName = new JLabel(theStore.getName());
		lblStoreName.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblStoreName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreName.setBounds(135, 38, 180, 52);
		add(lblStoreName);

	}
}
