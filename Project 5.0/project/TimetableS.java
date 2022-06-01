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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimetableS extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static private String user;
	/**
	 * Launch the application.
	 */
	public static void main(String u) {
		user=u;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimetableS frame = new TimetableS();
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
	public TimetableS() {
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
		lblX.setBounds(656, 17, 44, 40);
		contentPane.add(lblX);

		JLabel lblStudentsPortal = new JLabel("Timetable");
		lblStudentsPortal.setForeground(Color.WHITE);
		lblStudentsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblStudentsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsPortal.setBounds(356, 11, 334, 42);
		contentPane.add(lblStudentsPortal);
		String a[][]=new String[5][9];
		String b[]= {"Day","Lecture 1","Lecture 2","Lecture 3","Lecture 4","Lecture 5","Lecture 6","Lecture 7","Lecture 8"};
		int i=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
			PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
			p.setString(1, user);
			ResultSet r=p.executeQuery();
			String query="";
			if(r.next())
			{
				String field=r.getString(5);
				if(field.compareTo("Comps")==0)
				{
					query="select * from ttco";
				}
				if(field.compareTo("IT")==0)
				{
					query="select * from tti";
				}
				if(field.compareTo("Civil")==0)
				{
					query="select * from ttci";
				}
				if(field.compareTo("EXTC")==0)
				{
					query="select * from tte";
				}
				if(field.compareTo("Mech")==0)
				{
					query="select * from ttm";
				}
				PreparedStatement p1=(PreparedStatement)c.prepareStatement(query);
				ResultSet rs=p1.executeQuery();
				while(rs.next())
				{
					for(int j=0;j<9;j++)
					{
						a[i][j]= rs.getString(j+1);
					}
					i++;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		table = new JTable(a,b);
		table.setRowSelectionAllowed(false);
		table.setBounds(31, 137, 619, 150);
		contentPane.add(table);
		table.setRowHeight(30);

		JLabel lblDay = new JLabel("Day:");
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setBounds(25, 112, 73, 14);
		contentPane.add(lblDay);

		JLabel lblLecture = new JLabel("Lecture 1:");
		lblLecture.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture.setBounds(96, 112, 73, 14);
		contentPane.add(lblLecture);

		JLabel lblLecture_1 = new JLabel("Lecture 2:");
		lblLecture_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_1.setBounds(170, 112, 73, 14);
		contentPane.add(lblLecture_1);

		JLabel lblLecture_2 = new JLabel("Lecture 3:");
		lblLecture_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_2.setBounds(238, 112, 73, 14);
		contentPane.add(lblLecture_2);

		JLabel lblLecture_3 = new JLabel("Lecture 4:");
		lblLecture_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_3.setBounds(305, 112, 73, 14);
		contentPane.add(lblLecture_3);

		JLabel lblLecture_4 = new JLabel("Lecture 5:");
		lblLecture_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_4.setBounds(376, 112, 73, 14);
		contentPane.add(lblLecture_4);

		JLabel lblLecture_5 = new JLabel("Lecture 6:");
		lblLecture_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_5.setBounds(442, 112, 73, 14);
		contentPane.add(lblLecture_5);

		JLabel lblLecture_6 = new JLabel("Lecture 7:");
		lblLecture_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_6.setBounds(512, 112, 73, 14);
		contentPane.add(lblLecture_6);

		JLabel lblLecture_7 = new JLabel("Lecture 8:");
		lblLecture_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecture_7.setBounds(580, 112, 75, 14);
		contentPane.add(lblLecture_7);

		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClose.setBorder(BorderFactory.createLineBorder(Color.black,1));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(41, 298, 120, 40);
		contentPane.add(btnClose);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(TimetableS.class.getResource("/images/STUDENT BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		contentPane.add(label);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
	}
}
