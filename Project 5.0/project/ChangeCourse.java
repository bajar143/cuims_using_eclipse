package project;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class ChangeCourse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeCourse frame = new ChangeCourse();
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
	public ChangeCourse() {
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
		lblX.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(633, 0, 67, 55);
		getContentPane().add(lblX);
		
ArrayList x=new ArrayList();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student");
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
		comboBox.setBounds(398, 103, 150, 20);
		getContentPane().add(comboBox);
		
		JLabel lblEnterStudentName = new JLabel("Select Student :");
		lblEnterStudentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentName.setBounds(86, 92, 196, 40);
		getContentPane().add(lblEnterStudentName);
		
String fields[]= {"Comps","IT","EXTC","Mech","Civil"};
		
		JList list = new JList(fields);
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.setBounds(420, 176, 128, 117);
		list.setBorder(BorderFactory.createLineBorder(Color.black,1));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);
		
		JLabel lblSelectOetherCourse = new JLabel("Select Other Course :");
		lblSelectOetherCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectOetherCourse.setBounds(86, 175, 232, 70);
		getContentPane().add(lblSelectOetherCourse);
		
		JLabel lblChangeCourse = new JLabel("Change Course:");
		lblChangeCourse.setBounds(391, 16, 249, 39);
		lblChangeCourse.setForeground(Color.WHITE);
		lblChangeCourse.setFont(new Font("Sitka Small", Font.BOLD, 21));
			lblChangeCourse.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblChangeCourse);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(ChangeCourse.class.getResource("/images/TEACHER BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int n=list.getSelectedIndex();
				String f=fields[n];
				int j=comboBox.getSelectedIndex();
				String str=cs[j].substring(1,4);
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p.setString(1, str);
					ResultSet rs=p.executeQuery();
					PreparedStatement p1;
					if(rs.next())
					{
						String s=rs.getString(5);
						if(s.compareTo("Comps")==0)
						{
							p1=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
							p1.setString(1,s);
							rs=p1.executeQuery();
							if(rs.next())
							{
								int z=rs.getInt(2);
								z++;
								p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
								p1.setInt(1,z);
								p1.setString(2,s);
								boolean b=p1.execute();
							}
						}
						if(s.compareTo("IT")==0)
						{
							p1=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
							p1.setString(1,s);
							rs=p1.executeQuery();
							if(rs.next())
							{
								int z=rs.getInt(2);
								z++;
								p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
								p1.setInt(1,z);
								p1.setString(2,s);
								boolean b=p1.execute();
							}
						}
						if(s.compareTo("Civil")==0)
						{
							p1=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
							p1.setString(1,s);
							rs=p1.executeQuery();
							if(rs.next())
							{
								int z=rs.getInt(2);
								z++;
								p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
								p1.setInt(1,z);
								p1.setString(2,s);
								boolean b=p1.execute();
							}
						}
						if(s.compareTo("EXTC")==0)
						{
							p1=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
							p1.setString(1,s);
							rs=p1.executeQuery();
							if(rs.next())
							{
								int z=rs.getInt(2);
								z++;
								p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
								p1.setInt(1,z);
								p1.setString(2,s);
								boolean b=p1.execute();
							}
						}
						if(s.compareTo("Mech")==0)
						{
							p1=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
							p1.setString(1,s);
							rs=p1.executeQuery();
							if(rs.next())
							{
								int z=rs.getInt(2);
								z++;
								p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
								p1.setInt(1,z);
								p1.setString(2,s);
								boolean b=p1.execute();
							}
						}
						p1=(PreparedStatement)c.prepareStatement("update student set field=? where uid=?");
						p1.setString(1,f);
						p1.setString(2,str);
						boolean b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
						p1.setString(1,f);
						rs=p1.executeQuery();
						if(rs.next())
						{
							int z=rs.getInt(2);
							z--;
							p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
							p1.setInt(1,z);
							p1.setString(2,f);
							b=p1.execute();
						}
						JOptionPane.showMessageDialog(null,"Student  Course Details Updated");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ERROR: Username/Id Does Not Exists");
					}
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
				}
				finally
				{
					dispose();
				}
		
			}
		});
		label_1.setIcon(new ImageIcon(ChangeCourse.class.getResource("/images/icon (1).png")));
		label_1.setBounds(305, 291, 73, 76);
		getContentPane().add(label_1);
		
		JLabel lblConfirmChanges = new JLabel("CONFIRM CHANGES");
		lblConfirmChanges.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblConfirmChanges.setBounds(254, 368, 162, 14);
		getContentPane().add(lblConfirmChanges);
		
		getContentPane().add(label);
		
		
		
		
	}
}
