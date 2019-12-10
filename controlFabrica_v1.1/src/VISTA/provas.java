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
import java.awt.im.InputContext;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
    public String idClie,nom,persoContac,local;
    public int cp;
    private JButton btnDelete;
    Object llista=null;
    private int inserUpda;
    private JLabel lblIdclient;
    private JLabel lblName;
    private JLabel lblPersonaCon;
    private JLabel lblLocalitzacio;
    private JLabel lblCp;
    private JButton btnSave;
    private JButton btnUpdate;
    
    
   /* private void leerDatos() throws ClassNotFoundException, SQLException {
        String usuario = "inventario";
        String passwd = "1973";
        String instruccion = "SELECT * FROM clients";
        
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection("jdbc:sqlite:/home/natalia/muntatge.db");
        comando = ((java.sql.Connection) conexion).createStatement();
        resultados = comando.executeQuery(instruccion);
        
    }*/
    
    void refresh() throws SQLException {
    	
    }
    
    
    
    private void cerrar() throws SQLException, IOException {
        conexion.close();        
    }    
    
    
    public provas() throws IOException, SQLException {
    	
    	
    	
    	
        // Nombre de las columnas como apareceran en la tabla
        String[] columnas = {"idClient", "name", "personaContacte", "localitzacio","codiPostal","morositat"};
        DefaultTableModel modelo = new DefaultTableModel() {
        	 public boolean isCellEditable(int row, int column) {
        	       //all cells false
        	       return false;
        	    }
        };
        
        int codiPostal, morositat;
        String idClient,name,personaContacte,localitzacio;
        
        // Parametros de la ventana
        this.setTitle("Clients");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new BorderLayout());
        
        // Modelo de la tabla
        modelo.setColumnIdentifiers(columnas);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{50, 0, 0,50,20, 20,80,80, 80};
        gridBagLayout.rowHeights = new int[]{8,10,10,10,10,10, 0,10,80,70,40, 0};
        gridBagLayout.columnWeights = new double[]{10.0, 0.0, 0.0,1.0, 1.0, 0.0};
        gridBagLayout.rowWeights = new double[]{10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);
        
        lblIdclient = new JLabel("IdClient");
        GridBagConstraints gbc_lblIdclient = new GridBagConstraints();
        gbc_lblIdclient.insets = new Insets(0, 0, 5, 5);
        gbc_lblIdclient.anchor = GridBagConstraints.EAST;
        gbc_lblIdclient.gridx = 1;
        gbc_lblIdclient.gridy = 1;
        getContentPane().add(lblIdclient, gbc_lblIdclient);
        
        txtIdclient = new JTextField();
        txtIdclient.setEditable(false);
        
        GridBagConstraints gbc_txtIdclient = new GridBagConstraints();
        gbc_txtIdclient.insets = new Insets(0, 0, 5, 5);
        gbc_txtIdclient.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtIdclient.gridx = 2;
        gbc_txtIdclient.gridy = 1;
        getContentPane().add(txtIdclient, gbc_txtIdclient);
        txtIdclient.setColumns(10);
        
        lblName = new JLabel("Name");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.anchor = GridBagConstraints.EAST;
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 2;
        getContentPane().add(lblName, gbc_lblName);
        
        txtName = new JTextField();
        txtName.setEditable(false);
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.insets = new Insets(0, 0, 5, 5);
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.gridx = 2;
        gbc_txtName.gridy = 2;
        getContentPane().add(txtName, gbc_txtName);
        txtName.setColumns(10);
        
        lblPersonaCon = new JLabel("Persona\n contacte");
        GridBagConstraints gbc_lblPersonaCon = new GridBagConstraints();
        gbc_lblPersonaCon.insets = new Insets(0, 0, 5, 5);
        gbc_lblPersonaCon.anchor = GridBagConstraints.EAST;
        gbc_lblPersonaCon.gridx = 1;
        gbc_lblPersonaCon.gridy = 3;
        getContentPane().add(lblPersonaCon, gbc_lblPersonaCon);
        
        txtPersonacontacte = new JTextField();
        txtPersonacontacte.setEditable(false);
        GridBagConstraints gbc_txtPersonacontacte = new GridBagConstraints();
        gbc_txtPersonacontacte.insets = new Insets(0, 0, 5, 5);
        gbc_txtPersonacontacte.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPersonacontacte.gridx = 2;
        gbc_txtPersonacontacte.gridy = 3;
        getContentPane().add(txtPersonacontacte, gbc_txtPersonacontacte);
        txtPersonacontacte.setColumns(10);
        
        lblLocalitzacio = new JLabel("Localitzacio");
        GridBagConstraints gbc_lblLocalitzacio = new GridBagConstraints();
        gbc_lblLocalitzacio.insets = new Insets(0, 0, 5, 5);
        gbc_lblLocalitzacio.anchor = GridBagConstraints.EAST;
        gbc_lblLocalitzacio.gridx = 1;
        gbc_lblLocalitzacio.gridy = 4;
        getContentPane().add(lblLocalitzacio, gbc_lblLocalitzacio);
        
        txtLocalitzacio = new JTextField();
        txtLocalitzacio.setEditable(false);
        GridBagConstraints gbc_txtLocalitzacio = new GridBagConstraints();
        gbc_txtLocalitzacio.insets = new Insets(0, 0, 5, 5);
        gbc_txtLocalitzacio.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLocalitzacio.gridx = 2;
        gbc_txtLocalitzacio.gridy = 4;
        getContentPane().add(txtLocalitzacio, gbc_txtLocalitzacio);
        txtLocalitzacio.setColumns(10);
        
        lblCp = new JLabel("CP");
        GridBagConstraints gbc_lblCp = new GridBagConstraints();
        gbc_lblCp.insets = new Insets(0, 0, 5, 5);
        gbc_lblCp.anchor = GridBagConstraints.EAST;
        gbc_lblCp.gridx = 1;
        gbc_lblCp.gridy = 5;
        getContentPane().add(lblCp, gbc_lblCp);
        
        txtCodipostal = new JTextField();
        txtCodipostal.setEditable(false);
        GridBagConstraints gbc_txtCodipostal = new GridBagConstraints();
        gbc_txtCodipostal.insets = new Insets(0, 0, 5, 5);
        gbc_txtCodipostal.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCodipostal.gridx = 2;
        gbc_txtCodipostal.gridy = 5;
        getContentPane().add(txtCodipostal, gbc_txtCodipostal);
        txtCodipostal.setColumns(10);
        tabla = new JTable();
        tabla.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		
                idClie=tabla.getValueAt(tabla.getSelectedRow(),0).toString();
               /* nom=tabla.getValueAt(tabla.getSelectedRow(),1).toString();
                persoContac=tabla.getValueAt(tabla.getSelectedRow(),2).toString();
                local=tabla.getValueAt(tabla.getSelectedRow(),3).toString();
                cp=Integer.parseInt((String) tabla.getValueAt(tabla.getSelectedRow(),4));*/
                
                txtIdclient.setText(tabla.getValueAt(tabla.getSelectedRow(),0).toString());
                txtName.setText(tabla.getValueAt(tabla.getSelectedRow(),1).toString());
                txtPersonacontacte.setText(tabla.getValueAt(tabla.getSelectedRow(),2).toString());
                txtLocalitzacio.setText(tabla.getValueAt(tabla.getSelectedRow(),3).toString());
                txtCodipostal.setText(tabla.getValueAt(tabla.getSelectedRow(),4).toString());
                
                
                
        	}
        });
        
        chckbxMorositat = new JCheckBox("Morositat");
        GridBagConstraints gbc_chckbxMorositat = new GridBagConstraints();
        gbc_chckbxMorositat.insets = new Insets(0, 0, 5, 5);
        gbc_chckbxMorositat.gridx = 2;
        gbc_chckbxMorositat.gridy = 6;
        getContentPane().add(chckbxMorositat, gbc_chckbxMorositat);
        
        
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
        gbc_desplazamiento_1.gridwidth = 5;
        gbc_desplazamiento_1.insets = new Insets(0, 0, 5, 5);
        gbc_desplazamiento_1.anchor = GridBagConstraints.NORTHWEST;
        gbc_desplazamiento_1.gridx = 3;
        gbc_desplazamiento_1.gridy = 7;
        
        
        this.getContentPane().add(desplazamiento_1, gbc_desplazamiento_1);
        
        
        
        
        
        btnInsert = new JButton("Insert");
        btnInsert.addActionListener(new ActionListener() {
        	
        	private Object JFrame;
        	
			public void actionPerformed(ActionEvent arg0) {
				inserUpda=1;
				txtIdclient.setText("");
				txtName.setText("");
				txtPersonacontacte.setText("");
				txtLocalitzacio.setText("");
				txtCodipostal.setText("");
				
				txtPersonacontacte.setEditable(true);
				txtIdclient.setEditable(true);
				txtName.setEditable(true);
				txtLocalitzacio.setEditable(true);
				txtCodipostal.setEditable(true);
				
				
        		
        		 
        		
        		
			}});
        
        btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		inserUpda=2;
        		
				txtCodipostal.setEditable(true);
				txtName.setEditable(true);
				txtPersonacontacte.setEditable(true);
				txtLocalitzacio.setEditable(true);
        		
        		
        		
        		
        	}
        });
        GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
        gbc_btnUpdate.anchor = GridBagConstraints.EAST;
        gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
        gbc_btnUpdate.gridx = 1;
        gbc_btnUpdate.gridy = 10;
        getContentPane().add(btnUpdate, gbc_btnUpdate);
        GridBagConstraints gbc_btnInsert = new GridBagConstraints();
        gbc_btnInsert.insets = new Insets(0, 0, 5, 5);
        gbc_btnInsert.gridx = 2;
        gbc_btnInsert.gridy = 10;
        getContentPane().add(btnInsert, gbc_btnInsert);
        
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		
        		System.out.println("boto clicat "+idClie);
        		SQLClients query1 = new SQLClients();
        		try {
					query1.deleteData(idClie);
					DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
					tableModel.setRowCount(0);
					query1.consultaClients("clients");
		        	query1.conectar();
		        	
		        	for (Client client : query1.consultaClients("clients")) {
		        		modelo.addRow(new Object[] {client.getIdClient(),
		        									client.getName(),
		        									client.getPersonaContacte(),
		        									client.getLocalitzacio(),
		        									client.getCodiPostal(),
		        									client.getMorositat()});
		        	}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        });
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.anchor = GridBagConstraints.WEST;
        gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
        gbc_btnDelete.gridx = 3;
        gbc_btnDelete.gridy = 10;
        getContentPane().add(btnDelete, gbc_btnDelete);
        
        
        
        
        
        
        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		
        		if(inserUpda==1) {
        		
        		
        		idClie = txtIdclient.getText();
        		nom=txtName.getText();
        		persoContac=txtPersonacontacte.getText();
        		local = txtLocalitzacio.getText();
        		cp = Integer.parseInt(txtCodipostal.getText());
        		
	        	
	        			
	        			SQLClients query1 = new SQLClients();
		        		query1.conectar();
		        		Client nouClient = new Client(idClie,nom,persoContac,local,cp,0);
						try {
							
							DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
							tableModel.setRowCount(0);
							query1.insertaClients(nouClient);
							
							query1.consultaClients("clients");
				        	query1.conectar();
				        	
				        	for (Client client : query1.consultaClients("clients")) {
				        		modelo.addRow(new Object[] {client.getIdClient(),
				        									client.getName(),
				        									client.getPersonaContacte(),
				        									client.getLocalitzacio(),
				        									client.getCodiPostal(),
				        									client.getMorositat()});
				        	}
							System.out.println();
							txtPersonacontacte.setEditable(false);
							txtIdclient.setEditable(false);
							txtName.setEditable(false);
							txtLocalitzacio.setEditable(false);
							txtCodipostal.setEditable(false);
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        			
		      
        		
        		} else if(inserUpda==2) {
        			
        			SQLClients query1 = new SQLClients();
            		query1.conectar();
            		
            		try {
    					
    					DefaultTableModel tableModel = (DefaultTableModel) tabla.getModel();
    					tableModel.setRowCount(0);
    					cp=Integer.parseInt(txtCodipostal.getText());
    					nom=txtName.getText();
    					idClie=txtIdclient.getText();
    					persoContac=txtPersonacontacte.getText();
    					local=txtLocalitzacio.getText();
    					query1.updateData(idClie, cp,nom,persoContac,local);
    					
    					query1.consultaClients("clients");
    		        	query1.conectar();
    		        	
    		        	for (Client client : query1.consultaClients("clients")) {
    		        		modelo.addRow(new Object[] {client.getIdClient(),
    		        									client.getName(),
    		        									client.getPersonaContacte(),
    		        									client.getLocalitzacio(),
    		        									client.getCodiPostal(),
    		        									client.getMorositat()});
    		        	}
    					System.out.println();
    					txtPersonacontacte.setEditable(false);
    					txtIdclient.setEditable(false);
    					txtName.setEditable(false);
    					txtLocalitzacio.setEditable(false);
    					txtCodipostal.setEditable(false);
    					
    					
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
            		
            		
            		
            		
        			System.out.println("Actualizado");
        			
        			
        		} else {
        			
        			JOptionPane.showMessageDialog(null, "Primer has de dir si vols insertar o actualitzar!!");
        			
        			
        		}
        		
        		
        		
        		
        	}
        		
        		
        		
        		
        });
        GridBagConstraints gbc_btnSave = new GridBagConstraints();
        gbc_btnSave.insets = new Insets(0, 0, 5, 0);
        gbc_btnSave.gridx = 8;
        gbc_btnSave.gridy = 10;
        getContentPane().add(btnSave, gbc_btnSave);
        this.pack();
        
        // Ponemos los datos en la tabla
        try {
            // Obtener datos de la tabla
        	
        	SQLClients query1 = new SQLClients();
        	query1.consultaClients("clients");
        	query1.conectar();
        	
        	for (Client client : query1.consultaClients("clients")) {
        		this.idClie=client.getIdClient();
        		modelo.addRow(new Object[] {client.getIdClient(),
        									client.getName(),
        									client.getPersonaContacte(),
        									client.getLocalitzacio(),
        									client.getCodiPostal(),
        									client.getMorositat()});
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

/*	/**
	 * Create the frame.
	 */
	/*public provas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
*/	
    }

