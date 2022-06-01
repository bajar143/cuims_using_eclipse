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
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Fees extends JFrame {

	private JPanel contentPane;
	public static String usr;
	public static String fee;
	public static String a;
	/**
	 * Launch the application.
	 */
	public static void main(String a,String b,String c) {
		usr=a;
		fee=b;
		Fees.a=c;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fees frame = new Fees();
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
	public Fees() throws ClassNotFoundException, SQLException {
		getContentPane().setBackground(new Color(192, 192, 192));
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
		
	
		
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		getContentPane().setLayout(null);

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
		lblX.setBounds(635, 5, 65, 48);
		getContentPane().add(lblX);
		
		JLabel lblStudentName = new JLabel("UID :");
		lblStudentName.setBounds(68, 124, 214, 25);
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		getContentPane().add(lblStudentName);
		
		JLabel lblNewLabel = new JLabel(usr);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(292, 124, 235, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblField = new JLabel("Field : ");
		lblField.setBounds(68, 187, 83, 25);
		lblField.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblField);
		
		JLabel lblFld = new JLabel(a);
		lblFld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFld.setBounds(292, 187, 235, 25);
		getContentPane().add(lblFld);
		
		JLabel lblFees = new JLabel("Fees : ");
		lblFees.setBounds(68, 242, 83, 25);
		lblFees.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblFees);
		
		JLabel lblFes = new JLabel(fee);
		lblFes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFes.setBounds(354, 242, 173, 25);
		getContentPane().add(lblFes);
		
		JLabel lblFees_1 = new JLabel("Fees Portal:");
		lblFees_1.setForeground(Color.WHITE);
		lblFees_1.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblFees_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFees_1.setBounds(388, 11, 237, 46);
		getContentPane().add(lblFees_1);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Fees.class.getResource("/images/STUDENT BACKGROUND.png")));
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
						String z=rs.getString(6);
						if(z.compareTo("U")==0)
						{
							PayNow.main(usr , fee);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Fees Already Paid, Now Go Study");
							dispose();
						}
					}
				}
				catch(Exception ez)
				{
					ez.printStackTrace();
				}
			}
		});
		label_1.setIcon(new ImageIcon(Fees.class.getResource("/images/payment.png")));
		label_1.setBounds(294, 278, 83, 80);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("PAY NOW");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(285, 358, 104, 14);
		getContentPane().add(lblNewLabel_1);
		
		
		getContentPane().add(label);
		
		
		
	}
}
