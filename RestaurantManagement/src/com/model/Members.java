package com.model;

import java.util.Date;

public class Members 
{
	private String Customer_Id;
	private Date Join_Date;
	
	public Members() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}

	public Date getJoin_Date() {
		return Join_Date;
	}

	public void setJoin_Date(Date join_Date) {
		Join_Date = join_Date;
	}

}
