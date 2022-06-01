package project;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Teacher extends JFrame {

	private JPanel contentPane;
	static String usr;
	/**
	 * Launch the application.
	 */
	public static void main(String u) {
		usr=u;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher frame = new Teacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Teacher() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 709, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("");
		lblX.setIcon(new ImageIcon(Student.class.getResource("/images/logout.png")));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(647, 7, 55, 51);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Functions:");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(371, 11, 266, 46);
		contentPane.add(lblStudentsPortal);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Teacher.class.getResource("/images/TEACHER BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Timetable_Chooser.main(usr);
			}
		});
		label_1.setBackground(Color.BLACK);
		label_1.setIcon(new ImageIcon(Teacher.class.getResource("/images/schedule.png")));
		label_1.setBounds(90, 62, 75, 73);
	
		contentPane.add(label_1);
		
		JLabel lblTimeTable = new JLabel("TIME TABLE");
		lblTimeTable.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTimeTable.setBounds(75, 137, 101, 14);
		contentPane.add(lblTimeTable);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Marks.main(usr);
			}
		});
		label_2.setIcon(new ImageIcon(Teacher.class.getResource("/images/responsive.png")));
		label_2.setBounds(276, 62, 75, 73);
		contentPane.add(label_2);
		
		JLabel lblStudentMarks = new JLabel("STUDENT MARKS");
		lblStudentMarks.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudentMarks.setBounds(233, 137, 145, 14);
		contentPane.add(lblStudentMarks);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Attendance.main();
			}
		});
		label_4.setIcon(new ImageIcon(Teacher.class.getResource("/images/classroom.png")));
		label_4.setBounds(476, 68, 75, 67);
		contentPane.add(label_4);
		
		JLabel lblStudentAttendance = new JLabel("STUDENT ");
		lblStudentAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudentAttendance.setBounds(476, 137, 90, 14);
		contentPane.add(lblStudentAttendance);

		JLabel lblAttendance = new JLabel("ATTENDANCE");
		lblAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAttendance.setBounds(460, 156, 128, 14);
		contentPane.add(lblAttendance);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						List.main(rs.getString(3));
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		label_3.setIcon(new ImageIcon(Teacher.class.getResource("/images/desk-chair.png")));
		label_3.setBounds(90, 218, 75, 68);
		contentPane.add(label_3);
		
		JLabel lblStudent = new JLabel("ALL STUDENT");
		lblStudent.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudent.setBounds(75, 297, 108, 14);
		contentPane.add(lblStudent);
		JLabel lblDetails = new JLabel("DETAILS");
		lblDetails.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDetails.setBounds(90, 322, 75, 14);
		contentPane.add(lblDetails);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangeCourse.main();
			}
		});
		label_5.setIcon(new ImageIcon(Teacher.class.getResource("/images/online.png")));
		label_5.setBounds(276, 218, 75, 73);
		contentPane.add(label_5);
		
		JLabel lblChange = new JLabel("CHANGE");
		lblChange.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblChange.setBounds(276, 297, 75, 14);
		contentPane.add(lblChange);
		
		JLabel lblStudent_1 = new JLabel("STUDENT COURSE");
		lblStudent_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudent_1.setBounds(249, 322, 145, 14);
		contentPane.add(lblStudent_1);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
					p.setString(1, usr);
					ResultSet r=p.executeQuery();
					if(r.next())
					{
						String field=r.getString(3);
						Replacement_Caller_2.main(field);
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		label_6.setIcon(new ImageIcon(Teacher.class.getResource("/images/teacher.png")));
		label_6.setBounds(482, 218, 69, 73);
		contentPane.add(label_6);
		
		JLabel lblReplacement = new JLabel("REPLACEMENT");
		lblReplacement.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblReplacement.setBounds(460, 297, 128, 14);
		contentPane.add(lblReplacement);
		
		JLabel lblNewLabel = new JLabel("STAFF - FINDER");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(460, 322, 128, 14);
		contentPane.add(lblNewLabel);
		JLabel label_7 = new JLabel("");
		label_7.setBackground(SystemColor.activeCaption);
		label_7.setBounds(57, 62, 531, 300);
		//label_7.setOpaque(true);
		contentPane.add(label_7);
		
		
		contentPane.add(label);
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
