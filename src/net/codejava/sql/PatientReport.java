package net.codejava.sql;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PatientReport {
	
	

	JFrame frame11;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_5;
	public JTextField textField_6;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientReport window = new PatientReport();
					window.frame11.setVisible(true);
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
	
	
	public PatientReport() {
		conn = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame11 = new JFrame();
		frame11.getContentPane().setBackground(new Color(251,182,170,255));

		frame11.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame11.setBounds(100, 100, 800, 700);
		frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame11.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -18, 400, 693);
		Image img = new ImageIcon(this.getClass().getResource("/pattern.gif")).getImage();
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Lisinopril", "Levothyroxine", "Azithromycin", "Metformin", "Lipitor", "Amlodipine", "Amoxicillin", "Hydrochlorothiazide"}));
		comboBox_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox_4.setBounds(603, 469, 171, 31);
		frame11.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Heart disease", "Cancer", "Unintentional injuries", "Chronic lower respiratory disease", "Stroke", "Cerebrovascular disease", "Alzheimers disease", "High Diabetes", "Influenza ", "Pneumonia"}));
		comboBox_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox_2.setBounds(603, 402, 171, 31);
		frame11.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Unusual fatigue", "Trouble sleeping", "Problems breathing", "Indigestion", "Anxiety", "Back or abdominal pain", "Weight loss", "Pain", "Nausea", "Vomiting,", "Lightheadedness", "Shortness of breath"}));
		comboBox_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox_1.setBounds(603, 341, 171, 31);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame11.dispose();
				DoctorSignIn si = new DoctorSignIn();
				si.frame6.setVisible(true);
			}
		});
		
		JButton next2 = new JButton("Next");
		next2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String PName = textField_5.getText();
				String DName = textField_6.getText();
				String symp = comboBox_1.getSelectedItem().toString();
				String diag = comboBox_2.getSelectedItem().toString();
				String PM = comboBox_4.getSelectedItem().toString();
				int dID = Integer.parseInt(textField_1.getText());
				int pID = Integer.parseInt(textField.getText());
				
				String sql = "INSERT INTO PATIENTREPORT (Symptom,Diagnosis,PrescribedMedicine,DoctorId,PatientId) VALUES ('"+symp+"','"+diag+"','"+PM+"',"+dID+","+pID+")";
				Statement statement;
				try {
					statement = conn.createStatement();
					//ResultSet result = statement.executeQuery(sql);
					int row = statement.executeUpdate(sql);
				
					frame11.dispose();
					 DownloadPatientInfo dp = new DownloadPatientInfo();
					 dp.textField_5.setText(PName);
					 dp.textField_6.setText(DName);
					 dp.textField_7.setText(symp);
					 dp.textField_8.setText(diag);
					 dp.textField_9.setText(PM);
					 dp.frame18.setVisible(true);
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		
		frame11.getContentPane().add(comboBox_1);
		next2.setForeground(new Color(0, 2, 49));
		next2.setFont(new Font("Agency FB", Font.BOLD, 30));
		next2.setBackground(new Color(146,211,207,255));
		next2.setBounds(655, 536, 96, 39);
		frame11.getContentPane().add(next2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_6.setColumns(10);
		textField_6.setBounds(603, 280, 171, 31);
		frame11.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Doctor's Name");
		lblNewLabel_7_1_1.setForeground(new Color(56, 73, 156));
		lblNewLabel_7_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7_1_1.setBounds(410, 275, 148, 39);
		frame11.getContentPane().add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Patient's Name");
		lblNewLabel_7_2.setForeground(new Color(56, 73, 156));
		lblNewLabel_7_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7_2.setBounds(410, 80, 148, 39);
		frame11.getContentPane().add(lblNewLabel_7_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_5.setBounds(603, 88, 171, 31);
		frame11.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		back.setForeground(new Color(0, 2, 49));
		back.setFont(new Font("Agency FB", Font.BOLD, 30));
		back.setBackground(new Color(146,211,207,255));
		back.setBounds(410, 536, 96, 39);
		frame11.getContentPane().add(back);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(603, 214, 171, 31);
		frame11.getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(603, 151, 171, 31);
		frame11.getContentPane().add(textField);
		
		JLabel lblNewLabel_7_1 = new JLabel("Doctor ID");
		lblNewLabel_7_1.setForeground(new Color(56, 73, 156));
		lblNewLabel_7_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7_1.setBounds(410, 209, 148, 39);
		frame11.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblSearchPatientInfo = new JLabel("PATIENT REPORT");
		lblSearchPatientInfo.setForeground(new Color(56,73,156,255));
		lblSearchPatientInfo.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblSearchPatientInfo.setBounds(504, 11, 186, 58);
		frame11.getContentPane().add(lblSearchPatientInfo);
		
		JLabel lblNewLabel_2 = new JLabel("Diagnosis");
		lblNewLabel_2.setForeground(new Color(56,73,156,255));
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(410, 402, 148, 39);
		frame11.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Symptom");
		lblNewLabel_1_1.setForeground(new Color(56,73,156,255));
		lblNewLabel_1_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(412, 337, 97, 39);
		frame11.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Prescribed Medicine");
		lblNewLabel_3.setForeground(new Color(56,73,156,255));
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(410, 469, 186, 39);
		frame11.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("Patient ID");
		lblNewLabel_7.setForeground(new Color(56,73,156,255));
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(410, 146, 148, 39);
		frame11.getContentPane().add(lblNewLabel_7);
		lblNewLabel.setIcon(new ImageIcon(img));
		frame11.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(401, 0, 383, 650);
		frame11.getContentPane().add(lblNewLabel_1);
		
		
	}
}
