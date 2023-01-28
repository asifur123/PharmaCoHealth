package net.codejava.sql;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;


public class PatientInfo {

	public JFrame frame;
	private JTable table;
	private String string_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientInfo window = new PatientInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn_1;
	Connection conn_2;
	public PatientInfo() {
		conn_1 = ConnectToSql.dbconnect();
		conn_2 = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame.getContentPane().setBackground(new Color(229,219,203,255));
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 22));
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(0, 0, 784, 661);
		Image img4 = new ImageIcon(this.getClass().getResource("/LAB.gif")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(119, 117, 81, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Agency FB", Font.PLAIN, 20));
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				string_1 = comboBox_4.getSelectedItem().toString();
				
				String sql_1 = "SELECT p.Age,p.Gender,p.Weight,pr.Symptom,p.MedicalHistory,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE MedicalHistory = '"+string_1+"'";
				
				Statement statement_1;
				try {
					statement_1 = conn_2.createStatement();
					ResultSet result_1 = statement_1.executeQuery(sql_1);
					table.setModel(DbUtils.resultSetToTableModel(result_1));
					//conn_2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Dermatology", "Infectious disease", "Diabetes", "Respiratory", "Cancer", "Gastro", "Heart "}));
		comboBox_4.setBounds(470, 159, 74, 28);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Agency FB", Font.PLAIN, 20));
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string_2 = comboBox_5.getSelectedItem().toString();
				
					String sql_1 = "SELECT p.Age,p.Gender,p.Weight,pr.Symptom,p.MedicalHistory,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE Diagnosis = '"+string_2+"'";
					Statement statement_1;
					try {
						statement_1 = conn_2.createStatement();
						ResultSet result_1 = statement_1.executeQuery(sql_1);
						table.setModel(DbUtils.resultSetToTableModel(result_1));
						//conn_2.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Heart disease", "Cancer", "Unintentional injuries", "Chronic lower respiratory disease", "Stroke", "Cerebrovascular disease", "Alzheimer's disease", "High Diabetes", "Influenza ", "Pneumonia"}));
		comboBox_5.setBounds(567, 159, 81, 28);
		frame.getContentPane().add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(new Font("Agency FB", Font.PLAIN, 20));
		comboBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string_3 = comboBox_6.getSelectedItem().toString();
				
				String sql_1 = "SELECT p.Age,p.Gender,p.Weight,pr.Symptom,p.MedicalHistory,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE PrescribedMedicine = '"+string_1+"'";
				
				Statement statement_1;
				try {
					statement_1 = conn_2.createStatement();
					ResultSet result_1 = statement_1.executeQuery(sql_1);
					table.setModel(DbUtils.resultSetToTableModel(result_1));
					//conn_2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Lisinopril", "Levothyroxine", "Azithromycin", "Metformin", "Lipitor", "Amlodipine", "Amoxicillin", "Hydrochlorothiazide"}));
		comboBox_6.setBounds(672, 159, 104, 28);
		frame.getContentPane().add(comboBox_6);
		
		JLabel lblNewLabel_6 = new JLabel("Diagnosis");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(567, 117, 81, 28);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("Weight");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(220, 117, 71, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Agency FB", Font.PLAIN, 20));
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string_4 = comboBox_3.getSelectedItem().toString();
				
				String sql_1 = "SELECT p.Age,p.Gender,p.Weight,pr.Symptom,p.MedicalHistory,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE Symptom = '"+string_1+"'";
				
				Statement statement_1;
				try {
					statement_1 = conn_2.createStatement();
					ResultSet result_1 = statement_1.executeQuery(sql_1);
					table.setModel(DbUtils.resultSetToTableModel(result_1));
					//conn_2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Unusual fatigue", "Trouble sleeping", "Problems breathing", "Indigestion", "Anxiety", "Back or abdominal pain", "Weight loss", "Pain", "Nausea", "Vomiting,", "Lightheadedness", "Shortness of breath"}));
		comboBox_3.setBounds(328, 159, 114, 28);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Agency FB", Font.PLAIN, 20));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string_5 = comboBox_1.getSelectedItem().toString();
				
				//String sql_1 = "SELECT p.Age,p.Gender,p.Weight,p.MedicalHistory,pr.Symptom,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE Gender = '"+string_1+"'";
				String sql_1 = "SELECT p.Age,p.Gender,p.Weight,p.MedicalHistory,pr.Symptom,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE GENDER = '"+string_1+"' (SELECT AGE FROM PATIENTINFO WHERE AGE > '"+10+"')";
				
				
				Statement statement_1;
				try {
					statement_1 = conn_2.createStatement();
					ResultSet result_1 = statement_1.executeQuery(sql_1);
					table.setModel(DbUtils.resultSetToTableModel(result_1));
					//conn_2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_1.setBounds(119, 159, 81, 28);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 117, 71, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Medical History");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(470, 117, 81, 28);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Symptom");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(328, 117, 121, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 236, 741, 329);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 20));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = comboBox.getSelectedItem().toString();
				String string2 = string.substring(1,string.length());
				int age = Integer.parseInt(string2);
				int age1= age;
				//System.out.println(age1);
				
				String sql = "SELECT p.Age,p.Gender,p.Weight,p.MedicalHistory,pr.Symptom,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE AGE > "+age;
				
				Statement statement;
				try {
					statement = conn_1.createStatement();
					ResultSet result = statement.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(result));
					//conn_1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {">10", ">20", ">30", ">40", ">50", ">60", ">70", ">80", ">90", ">100"}));
		comboBox.setBounds(20, 159, 71, 28);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("Prescribed Medicine");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(647, 117, 129, 28);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("ALL PATIENTS INFORMATION");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel.setBounds(230, 33, 342, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Agency FB", Font.PLAIN, 20));
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = comboBox_2.getSelectedItem().toString();
				String string2 = string.substring(1,string.length());
				int weight = Integer.parseInt(string2);
				
				String sql = "SELECT p.Age,p.Gender,p.Weight,p.MedicalHistory,pr.Symptom,pr.Diagnosis,pr.PrescribedMedicine FROM PATIENTINFO p INNER JOIN PATIENTREPORT pr ON p.PatientId = pr.PatientId WHERE Weight > "+weight;
				
				Statement statement;
				try {
					statement = conn_1.createStatement();
					ResultSet result = statement.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(result));
					//conn_1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {">10", ">20", ">30", ">40", ">50", ">60", ">70", ">80", ">90", ">100", ">110", ">120"}));
		comboBox_2.setBounds(230, 159, 71, 28);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminHome aHome  = new AdminHome();
				aHome.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(640, 595, 121, 40);
		frame.getContentPane().add(btnNewButton);
		lblNewLabel_8.setIcon(new ImageIcon(img4));
		frame.getContentPane().add(lblNewLabel_8);
	}
}
