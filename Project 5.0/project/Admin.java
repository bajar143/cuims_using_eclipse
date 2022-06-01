package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;

	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180,700,450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblX = new JLabel("");
	
		lblX.setIcon(new ImageIcon(Admin.class.getResource("/images/logout.png")));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(633, 1, 67, 61);
		getContentPane().add(lblX);
		
		JLabel lblWlecomeAdministrator = new JLabel("Functions");
		lblWlecomeAdministrator.setForeground(Color.WHITE);
		lblWlecomeAdministrator.setFont(new Font("Sitka small", Font.BOLD, 28));
		lblWlecomeAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
		lblWlecomeAdministrator.setBounds(402, 11, 228, 42);
	
		
		contentPane.add(lblWlecomeAdministrator);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Teach_Add.main();
			}
		});
		label.setIcon(new ImageIcon(Admin.class.getResource("/images/add-user.png")));
		label.setBounds(223, 155, 64, 64);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Teach_Del.main();
			}
		});
		label_1.setIcon(new ImageIcon(Admin.class.getResource("/images/delete-user.png")));
		label_1.setBounds(365, 155, 64, 64);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stud_Add.main();
			}
		});
		label_2.setIcon(new ImageIcon(Admin.class.getResource("/images/add-friend.png")));
		label_2.setBounds(105, 64, 64, 64);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stud_Del.main();
			}
		});
		label_3.setIcon(new ImageIcon(Admin.class.getResource("/images/remove-friend.png")));
		label_3.setBounds(502, 64, 64, 64);
		contentPane.add(label_3);
		
		JLabel lblAdd = new JLabel("ADD");
		lblAdd.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBackground(Color.BLACK);
		lblAdd.setBounds(94, 139, 94, 20);
		contentPane.add(lblAdd);
		
		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setBounds(94, 155, 94, 20);
		contentPane.add(lblStudent);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblDelete.setBackground(Color.BLACK);
		lblDelete.setBounds(485, 139, 110, 20);
		contentPane.add(lblDelete);
		
		JLabel label_5 = new JLabel("STUDENT");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_5.setBounds(485, 157, 110, 20);
		contentPane.add(label_5);
		
		JLabel label_4 = new JLabel("ADD");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(223, 230, 64, 20);
		contentPane.add(label_4);
		
		JLabel label_6 = new JLabel("DELETE");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(347, 230, 99, 20);
		contentPane.add(label_6);
		
		JLabel lblTeacher = new JLabel("TEACHER");
		lblTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacher.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblTeacher.setBounds(206, 250, 99, 20);
		contentPane.add(lblTeacher);
		
		JLabel lblTeacher_1 = new JLabel("TEACHER");
		lblTeacher_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacher_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblTeacher_1.setBounds(347, 252, 99, 20);
		contentPane.add(lblTeacher_1);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Replacement_Caller.main();
			}
		});
		label_7.setIcon(new ImageIcon(Admin.class.getResource("/images/replace.png")));
		label_7.setBounds(295, 281, 64, 64);
		contentPane.add(label_7);
		
		JLabel lblReplacementStaffFinder = new JLabel("REPLACEMENT STAFF FINDER");
		lblReplacementStaffFinder.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblReplacementStaffFinder.setHorizontalAlignment(SwingConstants.CENTER);
		lblReplacementStaffFinder.setBounds(172, 354, 344, 27);
		contentPane.add(lblReplacementStaffFinder);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReportT.main();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/images/report (2).png")));
		lblNewLabel.setBounds(83, 217, 64, 64);
		contentPane.add(lblNewLabel);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReportS.main();
			}
		});
		label_8.setIcon(new ImageIcon(Admin.class.getResource("/images/report (1).png")));
		label_8.setBounds(542, 217, 64, 64);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("TEACHER");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_9.setBounds(70, 290, 99, 20);
		contentPane.add(label_9);
		
		JLabel lblReport = new JLabel("REPORT");
		lblReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblReport.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblReport.setBounds(70, 313, 99, 20);
		contentPane.add(lblReport);
		
		JLabel label_10 = new JLabel("STUDENT");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_10.setBounds(524, 292, 94, 20);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("REPORT");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_11.setBounds(519, 315, 99, 20);
		contentPane.add(label_11);
		
		JLabel label1 = new JLabel(" ");
		label1.setIcon(new ImageIcon(Admin.class.getResource("/images/ADMIN BACKGROUND.png")));
		label1.setBounds(0, 1, 700, 450);
		
		contentPane.add(label1);
		
		
		
	}
}
