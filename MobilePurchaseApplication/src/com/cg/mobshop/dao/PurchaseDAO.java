package com.cg.mobshop.dao;

import java.util.ArrayList;

import com.cg.mobshop.dto.Mobile;
import com.cg.mobshop.dto.PurchaseDetails;
import com.cg.mobshop.exception.PurchaseException;

public interface PurchaseDAO {

	
	public int addPurchaseDetails(PurchaseDetails pr) throws PurchaseException;
	public  ArrayList<Mobile> getMobileList() throws PurchaseException;
	public ArrayList<Mobile> getMobileList(int min,int max) throws PurchaseException;
	public Mobile updateMobileDetails(Mobile mob) throws PurchaseException;

}
