package net.codejava.sql;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

//import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import net.proteanit.sql.DbUtils;
//import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatFactory;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AppointmentWithPatient {
	int id=0;
	int id1=0;
	String fName,lName,dfName,dlName;
	public JFrame frame;
	public JLabel lblNewLabel_3;
	private int DID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentWithPatient window = new AppointmentWithPatient();
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
	private JTable table;
	public AppointmentWithPatient() {
	    connection = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientReport si = new PatientReport();
				
				
				 frame.dispose();
				 PatientReport pr = new PatientReport();
				 pr.textField.setText(Integer.toString(id));
				 pr.textField_1.setText(Integer.toString(id1));
				 pr.textField_5.setText(fName);
				 pr.textField_6.setText(dfName);
				 pr.frame11.setVisible(true);
			
			}
		});
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(336, 118, 186, 38);
		frame.getContentPane().add(lblNewLabel_3);
		btnNewButton.setBounds(651, 490, 110, 38);
		btnNewButton.setForeground(new Color(0, 2, 49));
		
		btnNewButton.setBackground(new Color(146,211,207,255));
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor ID");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(24, 124, 195, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd"); 
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
				LocalDate now = LocalDate.now();
				LocalDate date= LocalDate.parse(dtf.format(now));
				String string = comboBox.getSelectedItem().toString();
				DID = Integer.parseInt(lblNewLabel_3.getText());
				String sql = "SELECT s.ScheduledTime ,pi.PatientId, pi.PatientFirstName+' '+pi.PatientLastName AS 'Patient Full Name',d.DoctorId,d.DoctorFirstName+' '+d.DoctorLastName AS 'Doctor Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
						+ " FROM SCEDULE s INNER JOIN Doctor d"
						+ " ON s.DoctorID = d.DoctorId"
						+ " INNER JOIN PATIENTINFO pi"
						+ " ON pi.PatientId = s.PatientId"
						+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime ";
				if(string == "Today") {
					LocalDate returnvalue = date.plusDays(1);
					LocalDate anDate = date.plusDays(0);
//					String sql = "SELECT s.ScheduledTime , pi.PatientFirstName+' '+pi.PatientLastName AS 'Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
//							+ " FROM SCEDULE s INNER JOIN Doctor d"
//							+ " ON s.DoctorID = d.DoctorId"
//							+ " INNER JOIN PATIENTINFO pi"
//							+ " ON pi.PatientId = s.PatientId"
//							+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime = '"+anDate+"'";  //+"' AND '"+returnvalue+"'";
					String sqString = sql+" = '"+anDate+"'";
					Statement statement;
					try {
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqString);
						table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(string == "Tommorow") {
					LocalDate returnvalue = date.plusDays(1);
					LocalDate anDate = date.plusDays(0);
//					String sql = "SELECT s.ScheduledTime , pi.PatientFirstName+' '+pi.PatientLastName AS 'Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
//							+ " FROM SCEDULE s INNER JOIN Doctor d"
//							+ " ON s.DoctorID = d.DoctorId"
//							+ " INNER JOIN PATIENTINFO pi"
//							+ " ON pi.PatientId = s.PatientId"
//							+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					String sqString = sql+" BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					Statement statement;
					try {
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqString);
						table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(string == "For the next 3 days") {
					LocalDate returnvalue = date.plusDays(2);
					LocalDate anDate = date.plusDays(0);
//					String sql = "SELECT s.ScheduledTime , pi.PatientFirstName+' '+pi.PatientLastName AS 'Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
//							+ " FROM SCEDULE s INNER JOIN Doctor d"
//							+ " ON s.DoctorID = d.DoctorId"
//							+ " INNER JOIN PATIENTINFO pi"
//							+ " ON pi.PatientId = s.PatientId"
//							+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					String sqString = sql+"BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					Statement statement;
					try {
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqString);
						table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(string == "For the next 4 days") {
					
					LocalDate returnvalue = date.plusDays(3);
					LocalDate anDate = date.plusDays(0);
//					String sql = "SELECT s.ScheduledTime , pi.PatientFirstName+' '+pi.PatientLastName AS 'Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
//							+ " FROM SCEDULE s INNER JOIN Doctor d"
//							+ " ON s.DoctorID = d.DoctorId"
//							+ " INNER JOIN PATIENTINFO pi"
//							+ " ON pi.PatientId = s.PatientId"
//							+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					String sqString = sql+"BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					Statement statement;
					try {
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqString);
						table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(string == "For the next 5 days") {
					
					LocalDate returnvalue = date.plusDays(4);
					LocalDate anDate = date.plusDays(0);
//					String sql = "SELECT s.ScheduledTime , pi.PatientFirstName+' '+pi.PatientLastName AS 'Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
//							+ " FROM SCEDULE s INNER JOIN Doctor d"
//							+ " ON s.DoctorID = d.DoctorId"
//							+ " INNER JOIN PATIENTINFO pi"
//							+ " ON pi.PatientId = s.PatientId"
//							+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					String sqString = sql+"BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					Statement statement;
					try {
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqString);
						table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(string == "For the next 6 days") {
					
					LocalDate returnvalue = date.plusDays(5);
					LocalDate anDate = date.plusDays(0);
//					String sql = "SELECT s.ScheduledTime , pi.PatientFirstName+' '+pi.PatientLastName AS 'Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
//							+ " FROM SCEDULE s INNER JOIN Doctor d"
//							+ " ON s.DoctorID = d.DoctorId"
//							+ " INNER JOIN PATIENTINFO pi"
//							+ " ON pi.PatientId = s.PatientId"
//							+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					String sqString = sql+"BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					Statement statement;
					try {
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqString);
						table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(string == "For the next 7 days") {
					
					LocalDate returnvalue = date.plusDays(6);
					LocalDate anDate = date.plusDays(0);
//					String sql = "SELECT s.ScheduledTime , pi.PatientFirstName+' '+pi.PatientLastName AS 'Full Name',pi.Age,pi.Gender,pi.Weight,pi.BloodGrp,pi.MedicalHistory"
//							+ " FROM SCEDULE s INNER JOIN Doctor d"
//							+ " ON s.DoctorID = d.DoctorId"
//							+ " INNER JOIN PATIENTINFO pi"
//							+ " ON pi.PatientId = s.PatientId"
//							+ " WHERE d.DoctorId = "+DID +" AND s.ScheduledTime BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					String sqString = sql+"BETWEEN '"+anDate+"' AND '"+returnvalue+"'";
					Statement statement;
					try {
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sqString);
						table.setModel(DbUtils.resultSetToTableModel(result));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Today", "Tommorow", "For the next 3 days", "For the next 4 days", "For the next 5 days", "For the next 6 days", "For the next 7 days"}));
		comboBox.setBounds(336, 180, 186, 38);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 255, 737, 177);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
					
				try {
					int row = table.getSelectedRow();
				    fName = (table.getModel().getValueAt(row, 2).toString());
				    lName = (table.getModel().getValueAt(row, 1).toString());
				    id=Integer.parseInt(lName);
				    dfName = (table.getModel().getValueAt(row, 4).toString());
				    dlName = (table.getModel().getValueAt(row, 3).toString());
				    id1=Integer.parseInt(dlName);
				    //dlName = (table.getModel().getValueAt(row, 1).toString());
					String sql = "SELECT * FROM PATIENT WHERE PatientId  = "+id;
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(sql);
					while(result.next()) {
						id = result.getInt("PatientId");
					}
					//table.setModel(DbUtils.resultSetToTableModel(result));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("See my appointment for");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(24, 177, 230, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("APPOINTMENT WITH PATIENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel.setBounds(211, 11, 356, 80);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, -27, 784, 661);
		Image img = new ImageIcon(this.getClass().getResource("/pattern.gif")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lblNewLabel_4);
	}
}
