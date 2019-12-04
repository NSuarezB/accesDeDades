package CONTROLADOR;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
//import com.sun.security.ntlm.Client;
import com.sun.jdi.connect.spi.Connection;

import DADES.SQLClients;
import MODEL.Client;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class frmClient3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmClient3 frame = new frmClient3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmClient3() throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow][][][][][][][][][][][]", "[][][][][][grow][][][][][][][]"));
		
		JLabel lblIdclient = new JLabel("idClient");
		contentPane.add(lblIdclient, "cell 0 0");
		
		JLabel lblNom = new JLabel("Nom");
		contentPane.add(lblNom, "cell 1 0");
		
		JLabel lblPersonaDeContacte = new JLabel("Persona de contacte");
		contentPane.add(lblPersonaDeContacte, "cell 2 0");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1,growx");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 2 1,growx");
		textField_2.setColumns(10);
		
		JLabel lblCodiPostal = new JLabel("Codi postal");
		contentPane.add(lblCodiPostal, "cell 0 2");
		
		JLabel lblLocalitzaci = new JLabel("Localització");
		contentPane.add(lblLocalitzaci, "cell 1 2");
		
		JLabel lblMorositat = new JLabel("Morositat");
		contentPane.add(lblMorositat, "cell 2 2");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 0 3,growx");
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		contentPane.add(textField_4, "cell 1 3,growx");
		textField_4.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		contentPane.add(chckbxNewCheckBox, "cell 2 3");
		
		
     
        int id, consola, obtenido;
        //String[] colum = {"idClients","name","personaContacte","localitzacio","codiPostal","morositat"};
        //String nombre;
        
        DefaultTableModel model = new DefaultTableModel();
		table = new JTable();
		model =new DefaultTableModel(
    			new Object[][] {
    			},
    			new String[] {
    					"idClients","name","personaContacte","localitzacio","codiPostal","morositat"
    					
    			}
    		);
		
		JScrollPane desplazamiento = new JScrollPane(table);
		String idClients,name,personaContacte,localitzacio;
		int codiPostal,morositat;
		this.setTitle("Clients");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout()); 
		
		//modelo.setColumnIdentifiers(colum);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
		
       // table.setModel(modelo);
        
        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);  
        this.pack();
        
       
   
		/*table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));*/
		
		contentPane.add(table, "cell 0 5 10 6,grow");
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1, "cell 0 12");
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2, "cell 1 12");
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3, "cell 2 12");
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "cell 13 12");
		
		
		//ArrayList<client> client = new ArrayList<client>();
		
		//conexio.conectar();
		//client=conexio.consultaClients("clients");
		//String[] clients = new String[client.size()];
		
		
		
		
		//for (int i = 0; i <  9; i++) {	
			
			//System.out.println(client);
		
			//table.add(clients[i]);
			
			
		//}
		
	}

}
