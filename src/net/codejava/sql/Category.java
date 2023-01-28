package net.codejava.sql;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Category {

	JFrame frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category window = new Category();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Category() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame2.setBounds(100, 100, 800, 700);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JLabel AdminLabel = new JLabel("");
		AdminLabel.setBounds(10, 108, 250, 250);
		frame2.getContentPane().add(AdminLabel);
		Image img = new ImageIcon(this.getClass().getResource("/admin1.png")).getImage();
		AdminLabel.setIcon(new ImageIcon(img));
		
		JLabel DoctorLabel = new JLabel("");
		DoctorLabel.setBounds(264, 108, 256, 250);
		frame2.getContentPane().add(DoctorLabel);
		Image img2 = new ImageIcon(this.getClass().getResource("/doctor1.png")).getImage();
		DoctorLabel.setIcon(new ImageIcon(img2));
		
		JLabel PatientLabel = new JLabel("");
		PatientLabel.setBounds(524, 108, 250, 250);
		frame2.getContentPane().add(PatientLabel);
		Image img3 = new ImageIcon(this.getClass().getResource("/patient1.jpg")).getImage();
		PatientLabel.setIcon(new ImageIcon(img3));
		
		JLabel label1 = new JLabel("ADMIN");
		label1.setFont(new Font("Agency FB", Font.BOLD, 30));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(10, 388, 250, 40);
		frame2.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("DOCTOR");
		label2.setFont(new Font("Agency FB", Font.BOLD, 30));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(270, 388, 250, 40);
		frame2.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("PATIENT");
		label3.setFont(new Font("Agency FB", Font.BOLD, 30));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(524, 388, 250, 40);
		frame2.getContentPane().add(label3);
		
		JButton PatientSignIn = new JButton("SIGN IN");
		PatientSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				PatientSignIn si = new PatientSignIn();
				si.frame8.setVisible(true);
			
			}
		});
		PatientSignIn.setForeground(Color.CYAN);
		PatientSignIn.setFont(new Font("Agency FB", Font.BOLD, 30));
		PatientSignIn.setBackground(new Color(0, 2, 49));
		PatientSignIn.setBounds(584, 556, 125, 40);
		frame2.getContentPane().add(PatientSignIn);
		
		JLabel lblNewLabel = new JLabel("CATEGORY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel.setBounds(10, 11, 764, 65);
		frame2.getContentPane().add(lblNewLabel);
		
		JButton AdminSignup = new JButton("SIGN UP");
		AdminSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				AdminSignUp ad = new AdminSignUp();
				ad.frame4.setVisible(true);
			}
		});
		AdminSignup.setForeground(Color.CYAN);
		AdminSignup.setFont(new Font("Agency FB", Font.BOLD, 30));
		AdminSignup.setBackground(new Color(0, 2, 49));
		AdminSignup.setBounds(76, 453, 125, 40);
		frame2.getContentPane().add(AdminSignup);
		
		JButton DoctorSignup = new JButton("SIGN UP");
		DoctorSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				DoctorSignUp doc = new DoctorSignUp();
				doc.frame3.setVisible(true);
			}
		});
		DoctorSignup.setForeground(Color.CYAN);
		DoctorSignup.setFont(new Font("Agency FB", Font.BOLD, 30));
		DoctorSignup.setBackground(new Color(0, 2, 49));
		DoctorSignup.setBounds(335, 453, 125, 40);
		frame2.getContentPane().add(DoctorSignup);
		
		JButton PatientSignup = new JButton("SIGN UP");
		PatientSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				PatientSignUp p = new PatientSignUp();
				p.frame5.setVisible(true);
			}
		});
		PatientSignup.setForeground(Color.CYAN);
		PatientSignup.setFont(new Font("Agency FB", Font.BOLD, 30));
		PatientSignup.setBackground(new Color(0, 2, 49));
		PatientSignup.setBounds(584, 453, 125, 40);
		frame2.getContentPane().add(PatientSignup);
		
		JButton AdminSignIn = new JButton("SIGN IN");
		AdminSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				AdminSignIn si = new AdminSignIn();
				si.frame7.setVisible(true);
			}
		});
		AdminSignIn.setForeground(Color.CYAN);
		AdminSignIn.setFont(new Font("Agency FB", Font.BOLD, 30));
		AdminSignIn.setBackground(new Color(0, 2, 49));
		AdminSignIn.setBounds(76, 556, 125, 40);
		frame2.getContentPane().add(AdminSignIn);
		
		JButton DoctorSignIn = new JButton("SIGN IN");
		DoctorSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
				DoctorSignIn si = new DoctorSignIn();
				si.frame6.setVisible(true);
			}
		});
		DoctorSignIn.setForeground(Color.CYAN);
		DoctorSignIn.setFont(new Font("Agency FB", Font.BOLD, 30));
		DoctorSignIn.setBackground(new Color(0, 2, 49));
		DoctorSignIn.setBounds(335, 556, 125, 40);
		frame2.getContentPane().add(DoctorSignIn);
	}
}

