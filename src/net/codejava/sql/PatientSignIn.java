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

import com.sun.source.tree.WhileLoopTree;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PatientSignIn{

	JFrame frame8;
	private JTextField textField;
	private JPasswordField passwordField;
	String emaString,pasString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientSignIn window = new PatientSignIn();
					window.frame8.setVisible(true);
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
	String email;
	public PatientSignIn() {
		conn = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame8 = new JFrame();
		frame8.getContentPane().setBackground(new Color(244,125,33,255));
		frame8.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame8.setBounds(100, 100, 800, 700);
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/patient2.gif")).getImage();
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		passwordField.setBounds(632, 338, 108, 31);
		frame8.getContentPane().add(passwordField);
		
		JLabel lblPatientssSignUp = new JLabel("PATIENTS'S SIGN IN PAGE");
		lblPatientssSignUp.setForeground(Color.BLACK);
		lblPatientssSignUp.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblPatientssSignUp.setBounds(468, 118, 272, 58);
		frame8.getContentPane().add(lblPatientssSignUp);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame8.dispose();
				Category ca = new Category();
				ca.frame2.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 2, 49));
		back.setFont(new Font("Agency FB", Font.BOLD, 30));
		back.setBackground(new Color(255, 206, 0));
		back.setBounds(444, 475, 96, 39);
		frame8.getContentPane().add(back);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(448, 249, 108, 41);
		frame8.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(444, 328, 108, 48);
		frame8.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(632, 255, 108, 31);
		frame8.getContentPane().add(textField);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-183, 0, 590, 661);
		frame8.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = textField.getText();//
				emaString = email;
				String password = passwordField.getText();
				pasString = password;
				if(textField.getText().isEmpty() || passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Can't leave any field empty");//empty kina label
				}
				else if(!textField.getText().isEmpty() && !passwordField.getText().isEmpty()){
					String sql = "SELECT * FROM PATIENT WHERE Email = '"+email+"' AND Password = '"+password+"'";//empty nah thake
					try {
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(sql);//email r password er enty hole
						int id_1 = 0;//initialize
						String Fn = "";
						String Ln = "";
						//String DFn = "";
						while(result.next()) {//Auto show
							id_1 = result.getInt("PatientId");
							Fn = result.getString("PatientFirstName");
							Ln = result.getString("PatientLastName");
							//DFn = result.getString("DoctorFirstName");
						}
						if(id_1 != 0) { //means Patient sign up done
							String sqString = "SELECT pi.PatientId "
									+ "FROM PATIENTINFO pi INNER JOIN PATIENT p "
									+ "ON pi.PatientId = p.PatientId "
									+ "WHERE p.PatientId = "+id_1;
							Statement statement2 = conn.createStatement();
							ResultSet resultSet = statement2.executeQuery(sqString);
							int id_2 = 0;
							while(resultSet.next()){
								id_2 = resultSet.getInt("PatientId");
							}
							if(id_2 != 0) {
								//amr kaj krte hobe
								/*String sString = "SELECT p.PatientFirstName+' '+p.PatientLastName AS 'Patient Full Name', d.DoctorFirstName+' '+d.DoctorLastName AS 'Doctor Full Name',pr.Symptom, pr.Diagnosis, pr.PrescribedMedicine "
										+ "FROM PATIENTREPORT pr INNER JOIN DOCTOR d "
										+ "ON pr.DoctorId = d.DoctorId "
										+ "INNER JOIN PATIENT p "
										+ "ON pr.PatientId = p.PatientId "
										+ "WHERE p.PatientId = "+id_2;*/
								frame8.dispose();
								Lab si = new Lab();
								PatientReportRecord pr = new PatientReportRecord();
								//pr.textField.setText(PMH);
								pr.textField.setText(Integer.toString(id_2));
								pr.textField_1.setText(Fn+" "+Ln);
								pr.frame22.setVisible(true);
								
								//PatientReportRecord prr = new PatientReportRecord();
								//dInfo.textField_5.setText(Fn);
								//dInfo.textField_6.setText(DFn);
								
								//prr.frame22.setVisible(true);
							}else {
//								emaString = textField.getText();
//								pasString = passwordField.getText();
								String sql_2 = "SELECT * FROM PATIENT WHERE Email = '"+emaString+"' AND Password = '"+pasString+"'";
//								Statement statement3 = conn.createStatement();
//								ResultSet resultSet2 = statement3.executeQuery(sql_2);
//								int id_3 = 0;
//							    String Fn = "";
//								String Ln = "";
//								while(resultSet2.next()) {
//									 id_3 = result.getInt("PatientId");
//								     Fn = result.getString("PatientFirstName");
//								     Ln = result.getString("PatientLastName");
//								}
								
								 frame8.dispose();
								 PatientInformation si = new PatientInformation(email);
								 si.textFieldPID.setText(Integer.toString(id_1));
								 si.textFieldPFN.setText(Fn);
								 si.textFieldPLN.setText(Ln);
								 si.frame10.setVisible(true);
							}
						}else {
							
							JOptionPane.showMessageDialog(null, "Sign up First");
							textField.setText("");
							passwordField.setText("");
							frame8.dispose();
							PatientSignUp pSignUp = new PatientSignUp();
							pSignUp.frame5.setVisible(true);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnNewButton.setForeground(new Color(0, 2, 49));
		btnNewButton.setBackground(new Color(255, 206, 0));
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNewButton.setBounds(655, 475, 85, 39);
		frame8.getContentPane().add(btnNewButton);
		
		
	}
}
