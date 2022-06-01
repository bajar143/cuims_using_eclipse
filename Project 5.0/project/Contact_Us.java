package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;

public class Contact_Us extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact_Us frame = new Contact_Us();
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
	public Contact_Us() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 629, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		lblX.setBounds(595, 11, 34, 34);
		contentPane.add(lblX);
		
		JLabel lblContactUs = new JLabel("Contact Us!");
		lblContactUs.setForeground(Color.WHITE);
		lblContactUs.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblContactUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactUs.setBounds(333, 11, 252, 34);
		contentPane.add(lblContactUs);
		
		JLabel lblMap = new JLabel("");
		lblMap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMap.setIcon(new ImageIcon(Contact_Us.class.getResource("/images/map.jpeg")));
		lblMap.setBounds(181, 56, 427, 176);
		contentPane.add(lblMap);
		
		JLabel lblMap_1 = new JLabel("MAP:");
		lblMap_1.setIcon(new ImageIcon(Contact_Us.class.getResource("/images/map.png")));
		lblMap_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMap_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMap_1.setBounds(32, 63, 194, 116);
		contentPane.add(lblMap_1);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setBounds(95, 244, 91, 14);
		contentPane.add(lblAddress);
		
		String add= "NH-95 Chandigarh-Ludhiana Highway, Mohali, Punjab (INDIA) 140413";
		JLabel lblAdd = new JLabel("<html>"+add+"</html>");
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdd.setVerticalAlignment(SwingConstants.TOP);
		lblAdd.setBounds(252, 243, 333, 45);
		contentPane.add(lblAdd);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(95, 288, 71, 20);
		contentPane.add(lblEmail);
		
		JLabel lblRushasmgmailcom = new JLabel("bajrangiraj255@gmail.com");
		lblRushasmgmailcom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRushasmgmailcom.setBounds(252, 290, 180, 35);
		contentPane.add(lblRushasmgmailcom);
		
		JLabel lblPhoneNo = new JLabel("Phone No. :");
		lblPhoneNo.setForeground(Color.BLUE);
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNo.setBounds(95, 308, 105, 28);
		contentPane.add(lblPhoneNo);
		
		JLabel label = new JLabel("+917004991052");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(252, 315, 145, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setIcon(new ImageIcon(Contact_Us.class.getResource("/images/BAJAR_BACKGROUND_1_629x408.png")));
		label_1.setBounds(0, 0, 629, 408);
		contentPane.add(label_1);
	}
}
