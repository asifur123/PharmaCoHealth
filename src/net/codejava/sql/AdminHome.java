package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;

public class AdminHome {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
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
	public AdminHome() {
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("          Home");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(39, 56, 242, 66);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search Patient\r\n");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchInfo searchInfo = new SearchInfo();
				frame.dispose();
				searchInfo.frame9.setVisible(true);
			}
		});
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(39, 217, 253, 60);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Records\r\n");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientInfo pInfo = new PatientInfo();
				frame.dispose();
				pInfo.frame.setVisible(true);
			}
		});
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(39, 287, 253, 60);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Reserved Blood");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BloodBank bank = new BloodBank();
				frame.dispose();
				bank.frame.setVisible(true);
			}
		});
		lblNewLabel_1_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_2.setBounds(39, 432, 253, 60);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Log Out");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminSignIn aIn = new AdminSignIn();
				frame.dispose();
				aIn.frame7.setVisible(true);
			}
		});
		lblNewLabel_1_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_3.setBounds(39, 502, 253, 60);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Patient Visited");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NumberOfPatients nPatients = new NumberOfPatients();
				frame.dispose();
				nPatients.frame.setVisible(true);
			}
		});
		lblNewLabel_1_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(39, 356, 253, 60);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(204, 0, 582, 663);
		Image img = new ImageIcon(this.getClass().getResource("/hospital4.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel_2);
		
		//JLabel lblNewLabel_2 = new JLabel("");
		//Image img = new ImageIcon(this.getClass().getResource("/hospital4.jpg")).getImage();
		//lblNewLabel_2.setBounds(262, 10, 514, 643);
		//frame.getContentPane().add(lblNewLabel_2);
	}
}
