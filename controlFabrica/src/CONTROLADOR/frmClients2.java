package CONTROLADOR;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;

public class frmClients2 extends JDialog {

	public JLabel Title;
    private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmClients2 dialog = new frmClients2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmClients2() {
		
	
	}
	
	
	//label.setFont(new Font("Tahoma", Font.BOLD, 12));
	
	//.add(label);
	
	

}
