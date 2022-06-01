package project;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JEditorPane;

public class Stud_Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stud_Add frame = new Stud_Add();
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
	public Stud_Add() {
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
		lblX.setBounds(654, 3, 46, 55);
		getContentPane().add(lblX);

		JLabel lblEnterStudentNameid = new JLabel("Enter Student Name:");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentNameid.setBounds(95, 131, 216, 39);
		contentPane.add(lblEnterStudentNameid);

		textField = new JTextField();
		textField.setBounds(322, 133, 227, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnCreate = new JButton("   Create");
		btnCreate.setBorder(BorderFactory.createLineBorder(Color.black,2));
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCreate.setIcon(new ImageIcon(Stud_Add.class.getResource("/images/add.png")));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				int i=new Random().nextInt(9999-1000)+1000;
				int uid=1;
				boolean w=true;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
					while(w)
					{
						String a=String.format("%03d", uid);
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
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
					PreparedStatement p=(PreparedStatement)c.prepareStatement("insert into student values(?,?,?,?,?,?)");
					p.setString(1,a);
					p.setString(2,s);
					p.setDouble(3,-1);
					p.setFloat(4,-1);
					p.setString(5,"None");
					p.setString(6,"U");
					boolean b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into login values(?,?,?)");
					p.setString(1,a);
					p.setString(2,Integer.toString(i));
					p.setString(3,"S");
					b=p.execute();
					p=(PreparedStatement)c.prepareStatement("insert into attendance (uid) values (?)");
					p.setString(1,a);
					b=p.execute();
					JOptionPane.showMessageDialog(null,"Your UID = "+a+"\nYour Password = "+i);
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
		btnCreate.setBounds(228, 249, 245, 55);
		contentPane.add(btnCreate);
		
		JLabel lblAddStudent = new JLabel("Add Student:");
		lblAddStudent.setBounds(365, 12, 279, 46);
		lblAddStudent.setForeground(Color.WHITE);
		lblAddStudent.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAddStudent);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Stud_Add.class.getResource("/images/ADMIN BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		contentPane.add(label);
	}
}
