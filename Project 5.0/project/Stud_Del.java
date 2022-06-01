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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class Stud_Del extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stud_Del frame = new Stud_Del();
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
	public Stud_Del() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(649, 10, 51, 39);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblX);

		JLabel lblEnterStudentNameid = new JLabel("Enter Student UID :");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentNameid.setBounds(123, 94, 192, 39);
		contentPane.add(lblEnterStudentNameid);

		textField = new JTextField();
		textField.setBounds(325, 96, 171, 39);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblWarningThis = new JLabel("Warning! : This is permanent and non-reversible");
		lblWarningThis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWarningThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningThis.setForeground(Color.RED);
		lblWarningThis.setBounds(155, 154, 328, 32);
		contentPane.add(lblWarningThis);
		
		JLabel lblDeleteStudent = new JLabel("Delete Student:");
		lblDeleteStudent.setForeground(new Color(255, 255, 255));
		lblDeleteStudent.setBounds(350, 12, 328, 32);
		lblDeleteStudent.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblDeleteStudent.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDeleteStudent);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Stud_Del.class.getResource("/images/ADMIN BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		

		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from student where uid=?");
					p.setString(1, textField.getText());
					ResultSet rs=p.executeQuery();
					if(rs.next())
					{
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("delete from student where uid=?");
						p1.setString(1,textField.getText());
						boolean b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("delete from login where uid=?");
						p1.setString(1,textField.getText());
						b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("delete from attendance where uid=?");
						p1.setString(1,textField.getText());
						b=p1.execute();
						JOptionPane.showMessageDialog(null,"Student  Account Deleted");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ERROR: UID Does Not Exists For Student Accounts");
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
		label_1.setIcon(new ImageIcon(Stud_Del.class.getResource("/images/unfriend.png")));
		label_1.setBounds(266, 211, 161, 128);
		contentPane.add(label_1);

		JLabel lblDeleteStudentAccount = new JLabel("DELETE STUDENT ACCOUNT");
		lblDeleteStudentAccount.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDeleteStudentAccount.setBounds(223, 335, 228, 20);
		contentPane.add(lblDeleteStudentAccount);
		
		contentPane.add(label);
		
		
		

	}

}
