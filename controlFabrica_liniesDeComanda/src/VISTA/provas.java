package VISTA;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.sun.jdi.connect.spi.Connection;
//import com.sun.org.apache.bcel.internal.generic.Select;
//import com.sun.org.apache.bcel.internal.generic.Select;

import DADES.SQLClients;
import MODEL.Client;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.im.InputContext;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class provas extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 210601883990408438L;
	private Connection conexion = null;
	private Statement comando = null;
	private ResultSet resultados = null;
	private JTable tabla = null;
	DefaultTableModel modelo = null;
	JScrollPane desplazamiento = null;
	Dimension dim = null;
	private JTextField txtIdclient;
	private JTextField txtName;
	private JTextField txtPersonacontacte;
	private JTextField txtLocalitzacio;
	private JTextField txtCodipostal;
	private JCheckBox chckbxMorositat;
	private JButton btnInsert;
	public String idClie, nom, persoContac, local;
	public int cp;
	private JButton btnDelete;
	Object llista = null;
	private int inserUpda;
	private JLabel lblIdclient;
	private JLabel lblName;
	private JLabel lblPersonaCon;
	private JLabel lblLocalitzacio;
	private JLabel lblCp;
	private JButton btnSave;
	private JButton btnUpdate;
	JFrame f;
	private JPanel panel;
	private JPanel panel_1;
	boolean checkSelected;

	/***
	 * 
	 * labels() - Contè tots els elements labels
	 * 
	 * 
	 */
	void labels() {

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);

		lblIdclient = new JLabel("IdClient");
		lblIdclient.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblIdclient = new GridBagConstraints();
		gbc_lblIdclient.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdclient.anchor = GridBagConstraints.EAST;
		gbc_lblIdclient.gridx = 1;
		gbc_lblIdclient.gridy = 2;
		getContentPane().add(lblIdclient, gbc_lblIdclient);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 3;
		gbc_lblName.gridy = 2;
		getContentPane().add(lblName, gbc_lblName);

		lblPersonaCon = new JLabel("Persona\n contacte");
		lblPersonaCon.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblPersonaCon = new GridBagConstraints();
		gbc_lblPersonaCon.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonaCon.anchor = GridBagConstraints.EAST;
		gbc_lblPersonaCon.gridx = 6;
		gbc_lblPersonaCon.gridy = 2;
		getContentPane().add(lblPersonaCon, gbc_lblPersonaCon);

		lblCp = new JLabel("CP");
		lblCp.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblCp = new GridBagConstraints();
		gbc_lblCp.insets = new Insets(0, 0, 5, 5);
		gbc_lblCp.anchor = GridBagConstraints.EAST;
		gbc_lblCp.gridx = 3;
		gbc_lblCp.gridy = 4;
		getContentPane().add(lblCp, gbc_lblCp);

		lblLocalitzacio = new JLabel("Localitzacio");
		lblLocalitzacio.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_lblLocalitzacio = new GridBagConstraints();
		gbc_lblLocalitzacio.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalitzacio.anchor = GridBagConstraints.EAST;
		gbc_lblLocalitzacio.gridx = 1;
		gbc_lblLocalitzacio.gridy = 4;
		getContentPane().add(lblLocalitzacio, gbc_lblLocalitzacio);

	}

	/**
	 * 
	 * textBox() - Conte tots els elements textBox
	 * 
	 * txtIdclient - txtBox idCliet - 1)
	 * 
	 * txtLocalitzacio - txtBox localitzacio - 2)
	 * 
	 * txtCodipostal - txtBox Codi postal - 3)
	 * 
	 * txtName - txtBox nom d'empresa - 4)
	 * 
	 * txtPersonacontacte - txtBox nom dela persona responsable - 5)
	 * 
	 */

	void textBox() {

		txtIdclient = new JTextField();
		txtIdclient.setEditable(false);

		// 1)

		GridBagConstraints gbc_txtIdclient = new GridBagConstraints();
		gbc_txtIdclient.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdclient.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdclient.gridx = 2;
		gbc_txtIdclient.gridy = 2;
		getContentPane().add(txtIdclient, gbc_txtIdclient);
		txtIdclient.setColumns(10);

		// 2)

		txtLocalitzacio = new JTextField();
		txtLocalitzacio.setEditable(false);
		GridBagConstraints gbc_txtLocalitzacio = new GridBagConstraints();
		gbc_txtLocalitzacio.insets = new Insets(0, 0, 5, 5);
		gbc_txtLocalitzacio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLocalitzacio.gridx = 2;
		gbc_txtLocalitzacio.gridy = 4;
		getContentPane().add(txtLocalitzacio, gbc_txtLocalitzacio);
		txtLocalitzacio.setColumns(10);

		// 3)

		txtCodipostal = new JTextField();
		txtCodipostal.setEditable(false);
		GridBagConstraints gbc_txtCodipostal = new GridBagConstraints();
		gbc_txtCodipostal.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodipostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodipostal.gridx = 4;
		gbc_txtCodipostal.gridy = 4;
		getContentPane().add(txtCodipostal, gbc_txtCodipostal);
		txtCodipostal.setColumns(10);

		// 4)

		txtName = new JTextField();
		txtName.setEditable(false);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 4;
		gbc_txtName.gridy = 2;
		getContentPane().add(txtName, gbc_txtName);
		txtName.setColumns(10);

		// 5)

		txtPersonacontacte = new JTextField();
		txtPersonacontacte.setEditable(false);
		GridBagConstraints gbc_txtPersonacontacte = new GridBagConstraints();
		gbc_txtPersonacontacte.insets = new Insets(0, 0, 5, 5);
		gbc_txtPersonacontacte.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPersonacontacte.gridx = 7;
		gbc_txtPersonacontacte.gridy = 2;
		getContentPane().add(txtPersonacontacte, gbc_txtPersonacontacte);
		txtPersonacontacte.setColumns(10);

	}

	/**
	 * 
	 * CheckBox() - Conte un element checkbox
	 * 
	 * 
	 */
	void checkBox() {

		chckbxMorositat = new JCheckBox("Morositat");
		chckbxMorositat.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_chckbxMorositat = new GridBagConstraints();
		gbc_chckbxMorositat.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMorositat.gridx = 6;
		gbc_chckbxMorositat.gridy = 4;
		getContentPane().add(chckbxMorositat, gbc_chckbxMorositat);

	}

	/**
	 * 
	 * textBoxBlanc() - Fa que el contingut del textbox ""
	 * 
	 * 
	 */

	void textBoxBlanc() {

		txtIdclient.setText("");
		txtName.setText("");
		txtPersonacontacte.setText("");
		txtLocalitzacio.setText("");
		txtCodipostal.setText("");

	}

	/**
	 * 
	 * textBoxAvailable() - Habilita la modificació del textBox
	 * 
	 * 
	 */

	void textBoxAvailable() {

		txtPersonacontacte.setEditable(true);
		txtIdclient.setEditable(true);
		txtName.setEditable(true);
		txtLocalitzacio.setEditable(true);
		txtCodipostal.setEditable(true);

	}

	/**
	 * 
	 * textBoxDisable() - Deshabilita la modificació del textBox
	 * 
	 * 
	 */
	void textBoxDisable() {

		txtPersonacontacte.setEditable(false);
		txtIdclient.setEditable(false);
		txtName.setEditable(false);
		txtLocalitzacio.setEditable(false);
		txtCodipostal.setEditable(false);

	}

	void editableTxtUpdate() {

		txtCodipostal.setEditable(true);
		txtName.setEditable(true);
		txtPersonacontacte.setEditable(true);
		txtLocalitzacio.setEditable(true);
		txtIdclient.setEditable(false);

	}

	/**
	 * 
	 * checkBoxControler() - Fa que si el check box, esta en true=1 si no false=0
	 * 
	 * @return
	 */

	int checkBoxControler() {

		int checkSelectInt = 0;
		boolean checkSelect = chckbxMorositat.isSelected();

		if (checkSelect == true) {

			checkSelectInt = 1;

		} else {

			checkSelectInt = 0;

		}

		return checkSelectInt;
	}

	void allBottons() {

		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.anchor = GridBagConstraints.EAST;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 1;
		gbc_btnUpdate.gridy = 12;
		getContentPane().add(btnUpdate, gbc_btnUpdate);

		GridBagConstraints gbc_btnInsert = new GridBagConstraints();
		gbc_btnInsert.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsert.gridx = 2;
		gbc_btnInsert.gridy = 12;
		getContentPane().add(btnInsert, gbc_btnInsert);
		btnInsert.setForeground(new Color(0, 0, 0));
		btnInsert.setFont(new Font("Dialog", Font.BOLD, 12));

	}

	void buttonEnable() {

		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);

	}

	void buttonDisable() {

		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);

	}

	private void cerrar() throws SQLException, IOException {
		conexion.close();
	}

	public provas() throws IOException, SQLException {

		// Nombre de las columnas como apareceran en la tabla
		String[] columnas = { "idClient", "name", "personaContacte", "localitzacio", "codiPostal", "morositat" };
		DefaultTableModel modelo = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		int codiPostal, morositat;
		String idClient, name, personaContacte, localitzacio;

		// Parametros de la ventana
		this.setTitle("Clients");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLayout(new BorderLayout());

		// Modelo de la tabla
		modelo.setColumnIdentifiers(columnas);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 0, 0, 50, 0, 20, 20, 80, 80, 80 };
		gridBagLayout.rowHeights = new int[] { 8, 0, 10, 10, 0, 10, 10, 10, 0, 10, 80, 70, 40, 0 };
		gridBagLayout.columnWeights = new double[] { 10.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		getContentPane().setLayout(gridBagLayout);

		labels();

		textBox();

		checkBox();

		tabla = new JTable();
		tabla.setFont(new Font("Dialog", Font.PLAIN, 12));
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				idClie = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();

				txtIdclient.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
				txtName.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
				txtPersonacontacte.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
				txtLocalitzacio.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
				txtCodipostal.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
				int checkUn = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
				if (checkUn == 0) {

					chckbxMorositat.setSelected(false);

				}
				if (checkUn == 1) {

					chckbxMorositat.setSelected(true);

				}

				buttonEnable();
				/*
				 * nom=tabla.getValueAt(tabla.getSelectedRow(),1).toString();
				 * persoContac=tabla.getValueAt(tabla.getSelectedRow(),2).toString();
				 * local=tabla.getValueAt(tabla.getSelectedRow(),3).toString();
				 * cp=Integer.parseInt((String) tabla.getValueAt(tabla.getSelectedRow(),4));
				 */

			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 12));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idClie = txtIdclient.getText();
				textBoxDisable();
				textBoxBlanc();

				if (idClie.isEmpty()) {

					JOptionPane.showMessageDialog(null, "Has de seleccionar un registre primer!!!");

				} else {

					Object[] options = { "Si", "No" };
					int input = JOptionPane.showOptionDialog(null, "Estas segur de que vols esborrar el registre?",
							"Esborrar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
							options[0]);
					if (input == 0) {

						SQLClients query1 = new SQLClients();
						try {
							query1.deleteData(idClie);
							DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
							tableModel.setRowCount(0);
							query1.consultaClients("clients");
							query1.conectar();

							for (Client client : query1.consultaClients("clients")) {
								modelo.addRow(new Object[] { client.getIdClient(), client.getName(),
										client.getPersonaContacte(), client.getLocalitzacio(), client.getCodiPostal(),
										client.getMorositat() });
							}

							textBoxBlanc();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						JOptionPane.showMessageDialog(null, "El registre s' ha esborrat amb exit!");

					}

					if (input == 1) {

						JOptionPane.showMessageDialog(null, "El registre no s'ha esborrat");

					}

				}

			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.WEST;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 12;
		getContentPane().add(btnDelete, gbc_btnDelete);

		btnInsert = new JButton("Insert");
		btnInsert.setBackground(new Color(192, 192, 192));

		btnInsert.addActionListener(new ActionListener() {

			private Object JFrame;

			public void actionPerformed(ActionEvent arg0) {
				inserUpda = 1;
				textBoxBlanc();

				textBoxAvailable();

			}
		});

		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(211, 211, 211));
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				inserUpda = 2;
				editableTxtUpdate();

			}
		});

		allBottons();
		buttonDisable();

		JScrollPane desplazamiento_1 = new JScrollPane(tabla);

		// Barras de desplazamiento
		desplazamiento_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// Propiedades de la tabla
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);

		tabla.setModel(modelo);

		// Agregando elementos a la ventana
		GridBagConstraints gbc_desplazamiento_1 = new GridBagConstraints();
		gbc_desplazamiento_1.gridheight = 3;
		gbc_desplazamiento_1.gridwidth = 6;
		gbc_desplazamiento_1.insets = new Insets(0, 0, 5, 5);
		gbc_desplazamiento_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_desplazamiento_1.gridx = 3;
		gbc_desplazamiento_1.gridy = 9;

		this.getContentPane().add(desplazamiento_1, gbc_desplazamiento_1);

		

		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(192, 192, 192));
		btnSave.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (inserUpda == 1) {

					idClie = txtIdclient.getText();
					nom = txtName.getText();
					persoContac = txtPersonacontacte.getText();
					local = txtLocalitzacio.getText();
					String cpString = txtCodipostal.getText();

					int solucio = checkBoxControler();

					int m = 0;
					for (char c : cpString.toCharArray()) {
						if (Character.isDigit(c)) {
							m++;

						}
					}

					if (cpString.isEmpty()) {
						JOptionPane.showMessageDialog(null, "El codi postal ha de ser un numero!!, per defecte sera 0");
						cp = 0;

					} else {

						if (m == cpString.length()) {

							cp = Integer.parseInt(cpString);

						} else {

							JOptionPane.showMessageDialog(null, "El codi postal ha de ser un numero!!");

						}
					}

					// cp = Integer.parseInt(txtCodipostal.getText());

					SQLClients query1 = new SQLClients();
					query1.conectar();
					Client nouClient = new Client(idClie, nom, persoContac, local, cp, solucio);
					if (idClie.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Has d'omplir els registres!!");

						System.out.println("Empty");

					} else {
						try {

							DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
							tableModel.setRowCount(0);
							query1.insertaClients(nouClient);

							query1.consultaClients("clients");
							query1.conectar();

							for (Client client : query1.consultaClients("clients")) {
								modelo.addRow(new Object[] { client.getIdClient(), client.getName(),
										client.getPersonaContacte(), client.getLocalitzacio(), client.getCodiPostal(),
										client.getMorositat() });
							}
							System.out.println();
							textBoxDisable();

							textBoxBlanc();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						buttonDisable();
					}

				} else if (inserUpda == 2) {

					SQLClients query1 = new SQLClients();
					query1.conectar();
					nom = txtName.getText();
					idClie = txtIdclient.getText();
					persoContac = txtPersonacontacte.getText();
					local = txtLocalitzacio.getText();
					String cpString = txtCodipostal.getText();
					int solucio = checkBoxControler();
					int m = 0;
					for (char c : cpString.toCharArray()) {
						if (Character.isDigit(c)) {
							m++;

						}
					}

					if (cpString.isEmpty()) {
						// JOptionPane.showMessageDialog(null, "El codi postal ha de ser un numero!!,
						// per defecte sera 0");
						// cp=0;
					} else {

						if (m == cpString.length()) {

							cp = Integer.parseInt(cpString);

						} else {

							JOptionPane.showMessageDialog(null,
									"El codi postal ha de ser un numero!!,per defecte sera 0");

						}
					}
					if (idClie.isEmpty()) {

						JOptionPane.showMessageDialog(null, "Has de seleccionar un client!!");
						textBoxBlanc();

					} else {

						try {

							DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
							tableModel.setRowCount(0);

							query1.updateData(idClie, cp, nom, persoContac, local, solucio);
							System.out.println();
							query1.consultaClients("clients");
							query1.conectar();

							for (Client client : query1.consultaClients("clients")) {
								modelo.addRow(new Object[] { client.getIdClient(), client.getName(),
										client.getPersonaContacte(), client.getLocalitzacio(), client.getCodiPostal(),
										client.getMorositat() });
							}
							System.out.println();
							textBoxDisable();

							textBoxBlanc();

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

							System.out.println("Actualizado");

						}
						buttonDisable();
					}

				} else {

					JOptionPane.showMessageDialog(null, "Primer has de dir si vols insertar o actualitzar !!");

				}
			}

		});

		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 8;
		gbc_btnSave.gridy = 12;
		getContentPane().add(btnSave, gbc_btnSave);
		this.pack();

		// Ponemos los datos en la tabla
		try {
			// Obtener datos de la tabla

			SQLClients query1 = new SQLClients();
			query1.consultaClients("clients");
			query1.conectar();

			for (Client client : query1.consultaClients("clients")) {
				this.idClie = client.getIdClient();
				modelo.addRow(new Object[] { client.getIdClient(), client.getName(), client.getPersonaContacte(),
						client.getLocalitzacio(), client.getCodiPostal(), client.getMorositat() });
			}

		} catch (Exception e) {
			System.out.println("Error de lectura de BD\n\n");

			e.printStackTrace();
		}

	}

	/**
	 * Launch the application.
	 */
	public static void screen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					provas frame = new provas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * /** Create the frame.
	 */
	/*
	 * public provas() { setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * setBounds(100, 100, 450, 300); contentPane = new JPanel();
	 * contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); contentPane.setLayout(new
	 * BorderLayout(0, 0)); setContentPane(contentPane); }
	 */
}
