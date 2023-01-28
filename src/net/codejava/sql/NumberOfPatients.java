package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class NumberOfPatients {

	public JFrame frame;
	public JComboBox comboBox_1;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberOfPatients window = new NumberOfPatients();
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
	Connection connection;
	public NumberOfPatients() {
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void fillComboBox() {
		String sql_1 = "SELECT * FROM DOCTOR";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql_1);
			while(resultSet.next()) {
				String string = resultSet.getString("DoctorFirstName");
				String string_1 = resultSet.getString("DoctorLastName");
				comboBox.addItem(string+" "+string_1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void fillComboBox_1() {
		String sql_2 = "SELECT DISTINCT(Specialize) FROM DOCTOR";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql_2);
			while(resultSet.next()) {
				comboBox_1.addItem(resultSet.getString("Specialize"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctors");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(63, 145, 221, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(338, 258, 206, 48);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(338, 479, 206, 48);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = comboBox.getSelectedItem().toString();
				String string2 = string.replaceAll("\\s", "");
				String sqlString = "SELECT * FROM DOCTOR WHERE DoctorFirstName+DoctorLastName = '"+string2+"'";
				SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				LocalDate now = LocalDate.now();
				LocalDate date= LocalDate.parse(dtf.format(now));
				LocalDate returnvalue = date.plusDays(0);
				try {
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(sqlString);
					int id = 0;
					while(resultSet.next()) {
						id = resultSet.getInt("DoctorId");
					}
					String sql = "SELECT COUNT(DISTINCT(PatientId)) 'NumberOfPatient' FROM SCEDULE WHERE ScheduledTime = '"+returnvalue+"' AND DoctorId = "+id;
					Statement statement2 = connection.createStatement();
					ResultSet resultSet2 = statement2.executeQuery(sql);
					while(resultSet2.next()) {
						int num = resultSet2.getInt("NumberOfPatient");
						lblNewLabel_2.setText(Integer.toString(num));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox.setBounds(338, 145, 278, 48);
		frame.getContentPane().add(comboBox);
		
		
		
		JLabel lblDepartments = new JLabel("Departments");
		lblDepartments.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblDepartments.setBounds(63, 387, 221, 48);
		frame.getContentPane().add(lblDepartments);
		
		JLabel lblNewLabel_1_1 = new JLabel("Patient Visited");
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(63, 479, 221, 48);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = comboBox_1.getSelectedItem().toString();
				//String string2 = string.replaceAll("\\s", "");
				SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd");
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				LocalDate now = LocalDate.now();
				LocalDate date= LocalDate.parse(dtf.format(now));
				LocalDate returnvalue = date.plusDays(0);
				try {
					
					String sql = "SELECT COUNT(DISTINCT(PatientId)) 'NumberOfPatient' "
							+ "FROM SCEDULE INNER JOIN DOCTOR "
							+ "ON SCEDULE.DoctorId = DOCTOR.DoctorId "
							+ "WHERE ScheduledTime = '"+returnvalue+"' AND SCEDULE.DoctorId IN (SELECT DoctorID FROM DOCTOR WHERE Specialize = '"+string+"')";
					Statement statement2 = connection.createStatement();
					ResultSet resultSet2 = statement2.executeQuery(sql);
					while(resultSet2.next()) {
						int num = resultSet2.getInt("NumberOfPatient");
						lblNewLabel_2_1.setText(Integer.toString(num));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox_1.setBounds(338, 387, 278, 48);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Patient Visited");
		lblNewLabel_1_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(63, 258, 221, 48);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminHome aHome = new AdminHome();
				aHome.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnNewButton.setBounds(586, 573, 160, 48);
		frame.getContentPane().add(btnNewButton);
		
		fillComboBox();
		fillComboBox_1();
	}
}