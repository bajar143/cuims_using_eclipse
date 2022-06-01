package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Replacement_Caller_2 extends JFrame {

	private JPanel contentPane;
	static String field;
	/**
	 * Launch the application.
	 */
	public static void main(String fld) {
		field=fld;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Replacement_Caller_2 frame = new Replacement_Caller_2();
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
	public Replacement_Caller_2() {
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

		JLabel lblForWhichDay = new JLabel("For Which Day To You Want To Check For A Replacement ?");
		lblForWhichDay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblForWhichDay.setBounds(78, 63, 427, 28);
		contentPane.add(lblForWhichDay);

		String days[]= {"Monday","Tuesday","Wednesday","Thursday","Friday"};

		JList list = new JList(days);
		list.setBackground(SystemColor.control);
		list.setSelectedIndex(0);
		list.setBorder(BorderFactory.createLineBorder(Color.black,2));
		list.setBounds(354, 102, 87, 96);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);

		JLabel lblSelectPeriod = new JLabel("Select Period:");
		lblSelectPeriod.setFont(new Font("Sitka small", Font.BOLD, 13));
		lblSelectPeriod.setBounds(78, 233, 134, 14);
		getContentPane().add(lblSelectPeriod);

		JSpinner spinner = new JSpinner();
		spinner.setForeground(Color.LIGHT_GRAY);
		spinner.setBackground(Color.LIGHT_GRAY);
		spinner.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		spinner.setBounds(354, 230, 65, 20);
		getContentPane().add(spinner);
		
		//String field[]= {"Comps","Mech","IT","Civil","EXTC"};

		JButton btnCheck = new JButton("Check!");
		btnCheck.setIcon(new ImageIcon(Replacement_Caller_2.class.getResource("/images/list (1).png")));
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=list.getSelectedIndex();
				int c=(Integer)spinner.getValue();
				Replacement.main(days[n], c,field);
			}
		});
		btnCheck.setBounds(376, 283, 210, 60);
		contentPane.add(btnCheck);
		
		JLabel lblReplacement = new JLabel("Replacement:");
		lblReplacement.setFont(new Font("Sitka Small", Font.PLAIN, 22));
		lblReplacement.setHorizontalAlignment(SwingConstants.CENTER);
		lblReplacement.setForeground(Color.WHITE);
		lblReplacement.setBounds(384, 14, 243, 38);
		contentPane.add(lblReplacement);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Replacement_Caller_2.class.getResource("/images/ADMIN BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		contentPane.add(label);
	

		
	}
}
