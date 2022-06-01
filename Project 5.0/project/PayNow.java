package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class PayNow extends JFrame {

	private JPanel contentPane;
	public static String usr;
	public static String fee;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String a,String b) {
		usr=a;
		fee=b;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayNow frame = new PayNow();
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
	public PayNow() {
		getContentPane().setBackground(new Color(192, 192, 192));
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
		lblX.setBounds(638, 4, 62, 73);
		getContentPane().add(lblX);

		JLabel lblPayNow = new JLabel("Pay Now");
		lblPayNow.setForeground(Color.WHITE);
		lblPayNow.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblPayNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayNow.setBounds(389, 14, 311, 35);
		getContentPane().add(lblPayNow);

		JLabel lblCreditCardNumber = new JLabel("Credit Card Number :");
		lblCreditCardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCreditCardNumber.setBounds(43, 170, 206, 14);
		getContentPane().add(lblCreditCardNumber);

		textField = new JTextField();
		textField.setBounds(207, 169, 250, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setBounds(256, 120, 39, 20);
		getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(2018, 2018, 2022, 1));
		spinner_1.setBounds(395, 120, 62, 20);
		getContentPane().add(spinner_1);
		
		JLabel lblCvv = new JLabel("CVV : ");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCvv.setBounds(55, 220, 128, 14);
		getContentPane().add(lblCvv);

		passwordField = new JPasswordField();
		passwordField.setBounds(207, 218, 62, 20);
		getContentPane().add(passwordField);

		JLabel lblAmount = new JLabel("Amount : ");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAmount.setBounds(43, 249, 128, 14);
		getContentPane().add(lblAmount);

		JLabel lblFee = new JLabel(fee);
		lblFee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFee.setBounds(192, 249, 227, 14);
		getContentPane().add(lblFee);

		JLabel lblNameOnCard = new JLabel("Name On Card : ");
		lblNameOnCard.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNameOnCard.setBounds(43, 82, 128, 14);
		getContentPane().add(lblNameOnCard);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textField_1.setBounds(207, 79, 250, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblExpiryDate = new JLabel("Expiry Date :");
		lblExpiryDate.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblExpiryDate.setBounds(43, 118, 128, 20);
		getContentPane().add(lblExpiryDate);

		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblMonth.setBounds(195, 123, 58, 14);
		getContentPane().add(lblMonth);

		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblYear.setBounds(339, 123, 46, 14);
		getContentPane().add(lblYear);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PayNow.class.getResource("/images/visa-and-mastercard-logo-26.png")));
		lblNewLabel.setBounds(481, 79, 140, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel(" ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setIcon(new ImageIcon(PayNow.class.getResource("/images/STUDENT BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
					boolean flag=true;
					
					int len=textField.getText().length();
					int plen=passwordField.getText().length();
					if(textField.getText().matches("[a-zA-Z]" ))
					{
						JOptionPane.showMessageDialog(null,"ERROR : Credit Card Has Only Numbers");
						flag=false;
					}
					else if(len != 16)
					{
						JOptionPane.showMessageDialog(null,"ERROR : Invalid Credit Card Number");
						flag=false;
					}
					else if(plen != 3)
					{
						JOptionPane.showMessageDialog(null,"ERROR : Invalid CVV Number");
						flag=false;
					}
					else if((Integer)spinner.getValue()<=10 && (Integer)spinner_1.getValue()==2018)
					{
						JOptionPane.showMessageDialog(null,"ERROR : Card Expired");
						flag=false;
					}
					if(flag)
					{
						PreparedStatement p1=(PreparedStatement)c.prepareStatement("update student set fee=? where uid=?");
						p1.setString(1,"P");
						p1.setString(2, usr);
						boolean b=p1.execute();
						JOptionPane.showMessageDialog(null,"Payment Successful");
					}
				}
				catch(Exception ze)
				{
					ze.printStackTrace();
					JOptionPane.showMessageDialog(null,"Input Error");
				}
				finally
				{
					dispose();
				}
			}
		});
		label_1.setIcon(new ImageIcon(PayNow.class.getResource("/images/debit-card (1).png")));
		label_1.setBounds(283, 269, 105, 96);
		getContentPane().add(label_1);
		
		JLabel lblConfirmPayment = new JLabel("CONFIRM PAYMENT");
		lblConfirmPayment.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblConfirmPayment.setBounds(256, 351, 163, 14);
		getContentPane().add(lblConfirmPayment);
		
		getContentPane().add(label);
		
		
		
		
	}
}
