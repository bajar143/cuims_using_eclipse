package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Attendance extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendance frame = new Attendance();
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
	public Attendance() throws ClassNotFoundException, SQLException {
		getContentPane().setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		getContentPane().setLayout(null);

		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(660, 0, 40, 44);
		getContentPane().add(lblX);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(324, 125, 145, 32);
		getContentPane().add(dateChooser);

		JLabel lblChooseDate = new JLabel("Choose Date : ");
		lblChooseDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChooseDate.setBounds(63, 125, 163, 32);
		getContentPane().add(lblChooseDate);

		JLabel lblEnterPresentStudent = new JLabel("Enter Absent Student UIDs");
		lblEnterPresentStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterPresentStudent.setBounds(63, 198, 232, 32);
		getContentPane().add(lblEnterPresentStudent);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(324, 198, 259, 32);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblSeperateEachUid = new JLabel("Seperate Each UID With A Space");
		lblSeperateEachUid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeperateEachUid.setForeground(Color.RED);
		lblSeperateEachUid.setBounds(241, 254, 232, 14);
		getContentPane().add(lblSeperateEachUid);

		JButton btnMakeChanges = new JButton("Confirm");
		btnMakeChanges.setIcon(new ImageIcon(Attendance.class.getResource("/images/confirm (2).png")));
		btnMakeChanges.setFont(new Font("Sitka Small", Font.BOLD, 16));
		btnMakeChanges.setBorder(BorderFactory.createLineBorder(Color.black,1));
		btnMakeChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String date="";
				String uids=textField.getText();
				String uid[]=uids.split(" ");
				int i = 0;
				try
				{
					Date d = dateChooser.getDate();
					SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
					date = dateFormat.format(dateChooser.getDate());
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select d"+date+" from attendance");
					boolean b=p.execute();
					while(i<uid.length)
					{
						String a=uid[i];
						p=(PreparedStatement)c.prepareStatement("update attendance set d"+date+"=? where uid=?");
						p.setString(1, "A");
						p.setString(2, a);
						b=p.execute();
						i++;
					}					
				}
				catch(SQLException ze)
				{
					try
					{
						PreparedStatement p=(PreparedStatement)c.prepareStatement("alter table attendance add d"+date+" varchar(2)");
						boolean b=p.execute();
						p=(PreparedStatement)c.prepareStatement("update attendance set d"+date+"='P'");
						b=p.execute();
						while(i<uid.length)
						{
							String a=uid[i];
							p=(PreparedStatement)c.prepareStatement("update attendance set d"+date+"=? where uid=?");
							p.setString(1, "A");
							p.setString(2, a);
							b=p.execute();
							i++;
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				try
				{
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from attendance");
					ResultSet rs=p.executeQuery();
					float atten,abs=0,pres=0;
					while(rs.next())
					{
						abs=0;pres=0;
						String uid1=rs.getString(1);
						int f=2;
						while(true)
						{
							try
							{
								String test=rs.getString(f);
								if(test==null)
								{
									
								}
								else
								{
									if(test.equals("A"))
										abs++;
									if(test.equals("P"))
										pres++;
								}
							}
							catch(SQLException e)
							{
								try
								{
									atten=pres/(abs+pres)*100;
								}
								catch(ArithmeticException ex)
								{
									atten=-1;
								}
								PreparedStatement p3=(PreparedStatement)c.prepareStatement("update student set attendance=? where uid=?");
								p3.setFloat(1, atten);
								p3.setString(2, uid1);
								boolean b3=p3.execute();
								break;
							}
							f++;
						}

					}

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				dispose();

			}
		});
		btnMakeChanges.setBounds(222, 295, 215, 55);
		getContentPane().add(btnMakeChanges);

		JLabel lblAttendance = new JLabel("Attendance");
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setForeground(Color.WHITE);
		lblAttendance.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblAttendance.setBounds(401, 16, 247, 28);
		getContentPane().add(lblAttendance);

		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Attendance.class.getResource("/images/TEACHER BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		getContentPane().add(label);


	}
}
