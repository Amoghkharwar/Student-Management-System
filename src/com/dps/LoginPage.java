package com.dps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LoginPage {

	private JFrame frame;
	private JPasswordField pf;
	private JTextField uf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Amogkharwar\\Pictures\\Saved Pictures\\65ca68c1-9a93-48a0-b005-2a7439e46a38.jpg"));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(280, 130, 941, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(602, 139, 92, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(602, 229, 87, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		pf = new JPasswordField();
		pf.setBounds(602, 264, 234, 28);
		frame.getContentPane().add(pf);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q="Select * from user where username=? and pass=?";
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, uf.getText());
					ps.setString(2, String.valueOf(pf.getPassword()));
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Welcome to sms");
						StudentTracker frame = new StudentTracker();
						frame.setVisible(true);
						
					}else {
						JOptionPane.showMessageDialog(null, "Invalid User");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(644, 323, 145, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Amogkharwar\\Pictures\\Saved Pictures\\Image200.png"));
		lblNewLabel_2.setBounds(0, 0, 557, 548);
		frame.getContentPane().add(lblNewLabel_2);
		
		uf = new JTextField();
		uf.setBounds(602, 169, 224, 28);
		frame.getContentPane().add(uf);
		uf.setColumns(10);
	}
}
