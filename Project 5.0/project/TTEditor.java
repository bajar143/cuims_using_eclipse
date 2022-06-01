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
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class TTEditor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String user;
	/**
	 * Launch the application.
	 */
	public static void main(String u) {
		user=u;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTEditor frame = new TTEditor();
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
	public TTEditor() {
		getContentPane().setBackground(new Color(192, 192, 192));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(369, 180, 700, 450);
		getContentPane().setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setForeground(new Color(255, 255, 255));
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(652, 4, 48, 53);
		getContentPane().add(lblX);

		JLabel lblSelectDay = new JLabel("Select Day:");
		lblSelectDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSelectDay.setBounds(53, 117, 103, 14);
		getContentPane().add(lblSelectDay);

		String days[]= {"Monday","Tuesday","Wednesday","Thursday","Friday"};

		JList list = new JList(days);
		list.setBackground(SystemColor.control);
		list.setSelectedIndex(0);
		list.setBorder(BorderFactory.createLineBorder(Color.black,2));
		list.setBounds(172, 116, 87, 96);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(list);

		JLabel lblSelectPeriod = new JLabel("Select Period:");
		lblSelectPeriod.setFont(new Font("Sitka small", Font.BOLD, 13));
		lblSelectPeriod.setBounds(359, 118, 134, 14);
		getContentPane().add(lblSelectPeriod);

		JSpinner spinner = new JSpinner();
		spinner.setForeground(Color.LIGHT_GRAY);
		spinner.setBackground(Color.LIGHT_GRAY);
		spinner.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		spinner.setBounds(503, 115, 65, 20);
		getContentPane().add(spinner);

		JLabel lblPleaseUseButtons = new JLabel("Please Use Buttons To Enter Period");
		lblPleaseUseButtons.setForeground(Color.RED);
		lblPleaseUseButtons.setBounds(350, 169, 218, 14);
		getContentPane().add(lblPleaseUseButtons);

		JLabel lblEnterPeriodLabel = new JLabel("Enter Period Label:");
		lblEnterPeriodLabel.setBounds(81, 242, 134, 14);
		lblEnterPeriodLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEnterPeriodLabel);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(277, 241, 291, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setIcon(new ImageIcon(TTEditor.class.getResource("/images/calendar.png")));
		btnSaveChanges.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSaveChanges.setBorder(BorderFactory.createLineBorder(Color.black,2));
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=list.getSelectedIndex();
				int c=(Integer)spinner.getValue();
				String tt="";
				boolean b;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c11=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "bajar143");
					PreparedStatement p;
					PreparedStatement p1=(PreparedStatement)c11.prepareStatement("select * from teacher where uid=?");
					p1.setString(1, user);
					ResultSet r=p1.executeQuery();
					if(r.next())
					{
						String field=r.getString(3);
						if(field.compareTo("Comps")==0)
						{
							tt="ttco";
						}
						if(field.compareTo("IT")==0)
						{
							tt="tti";
						}
						if(field.compareTo("Civil")==0)
						{
							tt="ttci";
						}
						if(field.compareTo("EXTC")==0)
						{
							tt="tte";
						}
						if(field.compareTo("Mech")==0)
						{
							tt="ttm";
						}
					}
					switch(c)
					{
					case 1:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l1=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					case 2:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l2=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					case 3:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l3=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					case 4:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l4=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					case 5:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l5=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					case 6:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l6=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					case 7:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l7=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					case 8:
						p=(PreparedStatement)c11.prepareStatement("update "+tt+" set l8=? where day=?");
						p.setString(1,textField.getText());
						p.setString(2,days[n]);
						b=p.execute();
						break;
					default:
						JOptionPane.showMessageDialog(null,"ERROR : I told you to use the buttons");
					}
					JOptionPane.showMessageDialog(null,"Successful");
				}
				catch(Exception ze)
				{
					ze.printStackTrace();
				}
				finally
				{
					dispose();
				}
			}
		});
		btnSaveChanges.setBounds(294, 291, 249, 62);
		getContentPane().add(btnSaveChanges);
		
		JLabel lblEdit = new JLabel("Edit:");
		lblEdit.setForeground(new Color(245, 255, 250));
		lblEdit.setBounds(359, 11, 276, 36);
		lblEdit.setFont(new Font("Sitka Small", Font.BOLD, 22));
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEdit);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(TTEditor.class.getResource("/images/TEACHER BACKGROUND.png")));
		label.setBounds(0, 0, 700, 450);
		getContentPane().add(label);
	}
}