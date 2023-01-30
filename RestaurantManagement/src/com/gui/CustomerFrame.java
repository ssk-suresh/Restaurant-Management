package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dbutil.DBConnection;
import com.model.Customer;

public class CustomerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rdoMale = null;
	private JRadioButton rdoFemale = null;
	private JTextArea txtArea = null;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtMail;
	private JTextField txtMobileno;
	Connection con;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	Customer customerObj;
	String query;
	private static int sequential_ID = 1000;
	int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SSK SURESH\\Desktop\\NEW\\images\\page3-img6.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 350, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(282, 11, 117, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblid = new JLabel("Customer_Id");
		lblid.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblid.setBounds(67, 58, 117, 26);
		contentPane.add(lblid);
		
		JLabel lblName = new JLabel("Customer_Name");
		lblName.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblName.setBounds(67, 99, 151, 26);
		contentPane.add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblGender.setBounds(67, 141, 117, 20);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email_Id");
		lblEmail.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblEmail.setBounds(67, 180, 122, 26);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblAddress.setBounds(67, 225, 133, 20);
		contentPane.add(lblAddress);
		
		JLabel lblMobileno = new JLabel("Mobile_Number");
		lblMobileno.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblMobileno.setBounds(67, 263, 133, 20);
		contentPane.add(lblMobileno);
		
		txtId = new JTextField();
		txtId.setToolTipText("Enter Customer Id");
		txtId.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtId.setBounds(266, 63, 246, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter Customer Name");
		txtName.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtName.setBounds(266, 104, 246, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setBackground(new Color(170, 190, 215));
		rdoMale.setToolTipText("Select");
		rdoMale.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		rdoMale.setBounds(290, 140, 109, 23);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setBackground(new Color(170, 190, 215));
		rdoFemale.setToolTipText("Select");
		rdoFemale.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		rdoFemale.setBounds(401, 140, 109, 23);
		contentPane.add(rdoFemale);
		
		txtMail = new JTextField();
		txtMail.setToolTipText("Enter Customer Mail Id");
		txtMail.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtMail.setBounds(266, 183, 246, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setToolTipText("Enter Customer Address");
		txtArea.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtArea.setBounds(266, 225, 246, 22);
		contentPane.add(txtArea);
		
		txtMobileno = new JTextField();
		txtMobileno.setToolTipText("Enter Customer Mobile Number");
		txtMobileno.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtMobileno.setBounds(266, 265, 246, 20);
		contentPane.add(txtMobileno);
		txtMobileno.setColumns(10);
		
		
		
		JButton btnAdd = new JButton("Add Customer");
		btnAdd.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) 
		{
		con = DBConnection.getConnection();
		query = "SELECT MAX(CUSTOMER_ID) FROM CUSTOMER";
		stmt = null;
		customerObj = new Customer();
		try {
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		if (rs.getString(1) == null) 
		{
		System.out.println("No Record");
		customerObj.setCustomer_Id("C#"+sequential_ID);
		txtId.setText(customerObj.getCustomer_Id());
		} 
		else 
		{
		int sequential_ID = Integer.parseInt(rs.getString(1).substring(2, rs.getString(1).length())) + 1;
		customerObj.setCustomer_Id("C#"+sequential_ID);
		txtId.setText(customerObj.getCustomer_Id());
		con.rollback();
		System.out.println("Record Add Successfully");
		}
		} 
		catch (SQLException e1) 
		{
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		resetControls();
		}

		private void resetControls() {
			// TODO Auto-generated method stub
			
		}
		});
 
		btnAdd.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnAdd.setBounds(10, 316, 147, 23);
		contentPane.add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Save Button Clicked");
				con = DBConnection.getConnection();
				query = "SELECT * MAX(CUSTOMER_ID) FROM CUSTOMER";
				stmt = null;
				customerObj = new Customer();
				if (txtId.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Customer ID Cannot Empty", "Error",JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
				}
				else if (txtName.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Customer Name Cannot Empty", "Error",JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
				}
				
				else if (txtMail.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Email Cannot Empty", "Error", JOptionPane.ERROR_MESSAGE);
				txtMail.requestFocus();
				}
				else if (txtArea.getText().equals("")) {JOptionPane.showMessageDialog(null, "Address Cannot Empty", "Error", JOptionPane.ERROR_MESSAGE);
				txtArea.requestFocus();
				} 
				else if (txtMobileno.getText().equals(""))
				{
				JOptionPane.showMessageDialog(null, "Mobile Number Cannot Empty", "Error",JOptionPane.ERROR_MESSAGE);
				txtMobileno.requestFocus();
				} 
				else if (txtMobileno.getText().length() < 10) 
				{
				JOptionPane.showMessageDialog(null, "Mobile Number requires 10 digits", "Error",JOptionPane.ERROR_MESSAGE);
				txtMobileno.requestFocus();
				} 
				else
				{
				customerObj.setCustomer_Id(txtId.getText());
				customerObj.setCustomer_Name(txtName.getText());
				customerObj.setGender(rdoMale.isSelected() ? "Male" : "Female");
				customerObj.setEmail(txtMail.getText());
				customerObj.setAddress(txtArea.getText());
				customerObj.setMobile_Number(Long.parseLong(txtMobileno.getText()));
				try {
				pst = con.prepareStatement("INSERT INTO CUSTOMER (CUSTOMER_ID,CUSTOMER_NAME,GENDER,EMAIL,ADDRESS,MOBILE_NUMBER) "+ "VALUES(?,?,?,?,?,?)");
				pst.setString(1, customerObj.getCustomer_Id());
				pst.setString(2, customerObj.getCustomer_Name());
				pst.setString(3, customerObj.getGender());
				pst.setString(4, customerObj.getEmail());
				pst.setString(5, customerObj.getAddress());
				pst.setLong(6, customerObj.getMobile_Number());
				count=pst.executeUpdate(); 
				 if(count!=0) 
				 {
				 
				JOptionPane.showMessageDialog(null,count+" New Customer Added...","Success",JOptionPane.INFORMATION_MESSAGE);
				 
				 } 
				 else
				 {
				 JOptionPane.showMessageDialog(null," Record Insertion Failed","Error",JOptionPane.ERROR_MESSAGE);
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
		btnSave.setBounds(167, 316, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnView = new JButton("View Customer");
		btnView.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("View Customer Clicked");
				ViewCustomer viewCustomer = new ViewCustomer();
				viewCustomer.setVisible(true);
			}
		});
		btnView.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnView.setBounds(266, 316, 151, 23);
		contentPane.add(btnView);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Delete Button Clicked");
				if(!txtId.getText().equals(""))
				{
				int
				confirmation=JOptionPane.showConfirmDialog(null, "Customer Confirm Delete...?","Delete Customer",JOptionPane.YES_NO_OPTION);
				if(confirmation==0)
				{
				query="DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?";
				try {
				pst=con.prepareStatement(query);
				pst.setString(1, txtId.getText());
				count=pst.executeUpdate();
				if(count!=0)
				{
				JOptionPane.showMessageDialog(null, "Customer Deleted...","Delete Customer",JOptionPane.INFORMATION_MESSAGE);
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
		btnDelete.setBounds(436, 316, 89, 23);
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
		btnClose.setBounds(535, 316, 89, 23);
		contentPane.add(btnClose);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 296, 614, 0);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 45, 614, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 303, 614, 2);
		contentPane.add(separator_1_1);
	}
	public List<Customer> getCustomerDetails() 
	{
		List<Customer> customerList = new ArrayList<Customer>();
		try 
		{
			con = DBConnection.getConnection();
			query = "SELECT * FROM CUSTOMER";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) 
			{
				Customer customerObj = new Customer();
				customerObj.setCustomer_Id(rs.getString("CUSTOMER_ID"));
				customerObj.setCustomer_Name(rs.getString("CUSTOMER_NAME"));
				customerObj.setGender(rs.getString("GENDER"));
				customerObj.setEmail(rs.getString("EMAIL"));
				customerObj.setAddress(rs.getString("ADDRESS"));
				customerObj.setMobile_Number(rs.getLong("MOBILE_NUMBER"));
				customerList.add(customerObj);
		   }
			} 
		catch (SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
		return customerList;
		}
	public void getCustomerDetailById(String customerId)
	{
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			con = DBConnection.getConnection();
			query = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID=?";
			pst = con.prepareStatement(query);
			pst.setString(1, customerId);
			rs = pst.executeQuery();
			while (rs.next()) {
				Customer customerObj = new Customer();
				customerObj.setCustomer_Id(rs.getString("CUSTOMER_ID"));
				customerObj.setCustomer_Name(rs.getString("CUSTOMER_NAME"));
				customerObj.setGender(rs.getString("GENDER"));
				customerObj.setEmail(rs.getString("EMAIL"));
				customerObj.setAddress(rs.getString("ADDRESS"));
				customerObj.setMobile_Number(rs.getLong("MOBILE_NUMBER"));
				customerList.add(customerObj);
				}
			txtId.setText(customerList.get(0).getCustomer_Id());
			txtName.setText(customerList.get(0).getCustomer_Name());
			String gender = customerList.get(0).getGender();
			if (gender.equalsIgnoreCase("Male"))
				rdoMale.setSelected(true);
			else
				rdoFemale.setSelected(true);
			txtArea.setText(customerList.get(0).getAddress());
			txtMobileno.setText(Long.toString(customerList.get(0).getMobile_Number()));
			txtMail.setText(customerList.get(0).getEmail());
			}
		catch (SQLException sqle) 
		{
			System.out.println(sqle.getMessage());
		}
		}
		@SuppressWarnings("unused")
		private void resetControls() {
		txtName.setText("");
		rdoMale.setSelected(true);
		txtArea.setText("");
		txtMobileno.setText("");
		txtMail.setText("");
		txtName.requestFocus();
		}


}
