package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JEditorPane;

public class Teach_Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teach_Add frame = new Teach_Add();
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
	public Teach_Add() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		lblX.setBounds(652, 0, 48, 58);
		getContentPane().add(lblX);

		JLabel lblEnterStudentNameid = new JLabel("Enter Staff Name :");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterStudentNameid.setBounds(69, 69, 178, 39);
		contentPane.add(lblEnterStudentNameid);
		
		String field[]= {"Comps","Mech","IT","Civil","EXTC"};
		
		JComboBox comboBox = new JComboBox(field);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(257, 179, 109, 20);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(257, 79, 232, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblEnterPassword = new JLabel("Enter Password :");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterPassword.setBounds(69, 119, 178, 28);
		contentPane.add(lblEnterPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		passwordField.setBounds(257, 124, 232, 20);
		contentPane.add(passwordField);
		
		JLabel lblSelectCourse = new JLabel("Select Course:");
		lblSelectCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectCourse.setBounds(69, 174, 178, 28);
		contentPane.add(lblSelectCourse);
		
		JLabel lblAddTeacher = new JLabel("Add Teacher:");
		lblAddTeacher.setForeground(new Color(255, 255, 255));
		lblAddTeacher.setBounds(370, 11, 293, 41);
		lblAddTeacher.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblAddTeacher.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAddTeacher);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Teach_Add.class.getResource("/images/ADMIN BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String s=textField.getText();
				String pass=passwordField.getText();
				int uid=500;
				boolean w=true;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
					while(w)
					{
						String a=String.format("%03d", uid);
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
						p1.setString(1, a);
						ResultSet rs=p1.executeQuery();
						if(rs.next())
						{
							uid++;
						}
						else
						{
							w=false;
						}
					}
					String a=String.format("%03d", uid);
					PreparedStatement p=(PreparedStatement)c.prepareStatement("insert into login values(?,?,?)");
					p.setString(1,a);
					p.setString(2,pass);
					p.setString(3, "T");
					boolean b=p.execute();
					int z=comboBox.getSelectedIndex();
					p=(PreparedStatement)c.prepareStatement("insert into teacher values(?,?,?)");
					p.setString(1,a);
					p.setString(2,s);
					p.setString(3, field[z]);
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("create table tt"+a+"(day varchar(10),l1 varchar(20),l2 varchar(20),l3 varchar(20),l4 varchar(20),l5 varchar(20),l6 varchar(20),l7 varchar(20),l8 varchar(20))");
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?,?,?)");
					p.setString(1,"Monday");
					p.setString(2, "Free");
					p.setString(3, "Free");
					p.setString(4, "Free");
					p.setString(5, "Free");
					p.setString(6, "Free");
					p.setString(7, "Free");
					p.setString(8, "Free");
					p.setString(9, "Free");
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?,?,?)");
					p.setString(1,"Tuesday");
					p.setString(2, "Free");
					p.setString(3, "Free");
					p.setString(4, "Free");
					p.setString(5, "Free");
					p.setString(6, "Free");
					p.setString(7, "Free");
					p.setString(8, "Free");
					p.setString(9, "Free");
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?,?,?)");
					p.setString(1,"Wednesday");
					p.setString(2, "Free");
					p.setString(3, "Free");
					p.setString(4, "Free");
					p.setString(5, "Free");
					p.setString(6, "Free");
					p.setString(7, "Free");
					p.setString(8, "Free");
					p.setString(9, "Free");
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?,?,?)");
					p.setString(1,"Thursday");
					p.setString(2, "Free");
					p.setString(3, "Free");
					p.setString(4, "Free");
					p.setString(5, "Free");
					p.setString(6, "Free");
					p.setString(7, "Free");
					p.setString(8, "Free");
					p.setString(9, "Free");
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into tt"+a+"  values(?,?,?,?,?,?,?,?,?)");
					p.setString(1,"Friday");
					p.setString(2, "Free");
					p.setString(3, "Free");
					p.setString(4, "Free");
					p.setString(5, "Free");
					p.setString(6, "Free");
					p.setString(7, "Free");
					p.setString(8, "Free");
					p.setString(9, "Free");
					b=p.execute();
					JOptionPane.showMessageDialog(null,"Your UID = "+a);
				}
				catch(Exception ez)
				{
					ez.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Teach_Add.class.getResource("/images/group.png")));
		lblNewLabel.setBounds(277, 255, 153, 96);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddTeacher_1 = new JLabel("ADD TEACHER");
		lblAddTeacher_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAddTeacher_1.setBounds(287, 349, 122, 14);
		contentPane.add(lblAddTeacher_1);
		
		contentPane.add(label);
		
		
		
		
	}
}
