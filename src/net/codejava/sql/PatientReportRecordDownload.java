package net.codejava.sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;

public class PatientReportRecordDownload {

	public JFrame frame;
	public JPanel panel;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	public JLabel lblNewLabel_6;
	public JLabel lblNewLabel_7;
	public JLabel lblNewLabel_8;
	public JLabel lblNewLabel_9;
	public JLabel lblNewLabel_10;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientReportRecordDownload window = new PatientReportRecordDownload();
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
	public PatientReportRecordDownload() {
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
		
		panel = new JPanel();
		panel.setBounds(10, 10, 766, 590);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Patient's Name");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel.setBounds(44, 115, 245, 58);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Doctor's Name");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(44, 206, 245, 58);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Symptom");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(44, 290, 245, 58);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Diagnosis");
		lblNewLabel_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(44, 374, 245, 58);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Prescribed Medicine");
		lblNewLabel_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(44, 468, 245, 58);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("PATIENT REPORT RECORD");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Agency FB", Font.BOLD, 36));
		lblNewLabel_5.setBounds(180, 27, 336, 35);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(353, 115, 357, 52);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(353, 206, 357, 52);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(353, 290, 357, 52);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_9.setBounds(353, 374, 357, 52);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Agency FB", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(353, 468, 357, 52);
		panel.add(lblNewLabel_10);
		
		btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("Print Data");
				job.setPrintable(new Printable() {
					
					@Override
					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						// TODO Auto-generated method stub
						if(pageIndex > 0) {
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D q2 = (Graphics2D)graphics;
						q2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
						q2.scale(1, 1);
						
						panel.paint(q2);
						return Printable.PAGE_EXISTS;
					}
				});
				boolean ok = job.printDialog();
				if(ok) {
					try {
						job.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btnNewButton.setBounds(570, 616, 181, 37);
		frame.getContentPane().add(btnNewButton);
	}
}
