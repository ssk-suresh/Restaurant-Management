package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import java.awt.Color;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SSK SURESH\\Desktop\\NEW\\images\\images.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200,450, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(183, 11, 115, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblUser = new JLabel("User_Name");
		lblUser.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblUser.setBounds(46, 59, 115, 26);
		contentPane.add(lblUser);
		
		JLabel lblPwd = new JLabel("Password");
		lblPwd.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblPwd.setBounds(46, 114, 94, 21);
		contentPane.add(lblPwd);
		
		txtUser = new JTextField();
		txtUser.setToolTipText("Enter your User Name");
		txtUser.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtUser.setBounds(183, 62, 166, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPwd = new JTextField();
		txtPwd.setToolTipText("Enter your Password");
		txtPwd.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtPwd.setBounds(183, 111, 166, 26);
		contentPane.add(txtPwd);
		txtPwd.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnLogin.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
			String username=txtUser.getText();
			//@SuppressWarnings("deprecation")
			String password=txtPwd.getText();
			if(username.contains("inmakes") && password.contains("1234")) {
				lblUser.setText(null);
				lblPwd.setText(null);
			@SuppressWarnings("unused")
			AdminActivity info=new AdminActivity();
			AdminActivity.main(null);
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid UserName or Password","Login",JOptionPane.ERROR_MESSAGE);
				lblUser.setText(null);
				lblPwd.setText(null);
			}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnLogin.setBounds(97, 171, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLogin = new JFrame("Cancel");
			if(JOptionPane.showConfirmDialog(frmLogin, "Cofirm you want to Cancel ","Login",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				System.exit(0);
				
			}
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnCancel.setBounds(241, 171, 89, 23);
		contentPane.add(btnCancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 42, 369, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 158, 369, 2);
		contentPane.add(separator_1);
	}
}
