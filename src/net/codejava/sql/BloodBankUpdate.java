package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class BloodBankUpdate {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodBankUpdate window = new BloodBankUpdate();
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
	public BloodBankUpdate() {
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Blood Group");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(69, 146, 276, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox.setBounds(492, 146, 241, 53);
		frame.getContentPane().add(comboBox);
		
		JLabel lblHowManyLiters = new JLabel("How many liters have arrived?\r\n");
		lblHowManyLiters.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblHowManyLiters.setBounds(69, 277, 276, 53);
		frame.getContentPane().add(lblHowManyLiters);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 30));
		textField.setBounds(492, 277, 241, 53);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHowManyLiters_2 = new JLabel("How many liters have been given to patient?\r\n");
		lblHowManyLiters_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblHowManyLiters_2.setBounds(69, 409, 403, 53);
		frame.getContentPane().add(lblHowManyLiters_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(492, 409, 241, 53);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BloodBank bank = new BloodBank();
				frame.dispose();
				bank.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnNewButton.setBounds(593, 587, 162, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloodgrp = comboBox.getSelectedItem().toString();
				if(textField.getText().isEmpty() && textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Amouont");
				}else if(!(textField.getText().isEmpty()) && textField_1.getText().isEmpty()) {
					String sqlString = "UPDATE BloodBank "
							+ "SET Amount = (SELECT Amount FROM BloodBank WHERE BloodGrp = '"+bloodgrp+"')+"+Integer.parseInt(textField.getText())
							+ " WHERE BloodGrp = '"+bloodgrp+"'";
					try {
						Statement statement = connection.createStatement();
						int rows = statement.executeUpdate(sqlString);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Update Successful");
				}else if(!(textField_1.getText().isEmpty()) && textField.getText().isEmpty()) {
					String sqlString_1 = "UPDATE BloodBank "
							+ "SET Amount = (SELECT Amount FROM BloodBank WHERE BloodGrp = '"+bloodgrp+"')-"+Integer.parseInt(textField_1.getText())
							+ " WHERE BloodGrp = '"+bloodgrp+"'";
					
					try {
						Statement statement = connection.createStatement();
						int rows = statement.executeUpdate(sqlString_1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Update Successful");
				}else {
					String sqlString_1 = "UPDATE BloodBank "
							+ "SET Amount = (SELECT Amount FROM BloodBank WHERE BloodGrp = '"+bloodgrp+"')-"+Integer.parseInt(textField_1.getText())
							+ " WHERE BloodGrp = '"+bloodgrp+"'";
					
					try {
						Statement statement_1 = connection.createStatement();
						int rows_1 = statement_1.executeUpdate(sqlString_1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String sqlString_2 = "UPDATE BloodBank "
							+ "SET Amount = (SELECT Amount FROM BloodBank WHERE BloodGrp = '"+bloodgrp+"')+"+Integer.parseInt(textField.getText())
							+ " WHERE BloodGrp = '"+bloodgrp+"'";
					
					try {
						Statement statement_2 = connection.createStatement();
						int rows_2 = statement_2.executeUpdate(sqlString_2);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Update Successful");
				}
			}
		});
		btnUpdate.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnUpdate.setBounds(593, 508, 162, 53);
		frame.getContentPane().add(btnUpdate);
	}
}
