package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

public class BloodBank {

	public JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodBank window = new BloodBank();
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
	public BloodBank() {
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame.setBounds(100, 100, 800, 700);
		frame.getContentPane().setBackground(new Color(229,219,203,255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BLOOD BANK");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(72,36,61,255));
		lblNewLabel.setBounds(323, 23, 187, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reserved Blood");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM BloodBank";
				try {
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(result));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(561, 162, 181, 53);
		btnNewButton.setForeground(new Color(72,36,61,255));
		btnNewButton.setBackground(new Color(249,193,133,255));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Patient's Blood Group");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(new Color(72,36,61,255));
		lblNewLabel_1.setBounds(50, 167, 211, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 30));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String string = textField.getText();
				String sql = "SELECT DISTINCT(p.BloodGrp) AS 'Patient Blood Group' , b.Amount AS 'Reserved Amount' FROM BloodBank b INNER JOIN PatientInfo p ON b.BloodGrp = p.bloodGrp AND p.bloodGRP = '"+string+"'";
				Statement statement;
				try {
					statement = connection.createStatement();
					ResultSet result = statement.executeQuery(sql);//query er result return kore
					table.setModel(DbUtils.resultSetToTableModel(result));//table e show kore
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField.setBounds(298, 168, 166, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 344, 707, 175);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminHome aHome  = new AdminHome();
				aHome.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNewButton_1.setForeground(new Color(72,36,61,255));
		btnNewButton_1.setBackground(new Color(249,193,133,255));
		btnNewButton_1.setBounds(653, 611, 89, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnUpdateAmount = new JButton("Update Amount");
		btnUpdateAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodBankUpdate bankUpdate = new BloodBankUpdate();
				frame.dispose();
				bankUpdate.frame.setVisible(true);
			}
		});
		btnUpdateAmount.setForeground(new Color(72, 36, 61));
		btnUpdateAmount.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnUpdateAmount.setBackground(new Color(249, 193, 133));
		btnUpdateAmount.setBounds(561, 231, 181, 53);
		frame.getContentPane().add(btnUpdateAmount);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 784, 661);
		Image img = new ImageIcon(this.getClass().getResource("/LAB.gif")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel_2);
		
	}
}
