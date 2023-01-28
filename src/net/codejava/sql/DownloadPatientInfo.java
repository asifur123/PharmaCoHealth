package net.codejava.sql;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DownloadPatientInfo {

	public JFrame frame18;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_8;
	public JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DownloadPatientInfo window = new DownloadPatientInfo();
					window.frame18.setVisible(true);
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
	public DownloadPatientInfo() {
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame18 = new JFrame();
		frame18.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame18.getContentPane().setBackground(new Color(183,234,229,255));
		frame18.setBounds(100, 100, 800, 700);
		frame18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame18.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-257, 0, 665, 661);
		Image img = new ImageIcon(this.getClass().getResource("/hospital4.jpg")).getImage();
		
		JButton btnNewButton = new JButton("Appointments");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dnameString = textField_6.getText().replaceAll("\\s", "");
				String sqlString = "SELECT * FROM Doctor WHERE DoctorFirstName+DoctorLastName = '"+dnameString+"'";
				Statement statement;
				try {
					statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(sqlString);
					while(resultSet.next()) {
						int id = resultSet.getInt("DoctorId");
						AppointmentWithPatient aWithPatient = new AppointmentWithPatient();
						aWithPatient.lblNewLabel_3.setText(Integer.toString(id));
						frame18.dispose();
						aWithPatient.frame.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnNewButton.setBounds(433, 556, 173, 39);
		frame18.getContentPane().add(btnNewButton);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(642, 162, 132, 31);
		frame18.getContentPane().add(textField_5);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("Patient's Name");
		lblNewLabel_7_2_1.setForeground(new Color(56, 73, 156));
		lblNewLabel_7_2_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7_2_1.setBounds(433, 157, 148, 39);
		frame18.getContentPane().add(lblNewLabel_7_2_1);
		
		JButton next2_1 = new JButton("Exit");
		next2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		next2_1.setForeground(new Color(0, 2, 49));
		next2_1.setFont(new Font("Agency FB", Font.BOLD, 30));
		next2_1.setBackground(new Color(104,207,216,255));

		next2_1.setBounds(663, 556, 96, 39);
		frame18.getContentPane().add(next2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Symptom");
		lblNewLabel_1_1_1.setForeground(new Color(56, 73, 156));
		lblNewLabel_1_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(435, 284, 97, 39);
		frame18.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_6.setColumns(10);
		textField_6.setBounds(642, 227, 132, 31);
		frame18.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("Doctor's Name");
		lblNewLabel_7_1_1_1.setForeground(new Color(56, 73, 156));
		lblNewLabel_7_1_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7_1_1_1.setBounds(433, 222, 148, 39);
		frame18.getContentPane().add(lblNewLabel_7_1_1_1);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_8.setColumns(10);
		textField_8.setBounds(642, 354, 132, 31);
		frame18.getContentPane().add(textField_8);
		
		JLabel lblPatient = new JLabel("DOCTOR'S COPY OF REPORT");
		lblPatient.setForeground(new Color(56, 73, 156));
		lblPatient.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblPatient.setBounds(461, 25, 298, 58);
		frame18.getContentPane().add(lblPatient);
		
		JLabel lblNewLabel_2_1 = new JLabel("Diagnosis");
		lblNewLabel_2_1.setForeground(new Color(56, 73, 156));
		lblNewLabel_2_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(433, 349, 148, 39);
		frame18.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Prescribed Medicine");
		lblNewLabel_3_1.setForeground(new Color(56, 73, 156));
		lblNewLabel_3_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3_1.setBounds(433, 416, 199, 39);
		frame18.getContentPane().add(lblNewLabel_3_1);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_7.setColumns(10);
		textField_7.setBounds(642, 289, 132, 31);
		frame18.getContentPane().add(textField_7);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_9.setColumns(10);
		textField_9.setBounds(642, 424, 132, 31);
		frame18.getContentPane().add(textField_9);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(409, 0, 375, 661);
		frame18.getContentPane().add(lblNewLabel_1);
		lblNewLabel.setIcon(new ImageIcon(img));
		frame18.getContentPane().add(lblNewLabel);
	}
}
