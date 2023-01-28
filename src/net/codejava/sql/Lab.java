package net.codejava.sql;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lab {

	JFrame frame15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab window = new Lab();
					window.frame15.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame15 = new JFrame();
		frame15.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		frame15.setBounds(100, 100, 800, 700);
		frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame15.getContentPane().setLayout(null);
		frame15.getContentPane().setBackground(new Color(229,219,203,255));
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setForeground(new Color (72,36,61,255));
		exit.setFont(new Font("Agency FB", Font.BOLD, 30));
		exit.setBackground(new Color(249,193,133,255));

		exit.setBounds(324, 621, 125, 40);
		frame15.getContentPane().add(exit);

		
		JLabel LabLabel = new JLabel("");
		LabLabel.setBounds(0, 61, 784, 600);
		frame15.getContentPane().add(LabLabel);
		Image img4 = new ImageIcon(this.getClass().getResource("/LAB.gif")).getImage();
		LabLabel.setIcon(new ImageIcon(img4));
		
		JLabel lblNewLabel = new JLabel("LABORATORY");
		//rgba(72,36,61,255)
		lblNewLabel.setForeground(new Color(72,36,61,255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel.setBounds(0, 0, 784, 60);
		frame15.getContentPane().add(lblNewLabel);
	}

}
