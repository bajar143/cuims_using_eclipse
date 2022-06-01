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
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class About_Us extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_Us frame = new About_Us();
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
	public About_Us() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 629, 412);
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
		lblX.setBounds(589, 0, 40, 40);
		contentPane.add(lblX);
		
		String str="The Developer is a club of students from the Chandigarh University has design to improve computer science student development skill under UIC.";
		JLabel lblInfo = new JLabel("<html>The UIC Developer is a club of students from the CU who design for mainly MCA student.</html>");
		lblInfo.setBackground(new Color(112, 128, 144));
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfo.setBounds(38, 285, 249, 59);
		contentPane.add(lblInfo);
		
		JLabel lblMac = new JLabel("UIC");
		lblMac.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMac.setHorizontalAlignment(SwingConstants.CENTER);
		lblMac.setBounds(43, 264, 237, 27);
		contentPane.add(lblMac);
		
		JLabel lblRedhatAcafdemyCenter = new JLabel("Redhat Academy Center");
		lblRedhatAcafdemyCenter.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblRedhatAcafdemyCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedhatAcafdemyCenter.setBounds(310, 240, 274, 27);
		contentPane.add(lblRedhatAcafdemyCenter);
		
		String rac="We provide Free of cost coaching for Red hat Certified System Administrator(RHCSA) & Redhat certified Engineer (RHCE) Cerifications.";
		JLabel lblRac = new JLabel("<html>"+rac+"</html>");
		lblRac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRac.setBounds(316, 260, 269, 65);
		contentPane.add(lblRac);
		
		JLabel lblMac_1 = new JLabel("mac");
		lblMac_1.setIcon(new ImageIcon(About_Us.class.getResource("/images/mac.png")));
		lblMac_1.setBounds(38, 186, 250, 79);
		contentPane.add(lblMac_1);
		
		JLabel lblRac_1 = new JLabel("rac");
		lblRac_1.setIcon(new ImageIcon(About_Us.class.getResource("/images/rac.png")));
		lblRac_1.setBounds(407, 185, 83, 60);
		contentPane.add(lblRac_1);
		
		String intro="Chandigarh University, Punjab enjoys high standing among many national "
				+ "rating services that evaluate quality of education, research activity, "
				+ "affordability and athletic excellence. These rankings recognize not only CU"
				+ " as a whole, but also our many respected schools and departments."
				+ " Chandigarh University, Punjab is proud to be recognized by the organizations "
				+ "and publications listed below for our excellence in education..";
		JLabel lblIntro = new JLabel("<html>"+intro+"</html>");
		lblIntro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntro.setBounds(28, 70, 578, 114);
		contentPane.add(lblIntro);
		
		JLabel lblAboutUs = new JLabel("About Us :");
		lblAboutUs.setForeground(Color.WHITE);
		lblAboutUs.setFont(new Font("", Font.BOLD, 24));
		lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutUs.setBounds(299, 0, 295, 59);
		contentPane.add(lblAboutUs);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setText(" ");
		editorPane.setBounds(32, 180, 260, 164);
		editorPane.setBorder(BorderFactory.createLineBorder(Color.black,3));
		contentPane.add(editorPane);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(299, 182, 295, 162);
		editorPane_1.setBorder(BorderFactory.createLineBorder(Color.black,3));
		contentPane.add(editorPane_1);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(About_Us.class.getResource("/images/BAJAR_BACKGROUND_1_629x408.png")));
		label.setBounds(0, 0, 629, 412);
		contentPane.add(label);
	}
}
