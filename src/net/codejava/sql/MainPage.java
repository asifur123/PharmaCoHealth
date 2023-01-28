package net.codejava.sql;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class MainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	Connection conn;
	public MainPage() {
		conn = ConnectToSql.dbconnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Asif\\Downloads\\Desktop\\HospitalManagement\\image\\icon.png"));
		//frame.setUndecorated(true);
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(37,183,225,255));
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(240, 240, 240));
		Image img = new ImageIcon(this.getClass().getResource("/HMS.gif")).getImage();
		
		JLabel label2 = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
		label2.setFont(new Font("Agency FB", Font.BOLD, 36));
		label2.setForeground(Color.WHITE);
		label2.setBounds(113, 11, 561, 34);
		frame.getContentPane().add(label2);
		
		JButton next = new JButton("ENTER HMS");
		next.setForeground(new Color(0, 255, 255));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// one jframe to another jframe link
				frame.dispose();
				Category c = new Category();
				c.frame2.setVisible(true);
				
			}
	
		
		});
		
	
		next.setBackground(new Color(0, 2, 49, 255));
		next.setFont(new Font("Agency FB", Font.BOLD, 30));
		next.setBounds(305, 610, 165, 40);
		frame.getContentPane().add(next);
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 800, 700);
		frame.getContentPane().add(label);
		
	
		
	}
}

