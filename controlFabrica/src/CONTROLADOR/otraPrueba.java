package CONTROLADOR;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DADES.SQLClients;

public class otraPrueba extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					otraPrueba frame = new otraPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public otraPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable();
		model =new DefaultTableModel(
    			new Object[][] {
    			},
    			new String[] {
    					"idClients","name","personaContacte","localitzacio","codiPostal","morositat"
    					
    			}
    		);
		 SQLClients conexio = new SQLClients();
	        java.sql.Connection conectar=conexio.conectar();
	        
	        String sql="SELECT * FROM clients";
	        Statement estat;
	        
	      //  DefaultTableModel modelo = new DefaultTableModel();
	        System.out.println(model.getColumnCount());
	        String[] dades = new String[model.getColumnCount()];
	        
	        
	        try {
	            // Obtener datos de la tabla
	        	System.out.println("hel");
	           estat = conectar.createStatement();
	           
	           ResultSet result = estat.executeQuery(sql);
	           
	           while(result.next()) {
	        	   
	        	   for (int i = 0; i < dades.length; i++) {
					dades[i]= result.getString(i+1);
					
				}
	        	  
	        	   model.addRow(dades);
	        	   contentPane.add(table);
	        	   
	           }
	            
	            
	        } catch (Exception e) {
	            System.out.println("Error de lectura de BD\n\n");
	            
	            e.printStackTrace();
	        }
		
		
		
		
	}

}
