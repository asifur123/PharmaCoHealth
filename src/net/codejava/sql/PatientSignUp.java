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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PatientSignUp {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientSignUp window = new PatientSignUp();
					window.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connecting;
	JFrame frame5;
	private JTextField textFieldPFN;
	private JTextField textFieldPLN;
	private JTextField textFieldPPN;
	private JTextField textFieldPEMAIL;
	private JPasswordField PpasswordField;
	
	public PatientSignUp() {
		connecting = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame5 = new JFrame();
		frame5.getContentPane().setBackground(new Color(244,125,33,255));
		frame5.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame5.setBounds(100, 100, 800, 700);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-189, 0, 590, 661);
		Image img = new ImageIcon(this.getClass().getResource("/patient2.gif")).getImage();
		
		JButton next2 = new JButton("Next");
		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//String url = "jdbc:sqlserver://LAPTOP-Q876CUHC\\SQLEXPRESS:1433;databaseName=HospitalManagement";
					//String user = "sa";
					//String password = "123456";
					//Connection conn = DriverManager.getConnection(url,user,password);
					//PatientId int IDENTITY(1,1) PRIMARY KEY,
					//PatientFirstName varchar(20) NOT NULL,
					//PatientLastName varchar(20) NOT NULL,
					//PatientPhoneNo varchar(15) NOT NULL,
					//Email varchar(20) NOT NULL,
					//Password varchar(20) NOT NULL,
					
					String PFN = textFieldPFN.getText();
					String PLN = textFieldPLN.getText();
					String PEMAIL = textFieldPEMAIL.getText();
					String PPN = textFieldPPN.getText();
					String PPF = PpasswordField.getText();
					
					if(textFieldPFN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your First Name");
					}else if(textFieldPLN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Last Name");
					}else if(textFieldPEMAIL.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Email");
					}else if(textFieldPPN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Phone Number");
					}else if(PpasswordField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Password");
					}
					if(!textFieldPEMAIL.getText().isEmpty()) {
						String sqlString = "SELECT * FROM PATIENT WHERE Email = '"+PEMAIL+"'";
						Statement statement = connecting.createStatement();
						ResultSet resultSet = statement.executeQuery(sqlString);
						if(resultSet.next()) {
							JOptionPane.showMessageDialog(null, "This email account already exist... Please try another email id");
							textFieldPEMAIL.setText("");
						}
					}
					if(!textFieldPFN.getText().isEmpty() && !textFieldPLN.getText().isEmpty() && !textFieldPEMAIL.getText().isEmpty() && !textFieldPPN.getText().isEmpty() && !PpasswordField.getText().isEmpty()) {
						
						String sql = "INSERT INTO PATIENT (PatientFirstName,PatientLastName,PatientPhoneNo,Email,Password) VALUES("+"'"+PFN+"',"+"'"+PLN+"',"+"'"+PPN+"',"+"'"+PEMAIL+"',"+"'"+PPF+"'"+")";
						Statement statement = connecting.createStatement();
						int rows = statement.executeUpdate(sql);
						if(rows > 1) {
							System.out.println("Executed Successfully");
						}
						frame5.dispose();
						PatientSignIn si = new PatientSignIn();
						si.frame8.setVisible(true);
						connecting.close();
					}else {
						frame5.setVisible(true);
					}
					//edit baki
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
			
			}
		});
		next2.setForeground(new Color(0, 2, 49));
		next2.setFont(new Font("Agency FB", Font.BOLD, 30));
		next2.setBackground(new Color(255,206,0,255));
		next2.setBounds(647, 516, 96, 39);
		frame5.getContentPane().add(next2);
		
		JLabel lblNewLabel_2 = new JLabel("Patient's Last Name");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(418, 204, 178, 43);
		frame5.getContentPane().add(lblNewLabel_2);
		
		textFieldPEMAIL = new JTextField();
		textFieldPEMAIL.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPEMAIL.setColumns(10);
		textFieldPEMAIL.setBounds(646, 362, 108, 31);
		frame5.getContentPane().add(textFieldPEMAIL);
		
		JLabel lblNewLabel_7 = new JLabel("Patient's First Name");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(418, 136, 186, 39);
		frame5.getContentPane().add(lblNewLabel_7);
		
		textFieldPLN = new JTextField();
		textFieldPLN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPLN.setColumns(10);
		textFieldPLN.setBounds(646, 211, 108, 31);
		frame5.getContentPane().add(textFieldPLN);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(418, 421, 108, 48);
		frame5.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(418, 356, 108, 41);
		frame5.getContentPane().add(lblNewLabel_3);
		
		textFieldPFN = new JTextField();
		textFieldPFN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPFN.setColumns(10);
		textFieldPFN.setBounds(647, 141, 108, 31);
		frame5.getContentPane().add(textFieldPFN);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame5.dispose();
				Category ca = new Category();
				ca.frame2.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 2, 49));
		back.setFont(new Font("Agency FB", Font.BOLD, 30));
		back.setBackground(new Color(255,206,0,255));
		back.setBounds(418, 516, 96, 39);
		frame5.getContentPane().add(back);
		
		JLabel lblNewLabel_5 = new JLabel("Patient's Phone Number");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(418, 280, 218, 42);
		frame5.getContentPane().add(lblNewLabel_5);
		
		textFieldPPN = new JTextField();
		textFieldPPN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPPN.setColumns(10);
		textFieldPPN.setBounds(646, 287, 108, 31);
		frame5.getContentPane().add(textFieldPPN);
		
		PpasswordField = new JPasswordField();
		PpasswordField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		PpasswordField.setBounds(646, 431, 108, 31);
		frame5.getContentPane().add(PpasswordField);
		
		JLabel lblPatientssSignUp = new JLabel("PATIENTS'S SIGN UP PAGE");
		lblPatientssSignUp.setForeground(Color.BLACK);
		lblPatientssSignUp.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblPatientssSignUp.setBounds(471, 27, 272, 58);
		frame5.getContentPane().add(lblPatientssSignUp);
		lblNewLabel.setIcon(new ImageIcon(img));
		frame5.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(407, 0, 377, 661);
		frame5.getContentPane().add(lblNewLabel_1);
	}
}
