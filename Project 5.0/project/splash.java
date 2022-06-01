package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;

public class splash extends JFrame {

	private JPanel contentPane;
	static JProgressBar progressBar;
	static JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		int x;
			splash frame = new splash();
			frame.setVisible(true);
			try{
			for(x=0; x<=100; x++) {
					splash.progressBar.setValue(x);
					Thread.sleep(50);
					splash.lblNewLabel.setText(Integer.toString(x)+" %");
					if(x==100) {
						frame.dispose();
					}
					
			}	
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
}

	/**
	 * Create the frame.
	 */
	public splash() {
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
}
