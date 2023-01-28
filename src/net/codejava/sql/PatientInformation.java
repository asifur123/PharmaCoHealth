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
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PatientInformation {

	JFrame frame10;
	public int PID = 0;
	public JTextField textFieldPID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientInformation window = new PatientInformation();
					window.frame10.setVisible(true);
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
	String email ;
	public JTextField textFieldPA;
	public JTextField textFieldPLN;
	public JTextField textFieldPFN;
	public JTextField textFieldPW;
	public JButton next2;
	
	
	public PatientInformation() {
		//connecting = ConnectToSql.dbconnect();
		//initialize();
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public PatientInformation(String email) {
		
		connecting = ConnectToSql.dbconnect();
		this.email = email;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame10 = new JFrame();
		frame10.getContentPane().setBackground(new Color(255,255,255,255));
		frame10.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame10.setBounds(100, 100, 800, 700);
		frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame10.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-56, 97, 475, 564);
		Image img = new ImageIcon(this.getClass().getResource("/doctor7.jpg")).getImage();
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox_2.setBounds(664, 476, 108, 31);
		frame10.getContentPane().add(comboBox_2);
		
		textFieldPID = new JTextField();
		textFieldPID.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPID.setColumns(10);
		textFieldPID.setBounds(664, 126, 108, 31);
		frame10.getContentPane().add(textFieldPID);
		
		JLabel lblNewLabel_2_1 = new JLabel("Patient ID");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(436, 119, 178, 43);
		frame10.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Medical History");
		lblNewLabel_5_1.setForeground(Color.BLACK);
		lblNewLabel_5_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_5_1.setBounds(436, 523, 218, 42);
		frame10.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Gender");
		lblNewLabel_7_1.setForeground(Color.BLACK);
		lblNewLabel_7_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7_1.setBounds(436, 472, 150, 39);
		frame10.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7 = new JLabel("Patient's First Name");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(436, 184, 186, 39);
		frame10.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("Age");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(436, 298, 218, 42);
		frame10.getContentPane().add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		comboBox.setBounds(663, 360, 109, 31);
		frame10.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Dermatology", "Infectious disease", "Diabetes", "Respiratory", "Cancer", "Gastro", "Heart "}));
		comboBox_1.setBounds(664, 537, 108, 31);
		frame10.getContentPane().add(comboBox_1);
		
		next2 = new JButton("Next");
		next2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String sql_for_PI = "SELECT * FROM PATIENT WHERE Email = '"+email+"'";
					Statement statement = connecting.createStatement();
					ResultSet result = statement.executeQuery(sql_for_PI);
					//lblNewLabel_1.setText("PatientLastName");
					//textFieldPLN.setText(result.getString("PatientLastName"));
					//int PID = textFieldPID.
					PID = Integer.parseInt(textFieldPID.getText());
					String PFN = textFieldPFN.getText();
					String PLN = textFieldPLN.getText();
					String PA = textFieldPA.getText();
					String PW = textFieldPW.getText();
					String PG = comboBox_2.getSelectedItem().toString();
					String PMH = comboBox_1.getSelectedItem().toString();
					String Blood = comboBox.getSelectedItem().toString();
					String sql = "INSERT INTO PATIENTINFO (PatientFirstName,PatientLastName,Age,Weight,Gender,MedicalHistory,PatientId,BloodGrp) VALUES("+"'"+PFN+"',"+"'"+PLN+"',"+"'"+PA+"',"+"'"+PW+"',"+"'"+PG+"',"+"'"+PMH+"',"+PID+",'"+Blood+"')";
				    statement = connecting.createStatement();																
					int rows = statement.executeUpdate(sql);
					if(rows > 1) {
						System.out.println("Executed Successfully");
					}
					//edit baki
					frame10.dispose();
					Lab si = new Lab();
					PatientSearchDoctor pS = new PatientSearchDoctor();
					pS.textField.setText(PMH);
					pS.lblNewLabel_4.setText(Integer.toString(PID));
					pS.frame.setVisible(true);
					//si.frame15.setVisible(true);
					connecting.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		next2.setForeground(new Color(0, 2, 49));
		next2.setFont(new Font("Agency FB", Font.BOLD, 30));
		next2.setBackground(new Color(255, 206, 0));
		next2.setBounds(676, 611, 96, 39);
		frame10.getContentPane().add(next2);
		
		textFieldPLN = new JTextField();
		textFieldPLN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPLN.setColumns(10);
		textFieldPLN.setBounds(664, 246, 108, 31);
		frame10.getContentPane().add(textFieldPLN);
		
		JLabel lblNewLabel_2 = new JLabel("Patient's Last Name");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(436, 239, 178, 43);
		frame10.getContentPane().add(lblNewLabel_2);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame10.dispose();
				PatientSignIn si = new PatientSignIn();
				si.frame8.setVisible(true);
			}
		});
		back.setForeground(new Color(0, 2, 49));
		back.setFont(new Font("Agency FB", Font.BOLD, 30));
		back.setBackground(new Color(255, 206, 0));
		back.setBounds(436, 611, 96, 39);
		frame10.getContentPane().add(back);
		
		textFieldPFN = new JTextField();
		textFieldPFN.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPFN.setColumns(10);
		textFieldPFN.setBounds(664, 189, 108, 31);
		frame10.getContentPane().add(textFieldPFN);
		
		textFieldPA = new JTextField();
		textFieldPA.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPA.setColumns(10);
		textFieldPA.setBounds(664, 305, 108, 31);
		frame10.getContentPane().add(textFieldPA);
		
		textFieldPW = new JTextField();
		textFieldPW.setFont(new Font("Agency FB", Font.PLAIN, 25));
		textFieldPW.setColumns(10);
		textFieldPW.setBounds(664, 417, 108, 31);
		frame10.getContentPane().add(textFieldPW);
		
		JLabel lblNewLabel_3 = new JLabel("Weight");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(436, 412, 108, 41);
		frame10.getContentPane().add(lblNewLabel_3);
		lblNewLabel.setIcon(new ImageIcon(img));
		frame10.getContentPane().add(lblNewLabel);
		
		JLabel lblSearchPatientInfo = new JLabel("PATIENT INFORMATION");
		lblSearchPatientInfo.setForeground(new Color(58,48,83,255));
		lblSearchPatientInfo.setFont(new Font("Agency FB", Font.PLAIN, 36));
		lblSearchPatientInfo.setBounds(286, 11, 222, 58);
		frame10.getContentPane().add(lblSearchPatientInfo);
		
		JLabel lblNewLabel_1 = new JLabel("Blood Group");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(436, 360, 125, 31);
		frame10.getContentPane().add(lblNewLabel_1);
		
		
		
	}
}
