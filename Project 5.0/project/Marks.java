package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class Marks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

static private String usr;
	
	/**
	 * Launch the application.
	 */
	public static void main(String u) {
		usr=u;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marks frame = new Marks();
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
	public Marks() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		getContentPane().setLayout(null);

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
		lblX.setBounds(647, 11, 53, 47);
		getContentPane().add(lblX);
		
		ArrayList x=new ArrayList();
		
		String fld="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
			PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from teacher where uid = ?");
			p1.setString(1, usr);
			ResultSet rs1=p1.executeQuery();
			if(rs1.next())
			{
				fld=rs1.getString(3);
			}
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where field = ?");
			p.setString(1, fld);
			ResultSet rs=p.executeQuery();
			while(rs.next()) 
			{
				x.add("("+rs.getString(1)+") "+rs.getString(2));
			}
		}
		catch(Exception ze)
		{
			ze.printStackTrace();
		}
		
		String[] cs = (String[]) x.toArray(new String[x.size()]);
		
		JComboBox comboBox = new JComboBox(cs);
		comboBox.setBounds(266, 79, 313, 24);
		getContentPane().add(comboBox);
		
		JLabel lblEnterMarksFor = new JLabel("Enter Marks For Subject (Out Of 100) :");
		lblEnterMarksFor.setBounds(73, 113, 307, 24);
		lblEnterMarksFor.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblEnterMarksFor);
		
		JLabel label = new JLabel("1:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(145, 169, 46, 14);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(249, 166, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("2:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(145, 206, 46, 14);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 203, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("3:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(145, 237, 46, 14);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(249, 234, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("4:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(425, 169, 46, 14);
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(493, 166, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("5:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(425, 200, 46, 14);
		getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(493, 197, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("6:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(425, 237, 46, 14);
		getContentPane().add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(493, 234, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSave = new JButton("Confirm");
		btnSave.setIcon(new ImageIcon(Marks.class.getResource("/images/confirm (2).png")));
		btnSave.setFont(new Font("Sitka Small", Font.BOLD, 16));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double avg=(Double.parseDouble(textField.getText())+Double.parseDouble(textField_1.getText())+Double.parseDouble(textField_2.getText())+Double.parseDouble(textField_3.getText())+Double.parseDouble(textField_4.getText())+Double.parseDouble(textField_5.getText()))/6.0;
				int j=comboBox.getSelectedIndex();
				String str=cs[j].substring(1,4);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where uid = ?");
					p.setString(1,str);
					ResultSet rs=p.executeQuery();
					if(rs.next()) 
					{
						p=(PreparedStatement)c.prepareStatement("update student set marks=? where uid=?");
						p.setDouble(1,avg);
						p.setString(2,str);
						boolean b=p.execute();
						JOptionPane.showMessageDialog(null,"Student Marks Stored!");
					}
					else {
						JOptionPane.showMessageDialog(null,"ERROR : Student Does Not Exist");
					}
				}
				catch(Exception ze)
				{
					ze.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		btnSave.setBounds(249, 287, 237, 68);
		getContentPane().add(btnSave);
		
		JLabel lblEnterStudentName = new JLabel("Select Student :");
		lblEnterStudentName.setBounds(73, 79, 183, 26);
		lblEnterStudentName.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblEnterStudentName);
		
		JLabel lblEnterMarks = new JLabel("Enter Marks:");
		lblEnterMarks.setBounds(377, 15, 313, 36);
		lblEnterMarks.setForeground(Color.WHITE);
		lblEnterMarks.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblEnterMarks.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEnterMarks);
		
		JLabel label_6 = new JLabel(" ");
		label_6.setIcon(new ImageIcon(Marks.class.getResource("/images/TEACHER BACKGROUND.png")));
		label_6.setBounds(0, 2, 700, 450);
		getContentPane().add(label_6);
	}
}
