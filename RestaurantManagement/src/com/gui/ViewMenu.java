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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewMenu extends JFrame {

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
					ViewMenu frame = new ViewMenu();
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
	public ViewMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 190, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Menu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(219, 22, 123, 26);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtSearch.setBounds(38, 74, 417, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSeach = new JButton("Search");
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeach.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnSeach.setBounds(469, 73, 89, 23);
		contentPane.add(btnSeach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 119, 417, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Product_Id", "Product_Name", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnDetails = new JButton("Get Details");
		btnDetails.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnDetails.setBounds(117, 308, 123, 23);
		contentPane.add(btnDetails);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
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
		btnCancel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnCancel.setBounds(321, 308, 89, 23);
		contentPane.add(btnCancel);
	}

}
