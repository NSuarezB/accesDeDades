package VISTA;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frmMain dialog = new frmMain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmMain() {
		setTitle("Acces als clients");
		setBounds(100, 100, 607, 458);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnOpcions = new JMenu("Opcions");
				menuBar.add(mnOpcions);
				{
					JButton btnGesti = new JButton("Gestió de comandes");
					JButton btnClient = new JButton("Client");
					
					
					btnClient.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							provas sc;
							try {
								sc = new provas();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							provas.screen();
						}
					});
					
					btnGesti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frmComanda sc2;
							try {
								sc2 = new frmComanda();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							frmComanda.screen2();
						}
					});
					
					mnOpcions.add(btnClient);
					mnOpcions.add(btnGesti);
				}
				
			}
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
