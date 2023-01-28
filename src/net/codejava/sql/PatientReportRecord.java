package net.codejava.sql;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;

public class PatientReportRecord {
	
	int id=0;
	int id1=0;
	String fName,lName,dfName,dlName,sym,diag,pm;
	JFrame frame22;
	public JTextField textField;
	public JTextField textField_1;

	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientReportRecord window = new PatientReportRecord();
					window.frame22.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public PatientReportRecord() {
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame22 = new JFrame();//rgba(83,123,168,255)
		frame22.getContentPane().setBackground(new Color(83,123,168,255));
		frame22.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame22.setBounds(100, 100, 800, 700);
		frame22.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame22.getContentPane().setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/liquid.gif")).getImage();
		
		btnNewButton = new JButton("Print Report");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientReportRecordDownload pDownload = new PatientReportRecordDownload();
				frame22.dispose();
				pDownload.lblNewLabel_6.setText(fName);
				pDownload.lblNewLabel_7.setText(lName);
				pDownload.lblNewLabel_8.setText(sym);
				pDownload.lblNewLabel_9.setText(diag);
				pDownload.lblNewLabel_10.setText(pm);
				pDownload.frame.setVisible(true);
			
			}
		});
		
		lblNewLabel_3 = new JLabel("PATIENT REPORT RECORD");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(247, 11, 336, 35);
		frame22.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		textField_1.setBounds(287, 151, 201, 45);
		frame22.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 30));
		textField.setBounds(287, 81, 201, 45);
		frame22.getContentPane().add(textField);
		textField.setColumns(10);
		btnNewButton.setBounds(597, 550, 152, 42);
		btnNewButton.setForeground(new Color(255,255,255));
		btnNewButton.setBackground(new Color(98,31,134,255));
		frame22.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 233, 709, 235);
		frame22.getContentPane().add(scrollPane);
		
		
			table = new JTable();//
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					fName = (table.getModel().getValueAt(row, 0).toString());
					lName = (table.getModel().getValueAt(row, 1).toString());
					sym = (table.getModel().getValueAt(row, 2).toString());
					diag = (table.getModel().getValueAt(row, 3).toString());
					pm = (table.getModel().getValueAt(row, 4).toString());
				}
			});
			
			
			scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("PATIENT ID");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255,255,255));
		lblNewLabel.setBounds(40, 81, 148, 42);
		frame22.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("PATIENT NAME");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(new Color(255,255,255));
		lblNewLabel_1.setBounds(41, 156, 147, 42);
		frame22.getContentPane().add(lblNewLabel_1);
		
		JButton btnShowReport = new JButton("Show Report");
		btnShowReport.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnShowReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pID = Integer.parseInt(textField.getText());
				int patientId = 0;
				try {
					String sql = "SELECT * FROM PATIENT WHERE PatientId = "+pID ;
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(sql);
					while(result.next()) {
						patientId = result.getInt("PatientId");
					}
					
				 }catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String sql_2 = "SELECT p.PatientFirstName+' '+p.PatientLastName AS 'Patient Full Name', d.DoctorFirstName+' '+d.DoctorLastName AS 'Doctor Full Name',pr.Symptom, pr.Diagnosis, pr.PrescribedMedicine "
							+ "FROM PATIENTREPORT pr INNER JOIN DOCTOR d "
							+ "ON pr.DoctorId = d.DoctorId "
							+ "INNER JOIN PATIENT p "
							+ "ON pr.PatientId = p.PatientId "
							+ "WHERE p.PatientId = "+pID ;
					
					Statement statement = connection.createStatement();
					ResultSet result_2 = statement.executeQuery(sql_2);
					
					table.setModel(DbUtils.resultSetToTableModel(result_2));
					
					connection.close();
		       }catch(SQLException e2) {
		    	   e2.printStackTrace();
		    	   }
			}
		});
		btnShowReport.setBounds(597, 153, 152, 45);
		btnShowReport.setForeground(new Color(255,255,255));
		btnShowReport.setBackground(new Color(98,31,134,255));
		frame22.getContentPane().add(btnShowReport);
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(0, -43, 784, 676);
		frame22.getContentPane().add(lblNewLabel_2);
	}
}
