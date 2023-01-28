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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminSignIn {

	JFrame frame7;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignIn window = new AdminSignIn();
					window.frame7.setVisible(true);
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
	public AdminSignIn() {
		conn = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame7 = new JFrame();
		frame7.getContentPane().setBackground(new Color(228,235,237,255));
		frame7.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame7.setBounds(100, 100, 800, 700);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/admin2.gif")).getImage();
		
		JLabel lblAdminsSignIn = new JLabel("ADMIN'S SIGN IN PAGE");
		lblAdminsSignIn.setForeground(new Color(7, 49, 74));
		lblAdminsSignIn.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblAdminsSignIn.setBounds(484, 82, 234, 58);
		frame7.getContentPane().add(lblAdminsSignIn);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(7, 49, 74));
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(436, 314, 108, 48);
		frame7.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(644, 241, 108, 31);
		frame7.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		passwordField.setBounds(644, 324, 108, 31);
		frame7.getContentPane().add(passwordField);
		
		JButton next2 = new JButton("Next");
		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = textField.getText();
				String password = passwordField.getText();
				
				if(textField.getText().isEmpty() && passwordField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Can't leave any field empty");
				}
				else {
					String sql = "SELECT * FROM ADMINISTRATOR WHERE Email = '"+email+"' AND Password = '"+password+"'";
					try {
						Statement statement = conn.createStatement();
						//int rows = statement.executeUpdate(sql);
						ResultSet result = statement.executeQuery(sql);
						if(result.next()) {
							//String pass = "12345";
							 //if(password == result.getString("Password")) {
							frame7.dispose();
//							SearchInfo si = new SearchInfo();
//							si.frame9.setVisible(true);
							AdminHome adminhome = new AdminHome();
							adminhome.frame.setVisible(true);
							 //}else {
								 
								 //frame8.setVisible(true);
							 //}
						}else {
							JOptionPane.showMessageDialog(null, "If you have sign up already then enter correct email and password");
							textField.setText("");
							passwordField.setText("");
							frame7.setVisible(true);
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
		next2.setBounds(656, 461, 96, 39);
		frame7.getContentPane().add(next2);
		
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame7.dispose();
				Category ca = new Category();
				ca.frame2.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 2, 49));
		back.setFont(new Font("Agency FB", Font.BOLD, 30));
		back.setBackground(new Color(143, 248, 224));
		back.setBounds(432, 461, 96, 39);
		frame7.getContentPane().add(back);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setForeground(new Color(7, 49, 74));
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(436, 235, 108, 41);
		frame7.getContentPane().add(lblNewLabel_3);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-183, 0, 592, 661);
		frame7.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(410, 0, 374, 661);
		frame7.getContentPane().add(lblNewLabel_1);
	}

}

