package net.codejava.sql;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.invoke.StringConcatFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PatientSearchDoctor {

	public JFrame frame;
	public JTextField textField;
	private JTable table;
	String fName,lName;
	public int id;
	public JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientSearchDoctor window = new PatientSearchDoctor();
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
	public PatientSearchDoctor() {
		
		connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 700);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame.getContentPane().setBackground(new Color(17,14,59,255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_5.setForeground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/planet.jpg")).getImage();
		
		JLabel lblNewLabel_6 = new JLabel("PATIENT SEARCH DOCTOR");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel_6.setBounds(239, 11, 331, 61);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Set Appoinment With");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(24, 511, 200, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(263, 117, 176, 39);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String string = textField.getText();
				String sql = "SELECT DoctorFirstName,DoctorLastName,DoctorPhoneNo,Email FROM Doctor WHERE Specialize = '"+string+"'";
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
		textField.setFont(new Font("Agency FB", Font.PLAIN, 30));
		textField.setBounds(263, 179, 176, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
//				SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd");
				AppointmentWithDoctor aWithDoctor = new AppointmentWithDoctor();
//				aWithDoctor.lblNewLabel_1.setText("Your Appointment has been set with"+fName+" "+lName);
//				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//				LocalDate now = LocalDate.now();
//				LocalDate date= LocalDate.parse(dtf.format(now));
//				LocalDate returnvalue = date.plusDays(6);
//				aWithDoctor.lblNewLabel_3.setText(dtf.format(returnvalue));
				
				//AppointmentWithDoctor appointmentWithDoctor = new AppointmentWithDoctor();
				aWithDoctor.lblNewLabel_7.setText(Integer.toString(id));
				aWithDoctor.lblNewLabel_5.setText(lblNewLabel_4.getText());
				aWithDoctor.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNewButton.setBounds(653, 566, 111, 48);
		btnNewButton.setBackground(new Color(234,80,129,255));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Specialize");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(24, 179, 176, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("...");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(24, 566, 331, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 250, 740, 242);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
				    fName = (table.getModel().getValueAt(row, 0).toString());
				    lName = (table.getModel().getValueAt(row, 1).toString());
					lblNewLabel_1.setText(fName+" "+lName);
					String sql = "SELECT * FROM Doctor WHERE DoctorFirstName  = '"+fName+"' AND DoctorLastname = '"+lName+"'";
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(sql);
					while(result.next()) {
						id = result.getInt("DoctorId");
					}
					//table.setModel(DbUtils.resultSetToTableModel(result));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Patient ID");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(24, 117, 176, 39);
		frame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_5.setIcon(new ImageIcon(img));
		lblNewLabel_5.setBounds(0, 0, 784, 661);
		frame.getContentPane().add(lblNewLabel_5);
	}

}
