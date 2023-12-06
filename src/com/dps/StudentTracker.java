package com.dps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;

public class StudentTracker extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTable table_1;
	private JTextField sf;
	JComboBox comboBox ;
	JRadioButton r1,r2,r3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTracker frame = new StudentTracker();
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
	public StudentTracker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1550, 1700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData();
			}
		});
		btnNewButton.setBounds(311, 679, 97, 27);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(510, 202, 875, 558);
		contentPane.add(table);
		
		JButton btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("About to insert");
				String rn=tf1.getText();
				String fn=tf2.getText();
				int marks=Integer.parseInt(tf3.getText());
				String en=tf4.getText();
				String dept=tf5.getText();
				String gender=getGender();
				showData();
				
				
				String q="insert into Student values(?, ?, ?, ?, ?, ?);";
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, rn);
					ps.setString(2, fn);
					ps.setInt(3, marks);
					ps.setString(4, en);
					ps.setString(5, dept);
					ps.setString(6, gender);
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Inserted!");
					showData();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
		});
		btnNewButton_1.setBounds(204, 633, 97, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rn=tf1.getText();
				String fn=tf2.getText();
				int mr=Integer.parseInt(tf3.getText());
				String ea=tf4.getText();
				String dept=tf5.getText();
				String gn=getGender();
				
				String q="Update Student set Full_Name=?,Marks=?,Email=?,Department=?,Gender=? where Roll_No=?";
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, fn);
					ps.setInt(2, mr);
					ps.setString(3, ea);
					ps.setString(4, dept);
					ps.setString(5, gn);
					ps.setString(6, rn);
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Record Updated");
					showData();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(122, 584, 97, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q ="Delete from Student where Roll_No =?;";
				try {
					PreparedStatement ps = DbConn.getConn().prepareStatement(q);
					ps.setString(1, tf1.getText());
					ps.execute();
					JOptionPane.showConfirmDialog(null, "Deleted Successfully!");
					showData();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(56, 539, 97, 27);
		contentPane.add(btnNewButton_3);
		
		tf1 = new JTextField();
		tf1.setBackground(Color.ORANGE);
		tf1.setBounds(244, 126, 149, 27);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBackground(Color.ORANGE);
		tf2.setBounds(244, 179, 149, 27);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBackground(Color.ORANGE);
		tf3.setBounds(244, 234, 149, 27);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBackground(Color.ORANGE);
		tf4.setBounds(244, 283, 151, 27);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		tf5 = new JTextField();
		tf5.setBackground(Color.ORANGE);
		tf5.setBounds(244, 335, 151, 27);
		contentPane.add(tf5);
		tf5.setColumns(10);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(204, 394, 84, 21);
		contentPane.add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(290, 394, 87, 21);
		contentPane.add(r2);
		
		r3 = new JRadioButton("Other");
		r3.setBounds(397, 394, 103, 21);
		contentPane.add(r3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);bg.add(r2);bg.add(r3);
		
		JLabel lblNewLabel = new JLabel("Roll_No");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(122, 120, 53, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full_Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(122, 178, 78, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marks");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(130, 235, 70, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(130, 290, 45, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(130, 341, 89, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(130, 396, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 179, 875, 19);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setBackground(Color.ORANGE);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Roll_No", "Full_Name", "Marks", "Email", "Department", "Gender"
			}
		));
		
	
		
		sf = new JTextField();
		sf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q="Select * from Student where Full_Name=?";
				try {
					PreparedStatement pe =DbConn.getConn().prepareStatement(q);
					pe.setString(1,sf.getText());
					ResultSet rs=pe.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		sf.setBounds(536, 123, 561, 30);
		contentPane.add(sf);
		sf.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Search");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(472, 131, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		comboBox  = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Roll_No=(String) comboBox.getSelectedItem();
				String q="Select * from Student where Roll_No=?";
				try {
					PreparedStatement ps=DbConn.getConn().prepareStatement(q);
					ps.setString(1, Roll_No);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						tf1.setText(rs.getString(1));
						tf2.setText(rs.getString(2));
						tf3.setText(rs.getString(3));
						tf4.setText(rs.getString(4));
						tf5.setText(rs.getString(5));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		comboBox.setBounds(70, 65, 369, 29);
		contentPane.add(comboBox);
		
		JButton btnNewButton_4 = new JButton("SwitchedOff");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String time=JOptionPane.showInputDialog("Enter the sec");
				System.out.println(time);
				try {
					Runtime.getRuntime().exec("shutdown -s -t "+time);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBackground(new Color(255, 0, 0));
		btnNewButton_4.setBounds(1306, 104, 140, 29);
		contentPane.add(btnNewButton_4);
		fillCombobox();
	}//Constructor end here
	void fillCombobox() {
		String q="Select * from Student";
		try {
			Statement stmt=DbConn.getConn().createStatement();
			ResultSet rs=stmt.executeQuery(q);
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	String getGender() {
		if(r1.isSelected()) return "Male";
		else if(r2.isSelected()) return "Female";
		else return "Others";
	}

	public void showData() {
		String q="Select * from Student";
		Connection conn =DbConn.getConn();
		try {
			Statement stmt =conn.createStatement();
			ResultSet rs=stmt.executeQuery(q);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}//class end here
