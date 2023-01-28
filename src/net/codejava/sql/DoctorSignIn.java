package net.codejava.sql;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DoctorSignIn {

	JFrame frame6;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorSignIn window = new DoctorSignIn();
					window.frame6.setVisible(true);
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
	public DoctorSignIn() {
		conn = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame6 = new JFrame();
		frame6.getContentPane().setBackground(new Color(51,153,204,255));
		frame6.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame6.setBounds(100, 100, 800, 700);
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Doctor2.gif")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBackground(new Color(37, 183, 225));
		label.setBounds(-230, 0, 620, 700);
		frame6.getContentPane().add(label);
		
		JLabel lblDoctorsSignIn = new JLabel("DOCTOR'S SIGN IN PAGE");
		lblDoctorsSignIn.setForeground(Color.WHITE);
		lblDoctorsSignIn.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblDoctorsSignIn.setBounds(466, 108, 256, 58);
		frame6.getContentPane().add(lblDoctorsSignIn);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(430, 262, 108, 41);
		frame6.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(638, 268, 108, 31);
		frame6.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		passwordField.setBounds(638, 348, 108, 31);
		frame6.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(430, 338, 108, 48);
		frame6.getContentPane().add(lblNewLabel_4);
		
		JButton next2 = new JButton("Next");
		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = textField.getText();
				String password = passwordField.getText();
				
				
				if(textField.getText().isEmpty() && passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Can't leave any field empty");
				}
				else {
					String sql = "SELECT * FROM DOCTOR WHERE Email = '"+email+"' AND Password = '"+password+"'";
					try {
						Statement statement = conn.createStatement();
						//int rows = statement.executeUpdate(sql);
						ResultSet result = statement.executeQuery(sql);
						if(result.next()) {
							int id = result.getInt("DoctorId");
							frame6.dispose();
							PatientReport pr = new PatientReport();
							AppointmentWithPatient aWithPatient = new AppointmentWithPatient();
							aWithPatient.lblNewLabel_3.setText(Integer.toString(id));
							aWithPatient.frame.setVisible(true);
//							pr.textField_1.setText(Integer.toString(id));
//							pr.frame11.setVisible(true);
							 //}else {
								 
								 //frame8.setVisible(true);
							 //}
						}else {
							JOptionPane.showMessageDialog(null, "If you have sign up already then enter correct email and password");
							textField.setText("");
							passwordField.setText("");
							frame6.setVisible(true);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
		next2.setForeground(new Color(0, 2, 49));
		next2.setFont(new Font("Agency FB", Font.BOLD, 30));
		next2.setBackground(new Color(143, 248, 224));
		next2.setBounds(639, 533, 96, 39);
		frame6.getContentPane().add(next2);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6.dispose();
				Category ca = new Category();
				ca.frame2.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 2, 49));
		back.setFont(new Font("Agency FB", Font.BOLD, 30));
		back.setBackground(new Color(143, 248, 224));
		back.setBounds(430, 533, 96, 39);
		frame6.getContentPane().add(back);
	}

}
