package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Timetable_Chooser extends JFrame {

	private JPanel contentPane;
	static private String user;
	/**
	 * Launch the application.
	 */
	public static void main(String args) {
		user=args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timetable_Chooser frame = new Timetable_Chooser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Timetable_Chooser() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.setForeground(Color.WHITE);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(662, 0, 38, 47);
		getContentPane().add(lblX);
		
		JButton btnFieldTimetable = new JButton("Field Timetable");
		btnFieldTimetable.setIcon(new ImageIcon(Timetable_Chooser.class.getResource("/images/edit.png")));
		btnFieldTimetable.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFieldTimetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TimetableT.main(user);
			}
		});
		btnFieldTimetable.setBounds(180, 110, 354, 82);
		contentPane.add(btnFieldTimetable);
		
		JButton btnYourPersonalTimetable = new JButton("Your Personal Timetable");
		btnYourPersonalTimetable.setIcon(new ImageIcon(Timetable_Chooser.class.getResource("/images/document.png")));
		btnYourPersonalTimetable.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnYourPersonalTimetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timetable_Personal.main(user);
			}
		});
		btnYourPersonalTimetable.setBounds(180, 233, 354, 82);
		contentPane.add(btnYourPersonalTimetable);
		
		JLabel lblTimetable = new JLabel("Timetable:");
		lblTimetable.setForeground(Color.WHITE);
		lblTimetable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimetable.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblTimetable.setBounds(403, 12, 224, 35);
		contentPane.add(lblTimetable);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(Timetable_Chooser.class.getResource("/images/TEACHER BACKGROUND.png")));
		lblNewLabel.setBounds(0, 0, 700, 450);
		contentPane.add(lblNewLabel);
	}
}
