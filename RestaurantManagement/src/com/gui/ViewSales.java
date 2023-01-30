package com.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSales extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSales frame = new ViewSales();
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
	public ViewSales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ViewSales");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(225, 26, 117, 26);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtSearch.setBounds(36, 73, 412, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnSearch.setBounds(463, 74, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnDetails = new JButton("Get Details");
		btnDetails.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnDetails.setBounds(113, 304, 117, 23);
		contentPane.add(btnDetails);
		
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
		btnClose.setBounds(291, 306, 89, 23);
		contentPane.add(btnClose);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 117, 412, 165);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Customer_Id", "Order_Date", "Product_Id"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(73);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		scrollPane_1.setViewportView(table);
	}
}
