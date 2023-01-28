package net.codejava.sql;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AppointmentWithDoctor {

	public JFrame frame;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_5;
	public JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentWithDoctor window = new AppointmentWithDoctor();
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
	private JLabel lblNewLabel_6;
	public JLabel lblNewLabel_7;
	public AppointmentWithDoctor() {
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void fillComboBox() {
//		SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDate now = LocalDate.now();
		LocalDate date= LocalDate.parse(dtf.format(now));
		//LocalDate returnvalue = date.plusDays(6);
		
		for(int i = 0; i < 14; i++) {
			LocalDate returnvalue = date.plusDays(i);
			comboBox.addItem(returnvalue);
		}
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0,42,75,255));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(0, 0, 794, 661);
		JLabel lblNewLabel_2 = new JLabel("Scheduled At");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(new Color (255,255,255));
		lblNewLabel_2.setBounds(48, 326, 263, 48);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_5.setForeground(new Color(125,215,247,255));
		lblNewLabel_5.setBounds(335, 135, 154, 48);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("APPOINTMENT WITH DOCTOR");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(125,215,247,255));
		
		lblNewLabel.setBounds(234, 33, 359, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientSearchDoctor pSearchDoctor = new PatientSearchDoctor();
				PatientInformation pInformation = new PatientInformation();
				//pInformation.next2.action(null, btnNewButton)
				int PID = Integer.parseInt(lblNewLabel_5.getText());
				int DID = Integer.parseInt(lblNewLabel_7.getText());
				//String date = lblNewLabel_3.getText();
				String date = comboBox.getSelectedItem().toString();
				try {
					String sqlString = "SELECT COUNT(DISTINCT(PatientId)) AS 'NumberofPatient' "
							+ "FROM SCEDULE WHERE DoctorId = "+DID+ " AND ScheduledTime = '"+date+"'";
					Statement statement_1 = connection.createStatement();
					ResultSet resultSet_1 = statement_1.executeQuery(sqlString);
					int id = 0;
					while(resultSet_1.next()) {
						id = resultSet_1.getInt("NumberofPatient");
					}
					if(id < 10) {
						String sql = "INSERT INTO SCEDULE (ScheduledTime,PatientID,DoctorID) VALUES ('"+date+"',"+PID+","+DID+")";
						Statement statement = connection.createStatement();
						//ResultSet result = statement.executeQuery(sql);
						int rows = statement.executeUpdate(sql);
						System.exit(0);
					}else {
						JOptionPane.showMessageDialog(null, "Can't schedule for this date\n Please choose another date");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 36));
		btnNewButton.setForeground(new Color(0,42,75,255));
		btnNewButton.setBounds(583, 554, 149, 48);

		btnNewButton.setBackground(new Color(143, 248, 224));
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_6 = new JLabel("Doctor ID\r\n");
		lblNewLabel_6.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(48, 193, 154, 39);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Patient ID ");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(48, 135, 182, 48);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7.setForeground(new Color(125,215,247,255));
		lblNewLabel_7.setBounds(335, 193, 154, 39);
		frame.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_1 = new JLabel("Your Appointment has been set with ");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(48, 242, 682, 58);
		frame.getContentPane().add(lblNewLabel_1);
		frame.getContentPane().add(lblNewLabel_8);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox.setBounds(377, 336, 281, 58);
		frame.getContentPane().add(comboBox);
		fillComboBox();
	}
}
