package net.codejava.sql;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
//import com.sun.org.apache.bcel.internal.generic.IfInstruction;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SearchInfo {

	JFrame frame9;
	private JTextField textField;
	private JLabel lblSearchPatientInfo;
	private JButton btnNext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchInfo window = new SearchInfo();
					window.frame9.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn;
	Connection conn_1;
	Connection conn_2;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	public SearchInfo() {
		conn = ConnectToSql.dbconnect();
		conn_1 = ConnectToSql.dbconnect();
		conn_2 = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame9 = new JFrame();
		frame9.getContentPane().setBackground(new Color(0,42,75,255));
		frame9.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame9.setBounds(100, 100, 800, 700);
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame9.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/galaxy.gif")).getImage();
		
		btnNext = new JButton("Back");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame9.dispose();
				AdminHome aHome  = new AdminHome();
				aHome.frame.setVisible(true);
//				Lab si = new Lab();
//				PatientInfo pInfo = new PatientInfo();
//				pInfo.frame.setVisible(true);
				//si.frame15.setVisible(true);
			}
		});
		btnNext.setForeground(new Color(0, 2, 49));
		btnNext.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNext.setBackground(new Color(143, 248, 224));
		btnNext.setBounds(648, 588, 108, 39);
		frame9.getContentPane().add(btnNext);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Patient ID");
		lblNewLabel_7.setForeground(new Color(125,215,247,255));
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(105, 104, 148, 39);
		frame9.getContentPane().add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(335, 106, 148, 38);
		frame9.getContentPane().add(textField);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 766, 161);
		frame9.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 382, 766, 167);
		frame9.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pID = Integer.parseInt(textField.getText());
				int patientId = 0;
				try {
					String sql = "SELECT * FROM PATIENT WHERE PatientId = "+pID ;
					Statement statement = conn_1.createStatement();
					ResultSet result = statement.executeQuery(sql);
					while(result.next()) {
						patientId = result.getInt("PatientId");
					}
					
					//making changes here 
					if(patientId != pID) {
						JOptionPane.showMessageDialog(null, "Wrong Patient id");
						textField.setText("");
					}else {
						String sql_1 = "SELECT p.PatientId,p.PatientFirstName,p.PatientLastName,p.PatientPhoneNo,pa.Age,pa.Weight,pa.Gender,pa.MedicalHistory FROM PATIENT p INNER JOIN PATIENTINFO pa ON p.PatientId = pa.PatientId AND p.PatientId = "+pID;
						Statement statement_n = conn.createStatement();
						ResultSet result_1 = statement_n.executeQuery(sql_1);
						table.setModel(DbUtils.resultSetToTableModel(result_1));
						
						String sql_2 = "SELECT Symptom,Diagnosis,PrescribedMedicine FROM PATIENTREPORT WHERE PatientId ="+pID ;
						
						Statement statement_2 = conn_2.createStatement();
						ResultSet result_2 = statement_2.executeQuery(sql_2);
						
						table_1.setModel(DbUtils.resultSetToTableModel(result_2));
					}
					
				 }catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		       }
		});
		search.setForeground(new Color(0, 2, 49));
		search.setFont(new Font("Agency FB", Font.BOLD, 30));
		search.setBackground(new Color(143, 248, 224));
		search.setBounds(569, 106, 108, 39);
		frame9.getContentPane().add(search);
		
		lblSearchPatientInfo = new JLabel("SEARCH PATIENT INFO");
		lblSearchPatientInfo.setForeground(new Color(125,215,247,255));
		lblSearchPatientInfo.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblSearchPatientInfo.setBounds(299, 11, 222, 58);
		frame9.getContentPane().add(lblSearchPatientInfo);
		
		
		
	}
}
