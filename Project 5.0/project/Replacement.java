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
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Replacement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static private String day;
	static private String fld;
	static private int period;
	private JLabel lblIfEmptyIt;
	/**
	 * Launch the application.
	 */
	public static void main(String d,int p,String f) {
		day=d;
		period=p;
		fld=f;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Replacement frame = new Replacement();
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
	public Replacement() throws ClassNotFoundException, SQLException {
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
		lblX.setBounds(660, 0, 40, 40);
		getContentPane().add(lblX);
		
		String head[]= {"UID","Name"};
		String list[][]=new String[20][2];
		int i=0,j=0;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
		
		PreparedStatement p1=(PreparedStatement)c.prepareStatement("select * from teacher where field=?");
		p1.setString(1, fld);
		ResultSet rs=p1.executeQuery();
		while(rs.next())
		{
			boolean b=false;
			String uid=rs.getString(1);
			String a=Integer.toString(period);
			p1=(PreparedStatement)c.prepareStatement("select l"+a+" from tt"+uid+" where day = ?");
			p1.setString(1, day);
			ResultSet r=p1.executeQuery();
			if(r.next())
			{
				if(r.getString(1).equals("Free"))
				{
					b=true;
				}
			}
			if(b)
			{
				list[i][j]=rs.getString(1);
				j++;
				list[i][j]=rs.getString(2);
				j=0;
				i++;
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 73, 350, 272);
		contentPane.add(scrollPane);
		
		table = new JTable(list,head);
		scrollPane.setViewportView(table);
		
		lblIfEmptyIt = new JLabel("If Empty, It means No Teachers Are Free In This Time Slot");
		lblIfEmptyIt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIfEmptyIt.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfEmptyIt.setBounds(81, 361, 424, 14);
		contentPane.add(lblIfEmptyIt);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setForeground(Color.WHITE);
		lblAvailability.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailability.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		lblAvailability.setBounds(376, 11, 274, 40);
		contentPane.add(lblAvailability);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Replacement.class.getResource("/images/ADMIN BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		contentPane.add(label);
	}
}
