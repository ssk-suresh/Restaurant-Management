package com.model;

import java.util.Date;

public class Sales 
{
	private String Customer_Id,Product_Id;
	private Date Order_Date;
	
	public Sales() {
		// TODO Auto-generated constructor stub
	}


	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(String product_Id) {
		Product_Id = product_Id;
	}

	public Date getOrder_Date() {
		return Order_Date;
	}

	public void setOrder_Date(Date Date) {
		Order_Date =Date;
	}


	public void setOrder_Date(String toolTipText) {
		// TODO Auto-generated method stub
		
	}

	
}
