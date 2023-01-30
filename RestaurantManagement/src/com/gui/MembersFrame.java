package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbutil.DBConnection;
import com.model.Members;
import com.toedter.calendar.JDateChooser;

public class MembersFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	Connection con;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	String query;
	Members memberObj;
	int count=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembersFrame frame = new MembersFrame();
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
	public MembersFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450,300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Members");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(170, 11, 120, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("Customer_Id");
		lblId.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblId.setBounds(62, 84, 130, 19);
		contentPane.add(lblId);
		
		JLabel lblJoindate = new JLabel("Join_Date");
		lblJoindate.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblJoindate.setBounds(62, 141, 130, 23);
		contentPane.add(lblJoindate);
		
		txtId = new JTextField();
		txtId.setToolTipText("Ender Customer Id ");
		txtId.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtId.setBounds(221, 85, 147, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(221, 141, 147, 20);
		contentPane.add(dateChooser);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Save Button Clicked");
				con = DBConnection.getConnection();
				query = "SELECT * MAX(CUSTOMER_ID) FROM CUSTOMER";
				stmt = null;
				memberObj = new Members();
				if (txtId.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Customer ID Cannot Empty", "Error",JOptionPane.ERROR_MESSAGE);
				//txtDate.requestFocus();
				}
				//else if (txtDate.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Join Date Cannot Empty", "Error",JOptionPane.ERROR_MESSAGE);
				//txtDate.requestFocus();
				}
				//else
				{
				memberObj.setCustomer_Id(txtId.getText());
				//memberObj.setJoin_Date(txtDate.getText());
				try {
				pst = con.prepareStatement("INSERT INTO MEMBERS (CUSTOMER_ID,JOIN_DATE) "+ "VALUES(?,?)");
				pst.setString(1, memberObj.getCustomer_Id());
				//pst.setDate(2, memberObj.getJoin_Date());
				count=pst.executeUpdate(); 
				 if(count!=0) 
				 {
				 
				JOptionPane.showMessageDialog(null,count+" New Member Added...","Success",JOptionPane.INFORMATION_MESSAGE);
				 
				 } 
				 else
				 {
				 JOptionPane.showMessageDialog(null," Member Added Failed","Error",JOptionPane.ERROR_MESSAGE);
				 } 
				 
				} 
				catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				} 
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnSave.setBounds(49, 208, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Delete Button Clicked");
				if(!txtId.getText().equals(""))
				{
				int confirmation=JOptionPane.showConfirmDialog(null, "Members Confirm Delete...?","Delete Members",JOptionPane.YES_NO_OPTION);
				if(confirmation==0)
				{
				query="DELETE FROM MEMBERS WHERE CUSTOMER_ID=?";
				try {
				pst=con.prepareStatement(query);
				pst.setString(1, txtId.getText());
				count=pst.executeUpdate();
				if(count!=0)
				{
				JOptionPane.showMessageDialog(null, "Members Deleted...","Delete Member",JOptionPane.INFORMATION_MESSAGE);
				}
				} 
				catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnDelete.setBounds(170, 208, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frmLogin = new JFrame("Close");
				if(JOptionPane.showConfirmDialog(frmLogin, "Cofirm you want to Close ","Close",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
			}
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnClose.setBounds(297, 208, 89, 23);
		contentPane.add(btnClose);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 184, 386, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 54, 386, 2);
		contentPane.add(separator_1);
		
		
	}
}
