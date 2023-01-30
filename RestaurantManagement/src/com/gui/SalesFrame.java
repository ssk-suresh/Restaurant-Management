package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import com.dbutil.DBConnection;
import com.model.Sales;
import com.toedter.calendar.JDateChooser;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class SalesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtProductid;
	Connection con;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	int count=0;
	String query;
	Sales salesObj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesFrame frame = new SalesFrame();
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
	public SalesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(239, 11, 133, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("Customer_Id");
		lblId.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblId.setBounds(69, 74, 131, 33);
		contentPane.add(lblId);
		
		JLabel lblOrderdate = new JLabel("Oreder_Date");
		lblOrderdate.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblOrderdate.setBounds(69, 127, 131, 20);
		contentPane.add(lblOrderdate);
		
		JLabel lblProductid = new JLabel("Product_Id");
		lblProductid.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblProductid.setBounds(69, 172, 141, 20);
		contentPane.add(lblProductid);
		
		txtId = new JTextField();
		txtId.setToolTipText("Enter Customer Id");
		txtId.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtId.setBounds(220, 80, 222, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		dateChooser.setBounds(220, 127, 222, 20);
		contentPane.add(dateChooser);
		
		txtProductid = new JTextField();
		txtProductid.setToolTipText("Enter Product Id");
		txtProductid.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtProductid.setBounds(220, 172, 222, 20);
		contentPane.add(txtProductid);
		txtProductid.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//con=new Connection();
					//SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
					//pst.setDate(2, new Date(sdf.getCalendar()));
					count=executedUpdate();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnAdd.setBounds(10, 227, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnSave.setBounds(111, 227, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println(" Click ViewSales ");
				ViewSales viewSales = new ViewSales();
				viewSales.setVisible(true);
			}
		});
		btnView.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnView.setBounds(217, 227, 89, 23);
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
				confirmation=JOptionPane.showConfirmDialog(null, "Sales Confirm Delete...?","Delete Sales",JOptionPane.YES_NO_OPTION);
				if(confirmation==0)
				{
				query="DELETE FROM SALES WHERE CUSTOMER_ID=?";
				try {
				pst=con.prepareStatement(query);
				pst.setString(1, 
				txtId.getText());
				count=pst.executeUpdate();
				if(count!=0)
				{
				JOptionPane.showMessageDialog(null, "Sales Deleted...","Delete Sales",JOptionPane.INFORMATION_MESSAGE);
				}
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnDelete.setBounds(329, 227, 89, 23);
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
		btnClose.setBounds(428, 227, 89, 23);
		contentPane.add(btnClose);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 210, 514, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 50, 514, 2);
		contentPane.add(separator_1);
		
		
	}

	protected int executedUpdate() {
		// TODO Auto-generated method stub
		return 0;
	}
}
