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

public class Student extends JFrame {

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
					Student frame = new Student();
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
	public Student() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
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
		lblX.setBounds(646, 8, 54, 51);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Functions:");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(385, 8, 239, 51);
		contentPane.add(lblStudentsPortal);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Student.class.getResource("/images/STUDENT BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						String s=rs.getString(5);
						if(s.compareTo("None")==0)
						{
							JOptionPane.showMessageDialog(null,"Please Select A Course First");
						}
						else
						{
							TimetableS.main(usr);
						}
					}
				}
				catch(Exception ez)
				{
					ez.printStackTrace();
				}
			}
		});
		label_1.setIcon(new ImageIcon(Student.class.getResource("/images/schedule.png")));
		label_1.setBounds(87, 62, 83, 88);
		contentPane.add(label_1);

		JLabel lblTimeTable = new JLabel("TIME - TABLE");
		lblTimeTable.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTimeTable.setBounds(67, 143, 121, 14);
		contentPane.add(lblTimeTable);

		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						float atten=rs.getFloat(4);
						if(atten!=-1)
						{
							JOptionPane.showMessageDialog(null,"Your Attendance Is = "+atten+"%");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Your Attendance Is Not Yet Entered By Your Teacher");
						}
					}
				}
				catch(Exception ez)
				{
					ez.printStackTrace();
				}
			}
		});
		label_2.setIcon(new ImageIcon(Student.class.getResource("/images/classroom.png")));
		label_2.setBounds(267, 62, 92, 88);
		contentPane.add(label_2);


		JLabel lblAttendance = new JLabel("ATTENDANCE");
		lblAttendance.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAttendance.setBounds(241, 145, 118, 14);
		contentPane.add(lblAttendance);

		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						double a=rs.getDouble(3);
						if(a==-1)
						{
							JOptionPane.showMessageDialog(null,"Your Result Is Not Yet Available");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Your Marks Are = "+a+"%");
						}
					}
				}
				catch(Exception ez)
				{
					ez.printStackTrace();
				}
			}
		});
		label_3.setIcon(new ImageIcon(Student.class.getResource("/images/test.png")));
		label_3.setBounds(475, 70, 70, 75);
		contentPane.add(label_3);

		JLabel lblTestResults = new JLabel("TEST - RESULTS");
		lblTestResults.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTestResults.setBounds(433, 143, 135, 14);
		contentPane.add(lblTestResults);

		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p1.setString(1, usr);
					ResultSet rs=p1.executeQuery();
					if(rs.next())
					{
						String a=rs.getString(5);
						if(a.compareTo("None")==0)
						{
							JOptionPane.showMessageDialog(null,"Please Select Course First");
						}
						else
						{
							String fee="0";
							if(a.compareTo("Comps")==0)
							{
								fee="1,25,000";
							}
							else if(a.compareTo("IT")==0)
							{
								fee="90,000";
							}
							else if(a.compareTo("Mech")==0)
							{
								fee="1,00,000";
							}
							else if(a.compareTo("EXTC")==0)
							{
								fee="85,000";
							}
							else if(a.compareTo("Civil")==0)
							{
								fee="80,000";
							}
							Fees.main(usr,fee,a);
						}
					}
				}
				catch(Exception ez)
				{
					ez.printStackTrace();
				}
			}
		});
		label_4.setIcon(new ImageIcon(Student.class.getResource("/images/cash.png")));
		label_4.setBounds(190, 235, 92, 75);
		contentPane.add(label_4);

		JLabel lblPayFees = new JLabel("PAY - FEES");
		lblPayFees.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPayFees.setBounds(178, 313, 92, 14);
		contentPane.add(lblPayFees);

		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register.main(usr);
			}
		});
		label_5.setIcon(new ImageIcon(Student.class.getResource("/images/add-user.png")));
		label_5.setBounds(390, 235, 83, 75);
		contentPane.add(label_5);

		JLabel lblRegisterForCourse = new JLabel("REGISTER FOR COURSE");
		lblRegisterForCourse.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblRegisterForCourse.setBounds(350, 315, 182, 14);
		contentPane.add(lblRegisterForCourse);

		contentPane.add(label);

















	}
}
