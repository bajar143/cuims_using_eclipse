package project;

//

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AA_Start extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {

		int x;
		splash frame = new splash();
		frame.setVisible(true);
		try{
		for(x=0; x<=100; x++) {
				splash.progressBar.setValue(x);
				Thread.sleep(50);
				splash.lblNewLabel.setText("Loading:- "+Integer.toString(x)+" %");
				if(x==100) {
					frame.dispose();
				}
				
		}	
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AA_Start frame = new AA_Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 * @return 
	 */

	public void splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 590, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/main.gif"));
		label.setIcon(icon);
		label.setBounds(35, 0, 550, 410);
		contentPane.add(label);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(32, 178, 170));
		progressBar.setBounds(0, 462, 590, 28);
		contentPane.add(progressBar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBounds(230, 420, 208, 32);
		contentPane.add(lblNewLabel);
		
		
		
	}
	
	public AA_Start() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180,629,408);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(600, 0, 29, 29);
		lblX.setForeground(Color.WHITE);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		getContentPane().setLayout(null);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblX);

		JLabel lblLogin = new JLabel("UID:");
		lblLogin.setBounds(452, 236, 68, 20);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblLogin);

		textField = new JTextField();
		textField.setBounds(513, 236, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("PIN:");
		lblPassword.setBounds(452, 267, 68, 20);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(513, 267, 86, 20);
		getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(452, 298, 143, 25);
		btnLogin.setBackground(new Color(192, 192, 192));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setIcon(new ImageIcon(AA_Start.class.getResource("/images/Login.png")));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String usr=textField.getText();
				String pswd=passwordField.getText();
				if(usr.compareTo("999")==0 && pswd.compareTo("1234")==0)
				{
					Admin.main();
				}
				else
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
						PreparedStatement p=(PreparedStatement)c.prepareStatement("select * from login where uid = ? and pass = ?");
						p.setString(1,usr);
						p.setString(2,pswd);
						ResultSet rs=p.executeQuery();
						if(rs.next()) 
						{
							String s=rs.getString(3);
							if(s.compareTo("S")==0)
							{
								Student.main(usr);
							}
							else
							{
								Teacher.main(usr);
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"ERROR : Incorrect Username Or Password");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		getContentPane().add(btnLogin);

		JPanel panel = new JPanel();
		panel.setBounds(433, 225, 179, 108);
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createLineBorder(Color.black,2));
		getContentPane().add(panel);

		JButton btnContactUs = new JButton("Contact Us!");
		btnContactUs.setBounds(456, 112, 129, 29);
		btnContactUs.setBackground(new Color(192, 192, 192));
		btnContactUs.setIcon(new ImageIcon(AA_Start.class.getResource("/images/telephone.png")));
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contact_Us.main();
			}
		});
		getContentPane().add(btnContactUs);

		JLabel lblintro = new JLabel("");
		lblintro.setBounds(43, 59, 380, 274);
		lblintro.setIcon(new ImageIcon(AA_Start.class.getResource("/images/colg.jpeg")));
		lblintro.setHorizontalAlignment(SwingConstants.CENTER);
		lblintro.setBorder(BorderFactory.createLineBorder(Color.black,2));
		getContentPane().add(lblintro);

		JButton btnAboutUs = new JButton("About Us!");
		btnAboutUs.setBounds(456, 164, 129, 29);
		btnAboutUs.setBackground(new Color(192, 192, 192));
		btnAboutUs.setIcon(new ImageIcon(AA_Start.class.getResource("/images/info.png")));
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About_Us.main();
			}
		});
		
		JLabel lblUiVersionp = new JLabel("UI version : 5.0 Final");
		lblUiVersionp.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUiVersionp.setBounds(0, 0, 122, 14);
		getContentPane().add(lblUiVersionp);
		
		JLabel lblWelcomed = new JLabel("WELCOME");
		lblWelcomed.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblWelcomed.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomed.setForeground(Color.WHITE);
		lblWelcomed.setBounds(369, 8, 203, 40);
		getContentPane().add(lblWelcomed);
		getContentPane().add(btnAboutUs);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(433, 59, 179, 155);
		panel_2.setBackground(Color.WHITE);
		getContentPane().add(panel_2);
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black,2));
		panel_2.setLayout(null);

		JLabel lblNewHere = new JLabel("New Here?");
		lblNewHere.setBounds(0, 0, 180, 50);
		panel_2.add(lblNewHere);
		lblNewHere.setForeground(new Color(0, 0, 0));
		lblNewHere.setFont(new Font("Sitka small", Font.PLAIN, 16));
		lblNewHere.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel = new JLabel("Welcome :D");
		lblNewLabel.setBounds(-72, 0, 210, 37);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitika small", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);


		JLabel lblLogo = new JLabel(" ");
		lblLogo.setIcon(new ImageIcon(AA_Start.class.getResource("/images/ADMIN BACKGROUND_LOGO.png")));
		lblLogo.setBounds(0, 0, 629,408);
		getContentPane().add(lblLogo);




		JLabel label_2 = new JLabel(" ");
		label_2.setBounds(0, 0, 46, 14);
		getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("cu logo");
		lblNewLabel_1.setIcon(new ImageIcon(AA_Start.class.getResource("/images/n.gif")));
		lblNewLabel_1.setBounds(204, 0, 122, 59);
		getContentPane().add(lblNewLabel_1);
		
		




	}
}
