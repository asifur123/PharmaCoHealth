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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminSignUp {

	JFrame frame4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignUp window = new AdminSignUp();
					window.frame4.setVisible(true);
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
	private JPasswordField ApasswordField;
	private JTextField textFieldAEMAIL;
	private JTextField textFieldAPN;
	private JTextField textFieldALN;
	private JTextField textFieldAFN;
	public AdminSignUp() {
		connecting = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame4 = new JFrame();
		frame4.getContentPane().setBackground(new Color(228,235,237,255));
		frame4.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame4.setBounds(100, 100, 800, 700);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-198, 0, 592, 661);
		Image img = new ImageIcon(this.getClass().getResource("/admin2.gif")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		frame4.getContentPane().add(lblNewLabel);
		
		JLabel lblAdminsSignUp = new JLabel("ADMIN'S SIGN UP PAGE");
		lblAdminsSignUp.setForeground(new Color(7,49,74,255));
		lblAdminsSignUp.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblAdminsSignUp.setBounds(461, 51, 256, 58);
		frame4.getContentPane().add(lblAdminsSignUp);
		
		JLabel lblNewLabel_7 = new JLabel("Admin's First Name");
		lblNewLabel_7.setForeground(new Color(7,49,74,255));
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(434, 166, 186, 39);
		frame4.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("Admin's Last Name");
		lblNewLabel_2.setForeground(new Color(7,49,74,255));
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(434, 234, 178, 43);
		frame4.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setForeground(new Color(7,49,74,255));
		lblNewLabel_5.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(434, 303, 152, 42);
		frame4.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(7,49,74,255));
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(434, 379, 108, 41);
		frame4.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(7,49,74,255));
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(434, 444, 108, 48);
		frame4.getContentPane().add(lblNewLabel_4);
		
		ApasswordField = new JPasswordField();
		ApasswordField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		ApasswordField.setBounds(642, 454, 108, 31);
		frame4.getContentPane().add(ApasswordField);
		
		textFieldAEMAIL = new JTextField();
		textFieldAEMAIL.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldAEMAIL.setColumns(10);
		textFieldAEMAIL.setBounds(642, 385, 108, 31);
		frame4.getContentPane().add(textFieldAEMAIL);
		
		textFieldAPN = new JTextField();
		textFieldAPN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldAPN.setColumns(10);
		textFieldAPN.setBounds(642, 310, 108, 31);
		frame4.getContentPane().add(textFieldAPN);
		
		textFieldALN = new JTextField();
		textFieldALN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldALN.setColumns(10);
		textFieldALN.setBounds(642, 241, 108, 31);
		frame4.getContentPane().add(textFieldALN);
		
		textFieldAFN = new JTextField();
		textFieldAFN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldAFN.setColumns(10);
		textFieldAFN.setBounds(642, 171, 108, 31);
		frame4.getContentPane().add(textFieldAFN);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4.dispose();
				Category ca = new Category();
				ca.frame2.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 2, 49));
		back.setFont(new Font("Agency FB", Font.BOLD, 30));
		back.setBackground(new Color(143, 248, 224));
		back.setBounds(434, 539, 96, 39);
		frame4.getContentPane().add(back);
		
		JButton next2 = new JButton("Next");
		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//String url = "jdbc:sqlserver://LAPTOP-Q876CUHC\\SQLEXPRESS:1433;databaseName=HospitalManagement";
					//String user = "sa";
					//String password = "123456";
					//Connection conn = DriverManager.getConnection(url,user,password);
					//AdminFirstName varchar(20) NOT NULL,
					//AdminLastName varchar(20) NOT NULL,
					//AdminPhoneNo varchar(15) NOT NULL,
					//Email varchar(20) NOT NULL,
					//Password varchar(20) NOT NULL,
					String AFN = textFieldAFN.getText();
					String ALN = textFieldALN.getText();
					String AEMAIL = textFieldAEMAIL.getText();
					String APN = textFieldAPN.getText();
					String APF = ApasswordField.getText();
					
					if(textFieldAFN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your First Name");
					}else if(textFieldALN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Last Name");
					}else if(textFieldAEMAIL.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Email");
					}else if(textFieldAPN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Phone Number");
					}else if(ApasswordField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "You must enter your Password");
					}
					
					if(!textFieldAEMAIL.getText().isEmpty()) {
						String sqlString = "SELECT * FROM ADMINISTRATOR WHERE Email = '"+AEMAIL+"'";
						Statement statement = connecting.createStatement();
						ResultSet resultSet = statement.executeQuery(sqlString);
						if(resultSet.next()) {
							JOptionPane.showMessageDialog(null, "This email account already exist... Please try another email id");
							textFieldAEMAIL.setText("");
						}
					}
					
					if(!textFieldAFN.getText().isEmpty() && !textFieldALN.getText().isEmpty() && !textFieldAEMAIL.getText().isEmpty() && !textFieldAPN.getText().isEmpty() && !ApasswordField.getText().isEmpty()) {
						String sql = "INSERT INTO ADMINISTRATOR (AdminFirstName,AdminLastName,AdminPhoneNo,Email,Password) VALUES("+"'"+AFN+"',"+"'"+ALN+"',"+"'"+APN+"',"+"'"+AEMAIL+"',"+"'"+APF+"'"+")";
						Statement statement = connecting.createStatement();
						int rows = statement.executeUpdate(sql);
						if(rows > 0) {
							JOptionPane.showMessageDialog(null, "SignUp Successfull");
						}
						//edit baki
						frame4.dispose();
						AdminSignIn si = new AdminSignIn();
						si.frame7.setVisible(true);
						connecting.close();
					}else {
						frame4.setVisible(true);
					}
					
					//edit baki
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		next2.setForeground(new Color(0, 2, 49));
		next2.setFont(new Font("Agency FB", Font.BOLD, 30));
		next2.setBackground(new Color(143, 248, 224));
		next2.setBounds(643, 539, 96, 39);
		frame4.getContentPane().add(next2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(396, 0, 388, 650);
		frame4.getContentPane().add(lblNewLabel_1);
	}
}
