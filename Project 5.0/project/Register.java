package project;

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

public class Register extends JFrame {

	private JPanel contentPane;
	static String u;
	/**
	 * Launch the application.
	 */
	public static void main(String usr) {
		u=usr;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					Register frame = new Register();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public Register()throws SQLException, ClassNotFoundException{ 


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
		lblX.setBounds(656, 11, 44, 40);
		contentPane.add(lblX);

		JLabel lblstudententsPortal = new JLabel("Pick A Course");
		lblstudententsPortal.setForeground(Color.WHITE);
		lblstudententsPortal.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblstudententsPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblstudententsPortal.setBounds(340, 11, 350, 40);
		contentPane.add(lblstudententsPortal);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Register.class.getResource("/images/STUDENT BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{

					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
					p.setString(1,"Comps");
					ResultSet rs=p.executeQuery();
					PreparedStatement p2=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p2.setString(1,u);
					ResultSet r=p2.executeQuery();
					if(r.next())
					{
						if(r.getString(5).compareTo("None")==0)
						{
							if(rs.next())
							{
								int a=rs.getInt(2);
								if(a>0)
								{
									JOptionPane.showMessageDialog(null,"Course Selected!\nNumber Of Seats Left = "+(a-1));
									PreparedStatement p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
									p1.setInt(1,a-1);
									p1.setString(2, "Comps");
									boolean b=p1.execute();
									p1=(PreparedStatement)c.prepareStatement("update student set field=? where uid=?");
									p1.setString(1, "Comps");
									p1.setString(2, u);
									b=p1.execute();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Sorry All Seats Full Choose Another Course");
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"ERROR : Course Already Selected");
						}
					}
				}
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		label_1.setBackground(Color.BLACK);
		label_1.setIcon(new ImageIcon(Register.class.getResource("/images/robot.png")));
		label_1.setBounds(79, 62, 129, 135);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{

					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
					p.setString(1,"EXTC");
					ResultSet rs=p.executeQuery();
					PreparedStatement p2=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p2.setString(1,u);
					ResultSet r=p2.executeQuery();
					if(r.next())
					{
						if(r.getString(5).compareTo("None")==0)
						{
							if(rs.next())
							{
								int a=rs.getInt(2);
								if(a>0)
								{
									JOptionPane.showMessageDialog(null,"Course Selected!\nNumber Of Seats Left = "+(a-1));
									PreparedStatement p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
									p1.setInt(1,a-1);
									p1.setString(2, "EXTC");
									boolean b=p1.execute();
									p1=(PreparedStatement)c.prepareStatement("update student set field=? where uid=?");
									p1.setString(1, "EXTC");
									p1.setString(2, u);
									b=p1.execute();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Sorry All Seats Full Choose Another Course");
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"ERROR : Course Already Selected");
						}
					}
				}
				catch (Exception eE) 
				{
					eE.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		label_2.setBackground(Color.BLACK);
		label_2.setIcon(new ImageIcon(Register.class.getResource("/images/circuit (1).png")));
		label_2.setBounds(289, 62, 129, 135);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{

					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
					p.setString(1,"IT");
					ResultSet rs=p.executeQuery();
					PreparedStatement p2=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p2.setString(1,u);
					ResultSet r=p2.executeQuery();
					if(r.next())
					{
						if(r.getString(5).compareTo("None")==0)
						{
							if(rs.next())
							{
								int a=rs.getInt(2);
								if(a>0)
								{
									JOptionPane.showMessageDialog(null,"Course Selected!\nNumber Of Seats Left = "+(a-1));
									PreparedStatement p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
									p1.setInt(1,a-1);
									p1.setString(2, "IT");
									boolean b=p1.execute();
									p1=(PreparedStatement)c.prepareStatement("update student set field=? where uid=?");
									p1.setString(1, "IT");
									p1.setString(2, u);
									b=p1.execute();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Sorry All Seats Full Choose Another Course");
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"ERROR : Course Already Selected");
						}
					}
				}
				catch (Exception eX) 
				{
					eX.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		label_3.setBackground(Color.BLACK);
		label_3.setIcon(new ImageIcon(Register.class.getResource("/images/cms (1).png")));
		label_3.setBounds(479, 62, 129, 135);
		contentPane.add(label_3);
		
		JLabel lblComputer = new JLabel("      COMPUTER");
		lblComputer.setBackground(Color.BLACK);
		lblComputer.setForeground(Color.BLACK);
		lblComputer.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblComputer.setBounds(79, 193, 129, 20);
		contentPane.add(lblComputer);
		
		JLabel lblEngineering = new JLabel("  ENGINEERING");
		lblEngineering.setBackground(Color.BLACK);
		lblEngineering.setForeground(Color.WHITE);
		lblEngineering.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEngineering.setBounds(79, 213, 129, 14);
		lblEngineering.setOpaque(true);
		contentPane.add(lblEngineering);
		
		JLabel lblExtc = new JLabel("          EXTC");
		lblExtc.setBackground(Color.BLACK);
		lblExtc.setForeground(Color.BLACK);
		lblExtc.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblExtc.setBounds(289, 193, 129, 20);
		contentPane.add(lblExtc);
		
		JLabel lblNewLabel = new JLabel("  ENGINEERING");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(289, 213, 129, 14);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		JLabel lblIt = new JLabel("               IT");
		lblIt.setForeground(Color.BLACK);
		lblIt.setBackground(Color.BLACK);
		lblIt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblIt.setBounds(479, 193, 129, 20);
		contentPane.add(lblIt);
		
		JLabel lblEngineering_1 = new JLabel("  ENGINEERING");
		lblEngineering_1.setForeground(Color.WHITE);
		lblEngineering_1.setBackground(Color.BLACK);
		lblEngineering_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEngineering_1.setBounds(479, 213, 129, 14);
		lblEngineering_1.setOpaque(true);
		contentPane.add(lblEngineering_1);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{

					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
					p.setString(1,"Mech");
					ResultSet rs=p.executeQuery();
					PreparedStatement p2=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p2.setString(1,u);
					ResultSet r=p2.executeQuery();
					if(r.next())
					{
						if(r.getString(5).compareTo("None")==0)
						{
							if(rs.next())
							{
								int a=rs.getInt(2);
								if(a>0)
								{
									JOptionPane.showMessageDialog(null,"Course Selected!\nNumber Of Seats Left = "+(a-1));
									PreparedStatement p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
									p1.setInt(1,a-1);
									p1.setString(2, "Mech");
									boolean b=p1.execute();
									p1=(PreparedStatement)c.prepareStatement("update student set field=? where uid=?");
									p1.setString(1, "Mech");
									p1.setString(2, u);
									b=p1.execute();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Sorry All Seats Full Choose Another Course");
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"ERROR : Course Already Selected");
						}
					}
				}
				catch (Exception ex) 
				{
					ex.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		label_4.setBackground(Color.BLACK);
		label_4.setIcon(new ImageIcon(Register.class.getResource("/images/car-engine (1).png")));
		label_4.setBounds(172, 238, 129, 122);
		contentPane.add(label_4);
		
		JLabel lblMechanical = new JLabel("MECHANICAL");
		lblMechanical.setHorizontalAlignment(SwingConstants.CENTER);
		lblMechanical.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblMechanical.setBounds(172, 360, 129, 14);
		contentPane.add(lblMechanical);
		
		JLabel lblEngineering_2 = new JLabel("ENGINEERING");
		lblEngineering_2.setForeground(Color.WHITE);
		lblEngineering_2.setBackground(Color.BLACK);
		lblEngineering_2.setOpaque(true);
		lblEngineering_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEngineering_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEngineering_2.setBounds(172, 376, 129, 14);
		contentPane.add(lblEngineering_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{

					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from courses where course=?");
					p.setString(1,"Civil");
					ResultSet rs=p.executeQuery();
					PreparedStatement p2=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p2.setString(1,u);
					ResultSet r=p2.executeQuery();
					if(r.next())
					{
						if(r.getString(5).compareTo("None")==0)
						{
							if(rs.next())
							{
								int a=rs.getInt(2);
								if(a>0)
								{
									JOptionPane.showMessageDialog(null,"Course Selected!\nNumber Of Seats Left = "+(a-1));
									PreparedStatement p1=(PreparedStatement)c.prepareStatement("update courses set seats=? where course=?");
									p1.setInt(1,a-1);
									p1.setString(2, "Civil");
									boolean b=p1.execute();
									p1=(PreparedStatement)c.prepareStatement("update student set field=? where uid=?");
									p1.setString(1, "Civil");
									p1.setString(2, u);
									b=p1.execute();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Sorry All Seats Full Choose Another Course");
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"ERROR : Course Already Selected");
						}
					}
				}
				catch (Exception ee) 
				{
					ee.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon(Register.class.getResource("/images/worker (1).png")));
		lblNewLabel_1.setBounds(386, 232, 129, 128);
		contentPane.add(lblNewLabel_1);

		JLabel lblCivil = new JLabel("CIVIL");
		lblCivil.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCivil.setBounds(428, 362, 67, 14);
		contentPane.add(lblCivil);
		

		JLabel lblEngineering_3 = new JLabel("ENGINEERING");
		lblEngineering_3.setBackground(Color.BLACK);
		lblEngineering_3.setForeground(Color.WHITE);
		lblEngineering_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEngineering_3.setBounds(396, 378, 119, 14);
		lblEngineering_3.setOpaque(true);
		contentPane.add(lblEngineering_3);
		
		contentPane.add(label);
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
