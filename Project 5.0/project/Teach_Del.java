package project;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class Teach_Del extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teach_Del frame = new Teach_Del();
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
	public Teach_Del() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(646, 5, 54, 52);
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

		JLabel lblEnterStudentNameid = new JLabel("Enter Staff Uid :");
		lblEnterStudentNameid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterStudentNameid.setBounds(146, 93, 164, 39);
		contentPane.add(lblEnterStudentNameid);

		JLabel lblWarningThis = new JLabel("Warning! : This is permanent and non-reversible");
		lblWarningThis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWarningThis.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningThis.setForeground(Color.RED);
		lblWarningThis.setBounds(146, 153, 380, 28);
		contentPane.add(lblWarningThis);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(320, 104, 193, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDeleteTeachersAccount = new JLabel("Delete Teacher's Account");
		lblDeleteTeachersAccount.setBounds(374, 12, 282, 39);
		lblDeleteTeachersAccount.setForeground(Color.WHITE);
		lblDeleteTeachersAccount.setFont(new Font("Sitka Small", Font.BOLD, 19));
		lblDeleteTeachersAccount.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDeleteTeachersAccount);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Teach_Del.class.getResource("/images/ADMIN BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
					PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from teacher where uid=?");
					p.setString(1, textField.getText());
					ResultSet rs=p.executeQuery();
					if(rs.next())
					{
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("delete from teacher where uid=?");
						p1.setString(1,textField.getText());
						boolean b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("delete from login where uid=?");
						p1.setString(1,textField.getText());
						b=p1.execute();
						p1=(PreparedStatement)c.prepareStatement("drop table tt"+textField.getText());
						b=p1.execute();
						JOptionPane.showMessageDialog(null,"Teacher Account Deleted");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ERROR: UID Does Not Exists For Teacher Accounts");
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
		label_1.setIcon(new ImageIcon(Teach_Del.class.getResource("/images/unfriend.png")));
		label_1.setBounds(260, 225, 128, 115);
		contentPane.add(label_1);
		
		JLabel lblDeleteTeacherAccount = new JLabel("DELETE TEACHER ACCOUNT");
		lblDeleteTeacherAccount.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDeleteTeacherAccount.setBounds(217, 351, 230, 14);
		contentPane.add(lblDeleteTeacherAccount);
		
		contentPane.add(label);
		
		
		
		
	}

}
