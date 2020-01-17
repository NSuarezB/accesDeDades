package CONTROLADOR;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DropMode;
import java.awt.SystemColor;
import javax.swing.Box;
import javax.swing.border.CompoundBorder;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.awt.Button;
import javax.swing.JScrollPane;

public class frmClients extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		try {
			frmClients dialog = new frmClients();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frmClients() {
		setTitle("Acces dades dels clients");
		setBounds(100, 100, 734, 510);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		getContentPane().add(panel_2, gbc_panel_2);

		Label label = new Label("idClient");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		panel_2.add(label);
		
		Label label_1 = new Label("Nom de l'empresa");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setAlignment(Label.CENTER);
		panel_2.add(label_1);
		
		Label label_2 = new Label("Persona de contacte");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setAlignment(Label.CENTER);
		panel_2.add(label_2);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		Label label_3 = new Label("Localització");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label_3);
		
		Label label_4 = new Label("Codi postal");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label_4);
		
		Label label_5 = new Label("Morositat");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(label_5);
		
		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel_2.add(chckbxNewCheckBox);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 10;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		getContentPane().add(panel_1, gbc_panel_1);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 13;
		getContentPane().add(panel, gbc_panel);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new EmptyBorder(5, 650, 5, 5));
		panel.add(panel_23);
		
		JButton btnNewButton = new JButton("Editar");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Esborrar");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Afegir");
		panel.add(btnNewButton_2);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new EmptyBorder(5, 350, 5, 5));
		
		panel.add(panel_22);
		
		JButton btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
	}

}
