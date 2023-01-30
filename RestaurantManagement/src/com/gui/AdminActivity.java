package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AdminActivity extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminActivity frame = new AdminActivity();
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
	public AdminActivity() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\RestaurantManagement\\images\\idN8HNI.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Admin Activity");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(138, 22, 171, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Customer Button Clicked");
				CustomerFrame.main(null);
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnCustomer.setBounds(134, 71, 129, 23);
		contentPane.add(btnCustomer);
		
		JButton btnSales = new JButton("Sales");
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sales Button Clicked");
				SalesFrame.main(null);
			}
		});
		btnSales.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnSales.setBounds(134, 105, 129, 23);
		contentPane.add(btnSales);
		
		JButton btnMembers = new JButton("Members");
		btnMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Members Button Clicked");
				MembersFrame.main(null);
			}
		});
		btnMembers.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnMembers.setBounds(138, 139, 129, 23);
		contentPane.add(btnMembers);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menu Button Clicked");
				MenuFrame.main(null);
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnMenu.setBounds(138, 173, 129, 23);
		contentPane.add(btnMenu);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Logout Button Clicked" );
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnLogout.setBounds(138, 208, 129, 23);
		contentPane.add(btnLogout);
		
	}
}
