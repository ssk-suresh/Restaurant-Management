package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbutil.DBConnection;
import com.model.Menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
//import java.lang.Double;

public class MenuFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	Connection con;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	String query;
	int count=0;
	Menu menuObj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\RestaurantManagement\\images\\menu.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(227, 11, 86, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("Product_Id");
		lblId.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblId.setBounds(69, 72, 123, 23);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Product_Name");
		lblName.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblName.setBounds(69, 120, 145, 23);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblPrice.setBounds(69, 166, 102, 17);
		contentPane.add(lblPrice);
		
		txtId = new JTextField();
		txtId.setToolTipText("Enter Product Id");
		txtId.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtId.setBounds(242, 75, 183, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtName.setToolTipText("Enter Product Name");
		txtName.setBounds(242, 117, 183, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setToolTipText("Enter Product Price");
		txtPrice.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtPrice.setBounds(242, 166, 183, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnAdd.setBounds(26, 227, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Save Button Clicked");
				con = DBConnection.getConnection();
				query = "SELECT * MAX(PRODUCT_ID) FROM MENU";
				stmt = null;
				menuObj = new Menu();
				if (txtId.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Product ID Cannot Empty", "Error",JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
				}
				else if (txtName.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Product Name Cannot Empty", "Error",JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
				}
				
				else if (txtPrice.getText().equals("")) 
				{
				JOptionPane.showMessageDialog(null, "Email Cannot Empty", "Error", JOptionPane.ERROR_MESSAGE);
				txtPrice.requestFocus();
				}
				else
				{
				menuObj.setProduct_Id(txtId.getText());
				menuObj.setProduct_Name(txtName.getText());
				//menuObj.setPrice( txtPrice.getPrice());
				try {
				pst = con.prepareStatement("INSERT INTO MENU(PRODUCT_ID,PRODUCT_NAME,PRICE) "+ "VALUES(?,?,?)");
				pst.setString(1, menuObj.getProduct_Id());
				pst.setString(2, menuObj.getProduct_Name());
				pst.setDouble(3, menuObj.getPrice());
				count=pst.executeUpdate(); 
				 if(count!=0) 
				 {
				 
				JOptionPane.showMessageDialog(null,count+" New Menu Added...","Success",JOptionPane.INFORMATION_MESSAGE);
				 } 
				 else
				 {
				 JOptionPane.showMessageDialog(null," Menu Added Failed","Error",JOptionPane.ERROR_MESSAGE);
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
		btnSave.setBounds(125, 227, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("View Menu Clicked");
				ViewMenu viewMenu= new ViewMenu();
				viewMenu.setVisible(true);

			}
		});
		btnView.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnView.setBounds(224, 227, 89, 23);
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
				confirmation=JOptionPane.showConfirmDialog(null, "Menu Confirm Delete...?","Delete Menu",JOptionPane.YES_NO_OPTION);
				if(confirmation==0)
				{
				query="DELETE FROM MENU WHERE PRODUCT_ID=?";
				try {
				pst=con.prepareStatement(query);
				pst.setString(1,txtId.getText());
				count=pst.executeUpdate();
				if(count!=0)
				{
				JOptionPane.showMessageDialog(null, "Menu Deleted...","Delete Menu",JOptionPane.INFORMATION_MESSAGE);
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
		btnDelete.setBounds(323, 227, 89, 23);
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
		btnClose.setBounds(419, 227, 89, 23);
		contentPane.add(btnClose);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 205, 514, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 47, 514, 2);
		contentPane.add(separator_1);
	}

}
